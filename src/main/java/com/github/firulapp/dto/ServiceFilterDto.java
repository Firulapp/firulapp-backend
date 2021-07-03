package com.github.firulapp.dto;

import java.util.ArrayList;

public class ServiceFilterDto {
    private Long serviceTypeId;
    private ArrayList<Long> speciesId;

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public ArrayList<Long> getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(ArrayList<Long> speciesId) {
        this.speciesId = speciesId;
    }
}
