package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppUserDetails;
import com.github.firulapp.domain.Breed;
import com.github.firulapp.dto.AppUserDetailsDto;
import com.github.firulapp.dto.AppUserProfileDto;
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
    public AppUserDetailsDto saveUserDetails(AppUserProfileDto appUserProfileDto, Long userId) {
        if(appUserProfileDto.getId() != null){
            AppUserDetails appUserDetails = appUserDetailsRepository.findByUserId(userId);
            appUserDetails.setModifiedAt(LocalDateTime.now());
            return userDetailsMapper.mapToDto(appUserDetailsRepository.save(appUserDetails));
        }else{
            AppUserDetails appUserDetails = new AppUserDetails();
            appUserDetails.setUserId(userId);
            appUserDetails.setName(appUserProfileDto.getName());
            appUserDetails.setSurname(appUserProfileDto.getSurname());
            appUserDetails.setBirthDate(appUserProfileDto.getBirthDate());
            appUserDetails.setCity(appUserProfileDto.getCity());
            appUserDetails.setDocument(appUserProfileDto.getDocument());
            appUserDetails.setDocumentType(appUserProfileDto.getDocumentType());
            appUserDetails.setNotifications(true);
            appUserDetails.setProfilePicture(appUserProfileDto.getProfilePicture());
            appUserDetails.setCreatedAt(LocalDateTime.now());
            return userDetailsMapper.mapToDto(appUserDetailsRepository.save(appUserDetails));
        }
    }

    @Override
    public AppUserDetailsDto updateUserDetails(AppUserDetailsDto appUserDetailsDto, Long modifiedByUserId) {
        AppUserDetails userDetails = userDetailsMapper.mapToEntity(appUserDetailsDto);
        userDetails.setModifiedAt(LocalDateTime.now());
        userDetails.setModifiedBy(modifiedByUserId);
        return userDetailsMapper.mapToDto(appUserDetailsRepository.save(userDetails));
    }

    @Override
    public AppUserDetailsDto getByUserId(Long userId) {
        return userDetailsMapper.mapToDto(appUserDetailsRepository.findByUserId(userId));
    }
}
