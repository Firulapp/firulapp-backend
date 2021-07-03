package com.github.firulapp.repository;

import com.github.firulapp.domain.ServiceSpecies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceSpeciesRepository extends JpaRepository<ServiceSpecies, Long> {

    List<ServiceSpecies>  findByServiceId(Long serviceId);

    List<ServiceSpecies> findBySpeciesId(Long speciesId);

    List<ServiceSpecies> findBySpeciesIdIn(List<Long> speciesIdList);

    ServiceSpecies findByServiceIdAndSpeciesId(Long serviceId, Long speciesId);
}
