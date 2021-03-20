package com.github.firulapp.service;

import com.github.firulapp.dto.AppSessionDto;

public interface AppSessionService {

    AppSessionDto initiateSession(Long userId, Long deviceId);

    void updateSession(Long userId);

    void closeSession(AppSessionDto appSessionDto);
}
