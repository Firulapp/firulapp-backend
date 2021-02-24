package com.github.firulapp.service;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.dto.AppUserDetailsDto;
import com.github.firulapp.dto.RegisterAppUserDto;

public interface AppUserDetailsService {

    void saveUserDetails(RegisterAppUserDto registerAppUserDto, AppUser userId);

    AppUserDetailsDto updateUserDetails(AppUserDetailsDto appUserDetailsDto, Long modifiedByUserId);
}
