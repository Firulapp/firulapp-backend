package com.github.firulapp.service;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.dto.AppUserDeviceDto;

public interface AppUserDeviceService {

    AppUserDeviceDto saveUserDevice(Long userId);

    AppUserDeviceDto getByIdAndUserIdIfNotDisassociated(Long Id, Long userId);
}
