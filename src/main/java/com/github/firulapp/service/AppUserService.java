package com.github.firulapp.service;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.RegisterAppUserDto;
import com.github.firulapp.exceptions.AppUserException;

public interface AppUserService {

    AppUser registerUser(RegisterAppUserDto registerUserDto) throws AppUserException;

    Boolean userLogin(AppUserDto userDto) throws AppUserException;
}
