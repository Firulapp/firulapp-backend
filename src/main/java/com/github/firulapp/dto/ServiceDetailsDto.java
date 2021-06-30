package com.github.firulapp.dto;

import java.util.ArrayList;

public class ServiceDetailsDto extends ServiceDto{

    private ArrayList<Long> species;

    public ArrayList<Long> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<Long> species) {
        this.species = species;
    }
}
