package com.github.firulapp.service;

import com.github.firulapp.dto.ServiceTypeDto;

import java.util.List;

public interface ServiceTypeService {

    List<ServiceTypeDto> getAllServiceTypes();

    ServiceTypeDto getServiceTypeById(Long id);

    ServiceTypeDto saveServiceType(ServiceTypeDto serviceTypeDto);
}
