package com.github.firulapp.dto;

import java.util.ArrayList;

public class ServiceDetailsDto{

    private ServiceDto serviceDto;
    private ArrayList<Long> species;

    public ServiceDto getServiceDto() {
        return serviceDto;
    }

    public void setServiceDto(ServiceDto serviceDto) {
        this.serviceDto = serviceDto;
    }

    public ArrayList<Long> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<Long> species) {
        this.species = species;
    }
}
