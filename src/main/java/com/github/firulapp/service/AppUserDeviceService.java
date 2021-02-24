package com.github.firulapp.service;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.domain.AppUserDevice;

public interface AppUserDeviceService {

    AppUserDevice saveUserDevice(AppUser appUser);
}
