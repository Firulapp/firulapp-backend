package com.github.firulapp.service;

import com.github.firulapp.domain.AppUserDevice;

public interface AppSessionService {

    void initiateSession(AppUserDevice appUserDevice);

    void updateSession(Long userId);
}
