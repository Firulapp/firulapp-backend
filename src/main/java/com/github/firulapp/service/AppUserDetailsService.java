package com.github.firulapp.service;

import com.github.firulapp.dto.AppUserDetailsDto;
import com.github.firulapp.dto.AppUserProfileDto;

public interface AppUserDetailsService {

    AppUserDetailsDto saveUserDetails(AppUserProfileDto appUserProfileDto, Long userId);

    AppUserDetailsDto updateUserDetails(AppUserDetailsDto appUserDetailsDto, Long modifiedByUserId);

    AppUserDetailsDto getByUserId(Long userId);
}
