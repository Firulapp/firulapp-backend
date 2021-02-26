package com.github.firulapp.repository;

import com.github.firulapp.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Long> {
}
