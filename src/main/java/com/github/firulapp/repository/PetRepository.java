package com.github.firulapp.repository;

import com.github.firulapp.constants.PetStatus;
import com.github.firulapp.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByUserId(Long userId);

    List<Pet> findByUserIdAndSpeciesId(Long userId, Long speciesId);

    List<Pet> findByStatus(PetStatus status);
}
