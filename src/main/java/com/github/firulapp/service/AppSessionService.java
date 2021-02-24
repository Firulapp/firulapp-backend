package com.github.firulapp.service;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.domain.AppUserDevice;
import com.github.firulapp.dto.AppUserDeviceDto;

public interface AppSessionService {

    void initiateSession(AppUserDeviceDto appUserDeviceDto);

    void updateSession(Long userId);

    void closeSession(AppUser user, AppUserDevice device);
}
