package com.github.firulapp.service;

import com.github.firulapp.dto.AppUserDeviceDto;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.RegisterAppUserDto;
import com.github.firulapp.exceptions.AppUserException;

public interface AppUserService {

    AppUserDto registerUser(RegisterAppUserDto registerUserDto) throws AppUserException;

    Boolean userLogin(AppUserDto userDto) throws AppUserException;

    void userLogout(AppUserDeviceDto userDeviceDto) throws AppUserException;
}
