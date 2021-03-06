package com.github.firulapp.service.impl;

import com.github.firulapp.domain.ServiceType;
import com.github.firulapp.dto.ServiceTypeDto;
import com.github.firulapp.exceptions.ServiceTypeException;
import com.github.firulapp.mapper.impl.ServiceTypeMapper;
import com.github.firulapp.repository.ServiceTypeRepository;
import com.github.firulapp.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private ServiceTypeMapper serviceTypeMapper;

    @Override
    public List<ServiceTypeDto> getAllServiceTypes(Integer listStart, Integer listEnd) throws ServiceTypeException {
        List<ServiceTypeDto> allTypes= serviceTypeMapper.mapAsList(serviceTypeRepository.findAll());
        if (listStart != null && listEnd!= null && listEnd != 0) {
            if(allTypes.size() > listEnd) {
                return allTypes.subList(listStart, listEnd);
            }else{
                return allTypes;
            }
        }else{
            throw new ServiceTypeException(ServiceTypeException.BASE_ERROR, "Error al mostrar el listado");
        }
    }

    @Override
    public ServiceTypeDto getServiceTypeById(Long id) throws ServiceTypeException {
        Optional<ServiceType> serviceType = serviceTypeRepository.findById(id);
        return serviceType.map(type -> serviceTypeMapper.mapToDto(type)).orElseThrow(ServiceTypeException.notFound(id));
    }

    @Override
    public ServiceTypeDto saveServiceType(ServiceTypeDto serviceTypeDto) {
        return serviceTypeMapper.mapToDto(serviceTypeRepository.save(serviceTypeMapper.mapToEntity(serviceTypeDto)));
    }
}
