package com.github.firulapp.repository;

import com.github.firulapp.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

    AppUser findByUsernameAndEncryptedPassword(String username, String encryptedPassword);

    AppUser findByEmail(String email);
}
