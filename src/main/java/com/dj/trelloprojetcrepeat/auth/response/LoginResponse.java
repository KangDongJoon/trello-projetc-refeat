package com.dj.trelloprojetcrepeat.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private final String bearerToken;
}
