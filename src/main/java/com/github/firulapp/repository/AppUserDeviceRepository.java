package com.github.firulapp.repository;

import com.github.firulapp.domain.AppUserDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserDeviceRepository extends JpaRepository<AppUserDevice, Long> {

    AppUserDevice findByUserId(Long userId);

    AppUserDevice findByIdAndUserId(Long id, Long userId);
}
