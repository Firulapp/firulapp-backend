package com.github.firulapp.web.controller;

import com.github.firulapp.constants.ApiPaths;
import com.github.firulapp.dto.ServiceDetailsDto;
import com.github.firulapp.exceptions.ServiceEntityException;
import com.github.firulapp.service.ServiceService;
import com.github.firulapp.web.response.ListResponseDTO;
import com.github.firulapp.web.response.ObjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {ApiPaths.SERVICE_URL})
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping(value = ApiPaths.SERVICE_URL)
    public ResponseEntity<ListResponseDTO> getAllServices(){
        return ResponseEntity.ok(ListResponseDTO.success(serviceService.getAllServices()));
    }

    @PostMapping(value = ApiPaths.SERVICE_URL)
    public ResponseEntity<ObjectResponseDTO> saveService(@RequestBody ServiceDetailsDto serviceDetailsDto){
        return ResponseEntity.ok(ObjectResponseDTO.success(serviceDetailsDto));
    }

    @GetMapping(value = ApiPaths.ID)
    public ResponseEntity<ObjectResponseDTO> getServiceById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(ObjectResponseDTO.success(serviceService.getServiceById(id)));
        } catch (ServiceEntityException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }
}
