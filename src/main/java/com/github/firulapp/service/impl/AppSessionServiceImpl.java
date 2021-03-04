package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppSession;
import com.github.firulapp.domain.AppUserDevice;
import com.github.firulapp.dto.AppSessionDto;
import com.github.firulapp.dto.AppUserDeviceDto;
import com.github.firulapp.mapper.impl.AppSessionMapper;
import com.github.firulapp.mapper.impl.AppUserDeviceMapper;
import com.github.firulapp.repository.AppSessionRepository;
import com.github.firulapp.service.AppSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppSessionServiceImpl implements AppSessionService {

    @Autowired
    private AppSessionRepository appSessionRepository;

    @Autowired
    private AppSessionMapper appSessionMapper;

    @Override
    public AppSessionDto initiateSession(Long userId, Long deviceId) {
        AppSession appSession = new AppSession();
        appSession.setUserId(userId);
        appSession.setDeviceId(deviceId);
        appSession.setStartDate(LocalDateTime.now());
        return appSessionMapper.mapToDto(appSessionRepository.save(appSession));
    }

    @Override
    public void updateSession(Long userId) {
        //TODO close session when 30 days passed
    }

    @Override
    public void closeSession(AppSessionDto appSessionDto) {
        AppSession appSession = appSessionRepository.findByUserIdAndDeviceId(appSessionDto.getUserId(), appSessionDto.getDeviceId());

        appSession.setEndDate(LocalDateTime.now());
        appSession.setModifiedAt(LocalDateTime.now());
        appSession.setModifiedBy(appSessionDto.getUserId());

        appSessionRepository.save(appSession);
    }
}
