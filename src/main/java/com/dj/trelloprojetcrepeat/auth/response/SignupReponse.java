package com.dj.trelloprojetcrepeat.auth.response;

import lombok.Getter;

@Getter
public class SignupReponse {
    private final Long userId;
    private final String userName;
    private final String email;
    private final String userRole;

    public SignupReponse(Long userId, String userName, String email, String userRole){
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.userRole = userRole;
    }

}
