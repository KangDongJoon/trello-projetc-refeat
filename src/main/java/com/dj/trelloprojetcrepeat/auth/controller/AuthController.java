package com.dj.trelloprojetcrepeat.auth.controller;

import com.dj.trelloprojetcrepeat.auth.entity.AuthUser;
import com.dj.trelloprojetcrepeat.auth.request.LoginRequest;
import com.dj.trelloprojetcrepeat.auth.request.SignupRequest;
import com.dj.trelloprojetcrepeat.auth.request.WithdrawalRequest;
import com.dj.trelloprojetcrepeat.auth.response.LoginResponse;
import com.dj.trelloprojetcrepeat.auth.response.SignupReponse;
import com.dj.trelloprojetcrepeat.auth.service.AuthService;
import com.dj.trelloprojetcrepeat.common.reponse.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupReponse>> signup(@Valid @RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    // 회원탈퇴
    @GetMapping("/withdrawal")
    public ResponseEntity<String> withdrawal(@AuthenticationPrincipal AuthUser authUser, @Valid @RequestBody WithdrawalRequest withdrawalRequest){
        authService.withdrawal(authUser, withdrawalRequest);
        return ResponseEntity.ok("정상적으로 탈퇴되었습니다.");
    }
}
