package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppSession;
import com.github.firulapp.domain.AppUser;
import com.github.firulapp.domain.AppUserDevice;
import com.github.firulapp.dto.AppUserDeviceDto;
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
    private AppUserDeviceMapper userDeviceMapper;

    @Override
    public void initiateSession(AppUserDeviceDto appUserDeviceDto) {
        AppSession appSession = new AppSession();
        appSession.setUserId(appUserDeviceDto.getUserId());
        appSession.setDeviceId(userDeviceMapper.mapToEntity(appUserDeviceDto));
        appSession.setStartDate(LocalDateTime.now());

        appSessionRepository.save(appSession);
    }

    @Override
    public void updateSession(Long userId) {
        //TODO close session when 30 days passed
    }

    @Override
    public void closeSession(AppUser user, AppUserDevice device) {
        AppSession appSession = appSessionRepository.findByUserIdAndDeviceId(user, device);

        appSession.setEndDate(LocalDateTime.now());
        appSession.setModifiedAt(LocalDateTime.now());
        appSession.setModifiedBy(user.getId());

        appSessionRepository.save(appSession);
    }
}
