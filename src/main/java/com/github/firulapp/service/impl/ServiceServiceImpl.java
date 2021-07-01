package com.github.firulapp.service.impl;

import com.github.firulapp.domain.ServiceEntity;
import com.github.firulapp.domain.ServiceSpecies;
import com.github.firulapp.dto.ServiceDetailsDto;
import com.github.firulapp.dto.ServiceDto;
import com.github.firulapp.exceptions.ServiceEntityException;
import com.github.firulapp.mapper.impl.ServiceMapper;
import com.github.firulapp.repository.ServiceRepository;
import com.github.firulapp.service.ServiceService;
import com.github.firulapp.service.ServiceSpeciesService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceMapper serviceMapper;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceSpeciesService serviceSpeciesService;

    @Override
    public ServiceDetailsDto saveService(ServiceDetailsDto service) {
        ServiceDto serviceDto = service.getServiceDto();
        if(serviceDto.getId() != null) {
            serviceDto.setModifiedAt(LocalDateTime.now());
        }else{
            serviceDto.setCreatedAt(LocalDateTime.now());
        }
        ServiceEntity entity = serviceRepository.save(serviceMapper.mapToEntity(serviceDto));
        service.setServiceDto(serviceMapper.mapToDto(entity));
        serviceSpeciesService.saveServiceSpeciesByServiceId(entity.getId(), service.getSpecies());
        return service;
    }

    @Override
    public List<ServiceDetailsDto> getAllServices() {
        List<ServiceDetailsDto> allServices = new ArrayList<>();
        for (ServiceEntity service: serviceRepository.findAll()) {
            ServiceDetailsDto serviceDetailsDto = new ServiceDetailsDto();
            serviceDetailsDto.setServiceDto(serviceMapper.mapToDto(service));
            serviceDetailsDto.setSpecies(getSpeciesOfServiceIds(service.getId()));
            allServices.add(serviceDetailsDto);
        }
        return allServices;
    }

    @Override
    public List<ServiceDetailsDto> getServicesByFilter() {
        return null;
    }

    @Override
    public ServiceDetailsDto getServiceById(Long id) throws ServiceEntityException {
        ServiceDetailsDto serviceDetailsDto = new ServiceDetailsDto();
        Optional<ServiceEntity> serviceEntity = serviceRepository.findById(id);
        if(serviceEntity.isPresent()) {
            ServiceDto serviceDto = serviceMapper.mapToDto(serviceEntity.get());
            serviceDetailsDto.setServiceDto(serviceDto);
            serviceDetailsDto.setSpecies(getSpeciesOfServiceIds(id));
            return serviceDetailsDto;
        }else{
            throw ServiceEntityException.notFound(id);
        }
    }

    private ArrayList<Long> getSpeciesOfServiceIds(Long serviceId){
        ArrayList<Long> speciesList = new ArrayList<>();
        for (ServiceSpecies serviceSpecies : serviceSpeciesService.getSpeciesByServiceId(serviceId)) {
            speciesList.add(serviceSpecies.getSpeciesId());
        }
        return speciesList;
    }
}
