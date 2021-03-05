package com.github.firulapp.repository;

import com.github.firulapp.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

    AppUser findByUsernameAndEncryptedPassword(String username, String encryptedPassword);

    AppUser findByEmail(String email);

    AppUser findByEmailOrUsername(String email, String username);

    List<AppUser> findByUserType(String userType);
}
