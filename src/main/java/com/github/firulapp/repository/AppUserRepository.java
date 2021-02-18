package com.github.firulapp.repository;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.dto.AppUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AppUserRepository extends JpaRepository<AppUser, AppUserDTO> {

    AppUser findByUsername(String username);
}
