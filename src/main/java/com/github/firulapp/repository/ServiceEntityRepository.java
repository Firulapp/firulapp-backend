package com.github.firulapp.repository;

import com.github.firulapp.domain.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceEntityRepository extends JpaRepository<ServiceEntity, Long> {

    List<ServiceEntity> findByServiceTypeId(Long serviceTypeId);

    List<ServiceEntity> findByUserId(Long userId);
}
