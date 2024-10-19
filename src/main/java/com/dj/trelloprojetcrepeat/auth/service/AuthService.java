package com.dj.trelloprojetcrepeat.auth.service;

import com.dj.trelloprojetcrepeat.auth.request.LoginRequest;
import com.dj.trelloprojetcrepeat.auth.request.SignupRequest;
import com.dj.trelloprojetcrepeat.auth.response.LoginResponse;
import com.dj.trelloprojetcrepeat.auth.response.SignupReponse;
import com.dj.trelloprojetcrepeat.common.exception.CustomException;
import com.dj.trelloprojetcrepeat.common.exception.ErrorCode;
import com.dj.trelloprojetcrepeat.common.reponse.ApiResponse;
import com.dj.trelloprojetcrepeat.config.JwtUtil;
import com.dj.trelloprojetcrepeat.user.entity.User;
import com.dj.trelloprojetcrepeat.user.enums.UserRole;
import com.dj.trelloprojetcrepeat.user.enums.UserStatus;
import com.dj.trelloprojetcrepeat.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    public ApiResponse<SignupReponse> signup(SignupRequest signupRequest) {

        // 비밀번호 암호화
        String encodePassword = passwordEncoder.encode(signupRequest.getPassword());

        // email을 통해 중복 가입 확인
        Optional<User> existingUser = userRepository.findByEmail(signupRequest.getEmail());
        if(existingUser.isPresent()){
            throw new CustomException(ErrorCode.AUTH_USER_EXISTING);
        }

        User user = new User(
                signupRequest.getUserName(),
                signupRequest.getEmail(),
                encodePassword,
                UserRole.of(signupRequest.getUserRole())
        );

        userRepository.save(user);

        SignupReponse signupReponse = new SignupReponse(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getUserRole().toString()
        );

        String message = "회원가입이 성공적으로 완료됐습니다.";
        return new ApiResponse<>(signupReponse, message);
    }

    // 로그인
    public ApiResponse<LoginResponse> login(LoginRequest loginRequest) {

        // email으로 User 가입여부 확인
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.AUTH_USER_NOT_FOUND));

        // 비밀번호 확인
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new CustomException(ErrorCode.AUTH_BAD_REQUEST_PASSWORD);
        }

        // 탈퇴여부 확인
        if(user.getStatus() == UserStatus.DELETED){
            throw new CustomException(ErrorCode.AUTH_USER_DELETED);
        }

        String token = jwtUtil.createToken(
                user.getId(),
                user.getEmail(),
                user.getUserRole()
        );
        LoginResponse loginResponse = new LoginResponse(token);

        String message = String.format("로그인완료, %s님 환영합니다.", user.getUserName());

        return new ApiResponse<>(loginResponse, message);
    }
}
