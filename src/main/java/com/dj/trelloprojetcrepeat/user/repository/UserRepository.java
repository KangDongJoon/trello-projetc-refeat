package com.dj.trelloprojetcrepeat.user.repository;

import com.dj.trelloprojetcrepeat.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
