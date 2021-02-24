package com.github.firulapp.repository;

import com.github.firulapp.domain.AppSession;
import com.github.firulapp.domain.AppUser;
import com.github.firulapp.domain.AppUserDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppSessionRepository extends JpaRepository<AppSession, Long> {

    AppSession findByUserId(Long userId);

    AppSession findByUserIdAndDeviceId(AppUser userId, AppUserDevice deviceId);
}
