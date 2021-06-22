package com.github.firulapp.repository;

import com.github.firulapp.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization findByUserId(Long userId);
}
