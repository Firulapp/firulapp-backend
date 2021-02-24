package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.domain.AppUserDevice;
import com.github.firulapp.repository.AppUserDeviceRepository;
import com.github.firulapp.service.AppUserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppUserDeviceServiceImpl implements AppUserDeviceService {

    @Autowired
    private AppUserDeviceRepository appUserDeviceRepository;

    @Override
    public AppUserDevice saveUserDevice(AppUser appUser) {
        AppUserDevice appUserDevice = new AppUserDevice();

        appUserDevice.setUserId(appUser);
        appUserDevice.setAsociatedAt(LocalDateTime.now());

        return appUserDeviceRepository.save(appUserDevice);
    }
}
