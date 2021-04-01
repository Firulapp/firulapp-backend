package com.github.firulapp.web.controller;

import com.github.firulapp.constants.ApiPaths;
import com.github.firulapp.dto.AppSessionDto;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.AppUserProfileDto;
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
    public ResponseEntity<ObjectResponseDTO> login(@RequestBody AppUserDto appUser) {
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(appUserService.userLogin(appUser)));
        } catch (AppUserException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.REGISTER_URL)
    public ResponseEntity<ObjectResponseDTO> register(@RequestBody AppUserProfileDto appUserProfileDto){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(appUserService.registerUser(appUserProfileDto)));
        } catch (AppUserException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.LOGOUT_URL)
    public ResponseEntity<Void> logout(@RequestBody AppSessionDto appSessionDto){
        appUserService.userLogout(appSessionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = ApiPaths.GET_USER_BY_TYPE)
    public ResponseEntity<ListResponseDTO> getUserByType(@RequestParam String userType) {
        return ResponseEntity.ok(ListResponseDTO.success(appUserService.getUserByType(userType)));
    }

    @GetMapping(ApiPaths.GET_USER_PROFILE_BY_ID)
    public ResponseEntity<ObjectResponseDTO> getProfileById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(appUserService.getUserById(id)));
        } catch (AppUserException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.UPDATE)
    public ResponseEntity<ObjectResponseDTO> updateUser(@RequestBody AppUserProfileDto appUserProfileDto){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(appUserService.updateUser(appUserProfileDto)));
        } catch (AppUserException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }
}
