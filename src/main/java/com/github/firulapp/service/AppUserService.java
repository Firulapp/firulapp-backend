package com.github.firulapp.service;

import com.github.firulapp.dto.AppSessionDto;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.AppUserProfileDto;
import com.github.firulapp.dto.OrganizationProfileDto;
import com.github.firulapp.exceptions.AppUserException;
import com.github.firulapp.exceptions.EmailUtilsException;
import com.github.firulapp.exceptions.OrganizationException;
import com.github.firulapp.exceptions.OrganizationRequestException;

import java.util.List;

public interface AppUserService {

    AppSessionDto registerUser(AppUserProfileDto registerUserDto) throws AppUserException, OrganizationRequestException;

    AppSessionDto userLogin(AppUserDto userDto) throws AppUserException;

    void userLogout(AppSessionDto appSessionDto);

    List<AppUserDto> getUserByType(String userType);

    AppUserProfileDto getUserById(Long id) throws AppUserException;

    AppUserProfileDto updateUser(AppUserProfileDto registerUserDto) throws AppUserException;

    AppUserDto getUserByUsername(String username) throws AppUserException;

    AppUserDto getUserByEmail(String email) throws AppUserException;

    AppUserDto enableUser(Long organizationRequestId, Long userId) throws AppUserException, OrganizationRequestException, EmailUtilsException;

    AppSessionDto registerOrganization(OrganizationProfileDto organizationProfileDto) throws AppUserException, OrganizationRequestException, OrganizationException;

    OrganizationProfileDto updateOrganizationUser(OrganizationProfileDto organizationProfileDto) throws AppUserException;

    OrganizationProfileDto getOrganizationByUserId(Long userId) throws AppUserException;
}
