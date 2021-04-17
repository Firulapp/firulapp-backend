package com.github.firulapp.repository;

import com.github.firulapp.domain.PetActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PetActivityRepository extends JpaRepository<PetActivity, Long> {

    List<PetActivity> findByPetIdOrderByActivityDateDescActivityTimeAsc(Long petId);
}
