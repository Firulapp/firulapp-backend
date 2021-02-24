package com.github.firulapp.service;

import com.github.firulapp.dto.AppUserDeviceDto;

public interface AppSessionService {

    void initiateSession(AppUserDeviceDto appUserDeviceDto);

    void updateSession(Long userId);
}
