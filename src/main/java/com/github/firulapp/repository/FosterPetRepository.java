package com.github.firulapp.repository;

import com.github.firulapp.domain.FosterRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FosterPetRepository extends JpaRepository<FosterRegister, Long> {

}
