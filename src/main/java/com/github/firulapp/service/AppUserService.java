package com.github.firulapp.service;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.RegisterAppUserDto;
import com.github.firulapp.exceptions.AppUserException;

import java.sql.SQLException;

public interface AppUserService {

    AppUser registerUser(RegisterAppUserDto registerUserDto) throws AppUserException;

    boolean userLogin(AppUserDto user);
}
