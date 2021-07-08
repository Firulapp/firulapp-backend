package com.github.firulapp.service;

import com.github.firulapp.dto.OrganizationRequestDto;
import com.github.firulapp.exceptions.AppUserException;
import com.github.firulapp.exceptions.EmailUtilsException;
import com.github.firulapp.exceptions.OrganizationException;
import com.github.firulapp.exceptions.OrganizationRequestException;

import java.util.List;

public interface OrganizationRequestService {

    List<OrganizationRequestDto> getAllRequests();

    OrganizationRequestDto getRequestByOrganizationName(String name);

    OrganizationRequestDto getRequestByStatus(String status);

    OrganizationRequestDto saveOrganizationRequest(OrganizationRequestDto organizationRequestDto) throws OrganizationRequestException;

    OrganizationRequestDto approveRequest(Long id, Long userId) throws OrganizationRequestException, AppUserException, EmailUtilsException;

    OrganizationRequestDto rejectRequest(Long id, Long userId) throws OrganizationRequestException, OrganizationException, AppUserException;

    OrganizationRequestDto getRequestById(Long id) throws OrganizationRequestException;
}
