package com.github.firulapp.repository;

import com.github.firulapp.domain.AppUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserDetailsRepository extends JpaRepository<AppUserDetails, Long> {

    AppUserDetails findByUserId(Long userId);

}
