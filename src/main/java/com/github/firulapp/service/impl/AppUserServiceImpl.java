package com.github.firulapp.service.impl;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.domain.AppUserDevice;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.RegisterAppUserDto;
import com.github.firulapp.exceptions.AppUserException;
import com.github.firulapp.repository.AppUserRepository;
import com.github.firulapp.service.AppSessionService;
import com.github.firulapp.service.AppUserDetailsService;
import com.github.firulapp.service.AppUserDeviceService;
import com.github.firulapp.service.AppUserService;
import io.github.jokoframework.utils.security.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    private AppSessionService appSessionService;

    @Autowired
    private AppUserDeviceService appUserDeviceService;

    @Override
    public AppUser registerUser(RegisterAppUserDto registerUserDto) throws AppUserException{
        if(appUserRepository.findByUsername(registerUserDto.getUsername()) == null){
            if(appUserRepository.findByEmail(registerUserDto.getEmail()) == null) {
                if(registerUserDto.getEncryptedPassword().equals(registerUserDto.getConfirmPassword())) {
                    AppUser userEntity = new AppUser();
                    userEntity.setEmail(registerUserDto.getEmail());
                    userEntity.setUsername(registerUserDto.getUsername());
                    userEntity.setEncryptedPassword(EncryptUtils.hashPassword(registerUserDto.getEncryptedPassword()));
                    //TODO email confirmation, in the meantime all users registered are enabled
                    userEntity.setEnabled(true);
                    userEntity.setLoggedIn(true);

                    appUserRepository.save(userEntity);

                    appUserDetailsService.saveUserDetails(registerUserDto, userEntity);
                    AppUserDevice userDevice = appUserDeviceService.saveUserDevice(userEntity);
                    appSessionService.initiateSession(userDevice);

                    return userEntity;
                }else{
                    throw AppUserException.passwordDoNotMatch();
                }
            }else{
                throw AppUserException.emailRegistered(registerUserDto.getEmail());
            }
        }else{
            throw AppUserException.usernameRegistered(registerUserDto.getUsername());
        }
    }

    @Override
    public boolean userLogin(AppUserDto user) {
        return false;
    }
}
