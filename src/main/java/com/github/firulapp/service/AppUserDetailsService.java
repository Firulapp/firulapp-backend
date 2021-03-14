package com.github.firulapp.service;

import com.github.firulapp.dto.AppUserDetailsDto;
import com.github.firulapp.dto.AppUserProfile;

public interface AppUserDetailsService {

    void saveUserDetails(AppUserProfile appUserProfile, Long userId);

    AppUserDetailsDto updateUserDetails(AppUserDetailsDto appUserDetailsDto, Long modifiedByUserId);
}
