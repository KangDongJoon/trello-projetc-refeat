package com.dj.trelloprojetcrepeat.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupReponse {

    private final Long userId;
    private final String userName;
    private final String email;
    private final String userRole;
}
