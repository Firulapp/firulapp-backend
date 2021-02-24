package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.domain.AppUserDevice;
import com.github.firulapp.dto.AppUserDeviceDto;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.mapper.impl.AppUserDeviceMapper;
import com.github.firulapp.repository.AppUserDeviceRepository;
import com.github.firulapp.service.AppUserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppUserDeviceServiceImpl implements AppUserDeviceService {

    @Autowired
    private AppUserDeviceRepository appUserDeviceRepository;

    @Autowired
    private AppUserDeviceMapper userDeviceMapper;

    @Override
    public AppUserDeviceDto saveUserDevice(AppUser appUser) {
        AppUserDevice appUserDevice = new AppUserDevice();

        appUserDevice.setUserId(appUser);
        appUserDevice.setAsociatedAt(LocalDateTime.now());

        return userDeviceMapper.mapToDto(appUserDeviceRepository.save(appUserDevice));
    }
}
