package com.github.firulapp.service.impl;

import com.github.firulapp.domain.ServiceSpecies;
import com.github.firulapp.repository.ServiceSpeciesRepository;
import com.github.firulapp.service.ServiceSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceSpeciesServiceImpl implements ServiceSpeciesService {

    @Autowired
    private ServiceSpeciesRepository serviceSpeciesRepository;

    @Override
    public List<ServiceSpecies> getSpeciesByServiceId(Long serviceId) {
        return serviceSpeciesRepository.findByServiceId(serviceId);
    }

    @Override
    public List<ServiceSpecies> getServicesBySpeciesId(Long speciesId) {
        return serviceSpeciesRepository.findBySpeciesId(speciesId);
    }

    @Override
    public List<ServiceSpecies> getServicesBySpeciesIdList(List<Long> species) {
        return serviceSpeciesRepository.findBySpeciesIdIn(species);
    }

    @Override
    public ServiceSpecies getServiceBySpeciesIdAndServiceId(Long serviceId, Long speciesId) {
        return serviceSpeciesRepository.findByServiceIdAndSpeciesId(serviceId, speciesId);
    }

    @Override
    public List<ServiceSpecies> saveServiceSpeciesByServiceId(Long serviceId, List<Long> speciesIdList) {
        List<ServiceSpecies> serviceSpeciesList = new ArrayList<>();
        for (Long id: speciesIdList) {
            ServiceSpecies serviceSpecies = new ServiceSpecies();
            serviceSpecies.setServiceId(serviceId);
            serviceSpecies.setSpeciesId(id);
            serviceSpeciesList.add(serviceSpeciesRepository.save(serviceSpecies));
        }
        return serviceSpeciesList;
    }
}
