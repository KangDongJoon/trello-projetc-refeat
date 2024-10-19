package com.dj.trelloprojetcrepeat.auth.entity;

import com.dj.trelloprojetcrepeat.user.enums.UserRole;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
public class AuthUser {

    private final Long id;
    private final String userName;
    private final String email;
    private final UserRole userRole;
    private final Collection<? extends GrantedAuthority> authorities;

    public AuthUser(Long id, String userName, String email, UserRole userRole) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.userRole = userRole;
        this.authorities = List.of(new SimpleGrantedAuthority(userRole.name()));
    }
}
