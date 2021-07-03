package com.github.firulapp.repository;

import com.github.firulapp.constants.OrganizationRequestStatus;
import com.github.firulapp.domain.OrganizationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRequestRepository extends JpaRepository<OrganizationRequest, Long> {

    OrganizationRequest findByOrganizationName(String organizationName);

    OrganizationRequest findByStatus(OrganizationRequestStatus status);
}
