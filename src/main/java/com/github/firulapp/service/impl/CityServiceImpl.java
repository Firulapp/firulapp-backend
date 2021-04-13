package com.github.firulapp.service.impl;

import com.github.firulapp.domain.City;
import com.github.firulapp.dto.CityDto;
import com.github.firulapp.exceptions.CityException;
import com.github.firulapp.mapper.impl.CityMapper;
import com.github.firulapp.repository.CityRepository;
import com.github.firulapp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDto> getAllCities() {
        return cityMapper.mapAsList(cityRepository.findAll());
    }

    @Override
    public List<CityDto> getCitiesByCountry(String country) {
        return cityMapper.mapAsList(cityRepository.findByCountry(country));
    }

    @Override
    public List<CityDto> getCitiesByDistrictAndCountry(String district, String country) {
        return cityMapper.mapAsList(cityRepository.findByCountryAndDistrict(country, district));
    }

    @Override
    public CityDto getCityById(Long id) throws CityException {
        Optional<City> city = cityRepository.findById(id);
        return city.map(c -> cityMapper.mapToDto(city.get())).orElseThrow(CityException.notFound(id));
    }

    @Override
    public CityDto saveCity(CityDto cityDto) throws CityException {
        if (cityRepository.findByNameAndDistrictAndCountry(cityDto.getName(), cityDto.getDistrict(), cityDto.getCountry()) == null) {
            cityDto.setCreatedAt(LocalDateTime.now());
            return cityMapper.mapToDto(cityRepository.save(cityMapper.mapToEntity(cityDto)));
        } else {
            throw CityException.duplicatedEntry(cityDto.getName(), cityDto.getCountry());
        }
    }

    @Override
    public void deleteCity(CityDto cityDto) {
        Optional<City> city = cityRepository.findById(cityDto.getId());
        city.ifPresent(c -> cityRepository.delete(city.get()));
    }
}
