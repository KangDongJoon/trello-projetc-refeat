package com.dj.trelloprojetcrepeat.user.entity;

import com.dj.trelloprojetcrepeat.user.enums.UserRole;
import com.dj.trelloprojetcrepeat.user.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;


    public User(String username, String email, String encodePassword, UserRole userRole) {
        this.userName = username;
        this.email = email;
        this.password = encodePassword;
        this.userRole = userRole;
    }
}
