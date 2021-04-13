package com.github.firulapp.repository;

import com.github.firulapp.domain.City;
import com.github.firulapp.dto.CityDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByCountry(String country);

    List<City> findByCountryAndDistrict(String country, String district);

    CityDto findByNameAndDistrictAndCountry(String name, String district, String country);
}
