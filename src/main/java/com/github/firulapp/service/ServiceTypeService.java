package com.github.firulapp.service;

import com.github.firulapp.dto.ServiceTypeDto;
import com.github.firulapp.exceptions.ServiceTypeException;

import java.util.List;

public interface ServiceTypeService {

    List<ServiceTypeDto> getAllServiceTypes(Integer listStart, Integer listEnd) throws ServiceTypeException;

    ServiceTypeDto getServiceTypeById(Long id) throws ServiceTypeException;

    ServiceTypeDto saveServiceType(ServiceTypeDto serviceTypeDto);
}
