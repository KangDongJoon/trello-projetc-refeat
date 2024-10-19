package com.dj.trelloprojetcrepeat.auth.controller;

import com.dj.trelloprojetcrepeat.auth.request.LoginRequest;
import com.dj.trelloprojetcrepeat.auth.request.SignupRequest;
import com.dj.trelloprojetcrepeat.auth.response.LoginResponse;
import com.dj.trelloprojetcrepeat.auth.response.SignupReponse;
import com.dj.trelloprojetcrepeat.auth.service.AuthService;
import com.dj.trelloprojetcrepeat.common.reponse.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupReponse>> signup(@Valid @RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
