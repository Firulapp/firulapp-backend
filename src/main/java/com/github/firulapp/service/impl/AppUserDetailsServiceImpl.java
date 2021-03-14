package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppUserDetails;
import com.github.firulapp.dto.AppUserDetailsDto;
import com.github.firulapp.dto.AppUserProfile;
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
    public void saveUserDetails(AppUserProfile appUserProfile, Long userId) {
        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setUserId(userId);
        appUserDetails.setName(appUserProfile.getName());
        appUserDetails.setSurname(appUserProfile.getSurname());
        appUserDetails.setBirthDate(appUserProfile.getBirthDate());
        appUserDetails.setCity(appUserProfile.getCity());
        appUserDetails.setDocument(appUserProfile.getDocument());
        appUserDetails.setDocumentType(appUserProfile.getDocumentType());
        appUserDetails.setNotifications(true);
        appUserDetails.setProfilePicture(appUserProfile.getProfilePicture());
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
