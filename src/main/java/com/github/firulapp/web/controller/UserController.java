package com.github.firulapp.web.controller;

import com.github.firulapp.constants.ApiPaths;
import com.github.firulapp.dto.AppUserDeviceDto;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.RegisterAppUserDto;
import com.github.firulapp.exceptions.AppUserException;
import com.github.firulapp.service.AppUserService;
import com.github.firulapp.web.response.ListResponseDTO;
import com.github.firulapp.web.response.ObjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author jazvillagra
 */
@Controller
@RequestMapping(value = {ApiPaths.USER_ENDPOINTS_URL})
public class UserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping(value = ApiPaths.LOGIN_URL)
    public ResponseEntity<Boolean> login(@RequestBody AppUserDto appUser) throws AppUserException {
        return ResponseEntity.ok(appUserService.userLogin(appUser));
    }

    @PostMapping(value = ApiPaths.REGISTER_URL)
    public ResponseEntity<ObjectResponseDTO> register(@RequestBody RegisterAppUserDto registerAppUserDto) throws AppUserException{
        return ResponseEntity.ok(ObjectResponseDTO.success(appUserService.registerUser(registerAppUserDto)));
    }

    @PostMapping(value = ApiPaths.LOGOUT_URL)
    public ResponseEntity<Void> logout(@RequestBody AppUserDeviceDto appUserDeviceDto)throws AppUserException{
        appUserService.userLogout(appUserDeviceDto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(value = ApiPaths.GET_BY_TYPE)
    public ResponseEntity<ListResponseDTO> getUserByType(@RequestParam String userType) {
        return ResponseEntity.ok(ListResponseDTO.success(appUserService.getUserByType(userType)));
    }
}
