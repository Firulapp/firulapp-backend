package com.github.firulapp.repository;

import com.github.firulapp.domain.Breed;
import com.github.firulapp.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BreedRepository extends JpaRepository<Breed, Long> {
    List<Breed> findBySpeciesId(Species species);
}
