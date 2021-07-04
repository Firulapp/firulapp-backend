package com.github.firulapp.service;

import com.github.firulapp.domain.ServiceSpecies;

import java.util.List;

public interface ServiceSpeciesService {

    List<ServiceSpecies> getSpeciesByServiceId (Long serviceId);

    List<ServiceSpecies> getServicesBySpeciesId(Long speciesId);

    List<ServiceSpecies> getServicesBySpeciesIdList(List<Long> species);

    ServiceSpecies getServiceBySpeciesIdAndServiceId(Long serviceId, Long speciesId);

    List<ServiceSpecies> saveServiceSpeciesByServiceId(Long serviceId, List<Long> speciesIdList);

    void deleteServiceSpecies(Long serviceId);
}
