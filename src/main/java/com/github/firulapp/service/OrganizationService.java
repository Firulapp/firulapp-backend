package com.github.firulapp.service;

import com.github.firulapp.dto.OrganizationDto;
import com.github.firulapp.exceptions.OrganizationException;

import java.util.List;

public interface OrganizationService {

    List<OrganizationDto> getAllOrganizations();

    OrganizationDto getOrganizationByUserId(Long userId);

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    void deleteOrganization(Long userId) throws OrganizationException;
}
