package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppUserDevice;
import com.github.firulapp.dto.AppUserDeviceDto;
import com.github.firulapp.exceptions.AppUserException;
import com.github.firulapp.mapper.impl.AppUserDeviceMapper;
import com.github.firulapp.repository.AppUserDeviceRepository;
import com.github.firulapp.service.AppUserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppUserDeviceServiceImpl implements AppUserDeviceService {

    @Autowired
    private AppUserDeviceRepository appUserDeviceRepository;

    @Autowired
    private AppUserDeviceMapper userDeviceMapper;

    @Override
    public AppUserDeviceDto saveUserDevice(Long userId) {
        AppUserDevice appUserDevice = new AppUserDevice();

        appUserDevice.setUserId(userId);
        appUserDevice.setAsociatedAt(LocalDateTime.now());

        return userDeviceMapper.mapToDto(appUserDeviceRepository.save(appUserDevice));
    }

    @Override
    public AppUserDeviceDto getByIdAndUserIdIfNotDisassociated(Long id, Long userId) {
        return userDeviceMapper.mapToDto(appUserDeviceRepository.findByIdAndUserIdAndDisassociatedAtIsNull(id, userId));
    }
}
