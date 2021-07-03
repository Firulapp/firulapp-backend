package com.github.firulapp.service;

import com.github.firulapp.dto.ServiceDetailsDto;
import com.github.firulapp.dto.ServiceFilterDto;
import com.github.firulapp.exceptions.ServiceEntityException;

import java.util.List;

public interface ServiceService {

    ServiceDetailsDto saveService(ServiceDetailsDto service);

    List<ServiceDetailsDto> getAllServices();

    List<ServiceDetailsDto> getServicesByFilter(ServiceFilterDto serviceFilterDto);

    ServiceDetailsDto getServiceById(Long id) throws ServiceEntityException;

    List<ServiceDetailsDto> getServicesByServiceType(Long serviceTypeId);

    List<ServiceDetailsDto> getServicesByUserId(Long userId);
}
