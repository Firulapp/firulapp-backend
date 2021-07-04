package com.github.firulapp.service.impl;

import com.github.firulapp.domain.ServiceEntity;
import com.github.firulapp.domain.ServiceSpecies;
import com.github.firulapp.dto.ServiceDetailsDto;
import com.github.firulapp.dto.ServiceDto;
import com.github.firulapp.dto.ServiceFilterDto;
import com.github.firulapp.exceptions.ServiceEntityException;
import com.github.firulapp.mapper.impl.ServiceMapper;
import com.github.firulapp.repository.ServiceEntityRepository;
import com.github.firulapp.service.ServiceService;
import com.github.firulapp.service.ServiceSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceMapper serviceMapper;

    @Autowired
    private ServiceEntityRepository serviceEntityRepository;

    @Autowired
    private ServiceSpeciesService serviceSpeciesService;

    @Override
    public ServiceDetailsDto saveService(ServiceDetailsDto service) {
        ServiceDto serviceDto = service.getServiceDto();
        if(serviceDto.getId() != null) {
            serviceDto.setModifiedAt(LocalDateTime.now());
            ServiceEntity entity = serviceEntityRepository.save(serviceMapper.mapToEntity(serviceDto));
            ArrayList<Long> species = new ArrayList<>();
            for (ServiceSpecies serviceSpecies : serviceSpeciesService.getSpeciesByServiceId(entity.getId())) {
                species.add(serviceSpecies.getSpeciesId());
            }
            if(species.size() != service.getSpecies().size() || !species.equals(service.getSpecies())){
                serviceSpeciesService.deleteServiceSpecies(entity.getId());
                serviceSpeciesService.saveServiceSpeciesByServiceId(entity.getId(), service.getSpecies());
            }
            service.setServiceDto(serviceMapper.mapToDto(entity));
        }else{
            serviceDto.setCreatedAt(LocalDateTime.now());
            ServiceEntity entity = serviceEntityRepository.save(serviceMapper.mapToEntity(serviceDto));
            serviceSpeciesService.saveServiceSpeciesByServiceId(entity.getId(), service.getSpecies());
            service.setServiceDto(serviceMapper.mapToDto(entity));
        }
        return service;
    }

    @Override
    public List<ServiceDetailsDto> getAllServices() {
        List<ServiceDetailsDto> allServices = new ArrayList<>();
        for (ServiceEntity service: serviceEntityRepository.findAll()) {
            ServiceDetailsDto serviceDetailsDto = new ServiceDetailsDto();
            serviceDetailsDto.setServiceDto(serviceMapper.mapToDto(service));
            serviceDetailsDto.setSpecies(getSpeciesOfServiceIds(service.getId()));
            allServices.add(serviceDetailsDto);
        }
        return allServices;
    }

    @Override
    public List<ServiceDetailsDto> getServicesByFilter(ServiceFilterDto serviceFilterDto) {
        Long serviceTypeId = serviceFilterDto.getServiceTypeId();
        if(serviceFilterDto.getSpeciesId() != null){
            if(!serviceFilterDto.getSpeciesId().isEmpty()) {
                ArrayList<Long> species = serviceFilterDto.getSpeciesId();
                List<ServiceDto> dtos = serviceMapper.mapAsList(serviceEntityRepository
                        .findByServiceTypeIdAndSpecies(serviceTypeId, species));
                List<ServiceDto> uniqueDtos = dtos.stream().distinct().collect(Collectors.toList());
                return getListOfServiceDetails(uniqueDtos);
            }
        }
        return getServicesByServiceType(serviceTypeId);
    }

    @Override
    public ServiceDetailsDto getServiceById(Long id) throws ServiceEntityException {
        ServiceDetailsDto serviceDetailsDto = new ServiceDetailsDto();
        Optional<ServiceEntity> serviceEntity = serviceEntityRepository.findById(id);
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

    @Override
    public List<ServiceDetailsDto> getServicesByServiceType(Long serviceTypeId) {
        return getListOfServiceDetails(serviceMapper.mapAsList(serviceEntityRepository.findByServiceTypeId(serviceTypeId)));
    }

    @Override
    public List<ServiceDetailsDto> getServicesByUserId(Long userId) {
        return getListOfServiceDetails(serviceMapper.mapAsList(serviceEntityRepository.findByUserId(userId)));
    }

    private List<ServiceDetailsDto> getListOfServiceDetails(List<ServiceDto> services) {
        List<ServiceDetailsDto> serviceDetailsList = new ArrayList<>();
        for (ServiceDto dto : services) {
            ServiceDetailsDto serviceDetailsDto = new ServiceDetailsDto();
            serviceDetailsDto.setServiceDto(dto);
            serviceDetailsDto.setSpecies(getSpeciesOfServiceIds(dto.getId()));
            serviceDetailsList.add(serviceDetailsDto);
        }
        return serviceDetailsList;
    }

    @Override
    public void deleteService(Long serviceId) throws ServiceEntityException {
        serviceSpeciesService.deleteServiceSpecies(serviceId);
        serviceEntityRepository.delete(serviceMapper.mapToEntity(getServiceById(serviceId).getServiceDto()));
    }
}
