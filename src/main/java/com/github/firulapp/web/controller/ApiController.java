package com.github.firulapp.web.controller;

import com.github.firulapp.constants.ApiPaths;
import com.github.firulapp.domain.AppUser;
import com.github.firulapp.dto.AppUserDeviceDto;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.RegisterAppUserDto;
import com.github.firulapp.exceptions.AppUserException;
import com.github.firulapp.service.AppUserService;
import com.github.firulapp.web.response.ObjectResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jazvillagra
 */
@RestController
@RequestMapping("/")
public class ApiController {

    @Autowired
    private AppUserService appUserService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(value = ApiPaths.LOGIN_URL)
    public ResponseEntity<Boolean> login(@RequestBody AppUserDto appUser) throws AppUserException {
        return ResponseEntity.ok(appUserService.userLogin(appUser));
    }

    @PostMapping(value = ApiPaths.REGISTER_URL)
    public ResponseEntity<ObjectResponseDTO> register(@RequestBody RegisterAppUserDto registerAppUserDto) throws AppUserException{
        return ResponseEntity.ok(ObjectResponseDTO.success(appUserService.registerUser(registerAppUserDto)));
    }

    @PostMapping(value = ApiPaths.LOGOUT_URL)
    public void logout(@RequestBody AppUserDeviceDto appUserDeviceDto)throws AppUserException{
        appUserService.userLogout(appUserDeviceDto);
    }
}
