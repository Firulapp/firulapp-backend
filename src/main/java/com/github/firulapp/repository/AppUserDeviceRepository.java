package com.github.firulapp.repository;

import com.github.firulapp.domain.AppUserDevice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserDeviceRepository extends JpaRepository<AppUserDevice, Long> {

    List<AppUserDevice> findByUserId(Long userId);

    AppUserDevice findByIdAndUserId(Long id, Long userId);

    List<AppUserDevice> findByUserIdAndDisassociatedAtIsNull(Long userId);

    AppUserDevice findByIdAndUserIdAndDisassociatedAtIsNull(Long id, Long userId);
}
