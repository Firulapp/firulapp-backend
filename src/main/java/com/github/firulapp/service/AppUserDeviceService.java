package com.github.firulapp.service;

import com.github.firulapp.dto.AppUserDeviceDto;

public interface AppUserDeviceService {

    AppUserDeviceDto saveUserDevice(Long userId);

    AppUserDeviceDto getByIdAndUserIdIfNotDisassociated(Long id, Long userId);
}
