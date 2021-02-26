package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.domain.AppUserDetails;
import com.github.firulapp.dto.AppUserDetailsDto;
import com.github.firulapp.dto.RegisterAppUserDto;
import com.github.firulapp.mapper.impl.AppUserDetailsMapper;
import com.github.firulapp.repository.AppUserDetailsRepository;
import com.github.firulapp.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppUserDetailsServiceImpl implements AppUserDetailsService {

    @Autowired
    private AppUserDetailsRepository appUserDetailsRepository;

    @Autowired
    private AppUserDetailsMapper userDetailsMapper;

    @Override
    public void saveUserDetails(RegisterAppUserDto registerAppUserDto, Long userId) {
        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setUserId(userId);
        appUserDetails.setName(registerAppUserDto.getName());
        appUserDetails.setSurname(registerAppUserDto.getSurname());
        appUserDetails.setBirthDate(registerAppUserDto.getBirthDate());
        appUserDetails.setCity(registerAppUserDto.getCity());
        appUserDetails.setDocument(registerAppUserDto.getDocument());
        appUserDetails.setDocumentType(registerAppUserDto.getDocumentType());
        appUserDetails.setNotifications(true);
        appUserDetails.setProfilePicture(registerAppUserDto.getProfilePicture());
        appUserDetails.setCreatedAt(LocalDateTime.now());
        appUserDetailsRepository.save(appUserDetails);
    }

    @Override
    public AppUserDetailsDto updateUserDetails(AppUserDetailsDto appUserDetailsDto, Long modifiedByUserId) {
        AppUserDetails userDetails = userDetailsMapper.mapToEntity(appUserDetailsDto);
        userDetails.setModifiedAt(LocalDateTime.now());
        userDetails.setModifiedBy(modifiedByUserId);
        return userDetailsMapper.mapToDto(appUserDetailsRepository.save(userDetails));
    }
}
