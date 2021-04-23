package com.github.firulapp.service;

import com.github.firulapp.dto.AgendaActivityDto;
import com.github.firulapp.exceptions.AgendaActivityException;

import java.util.List;

public interface AgendaActivityService {

    List<AgendaActivityDto> getAgendaActivityByUserId(Long userId) throws AgendaActivityException;
}
