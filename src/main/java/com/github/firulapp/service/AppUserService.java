package com.github.firulapp.service;

import com.github.firulapp.dto.AppSessionDto;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.RegisterAppUserDto;
import com.github.firulapp.exceptions.AppUserException;

import java.util.List;

public interface AppUserService {

    AppUserDto registerUser(RegisterAppUserDto registerUserDto) throws AppUserException;

    AppSessionDto userLogin(AppUserDto userDto) throws AppUserException;

    void userLogout(AppSessionDto appSessionDto) throws AppUserException;

    List<AppUserDto> getUserByType(String userType);
}
