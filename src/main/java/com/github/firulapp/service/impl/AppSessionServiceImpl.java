package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppSession;
import com.github.firulapp.domain.AppUserDevice;
import com.github.firulapp.repository.AppSessionRepository;
import com.github.firulapp.service.AppSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppSessionServiceImpl implements AppSessionService {

    @Autowired
    private AppSessionRepository appSessionRepository;

    @Override
    public void initiateSession(AppUserDevice appUserDevice) {
        AppSession appSession = new AppSession();
        appSession.setUserId(appUserDevice.getUserId());
        appSession.setDeviceId(appUserDevice);
        appSession.setStartDate(LocalDateTime.now());

        appSessionRepository.save(appSession);
    }

    @Override
    public void updateSession(Long userId) {

    }
}
