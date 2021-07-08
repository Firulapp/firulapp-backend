package com.github.firulapp.service.impl;

import com.github.firulapp.constants.OrganizationRequestStatus;
import com.github.firulapp.domain.OrganizationRequest;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.dto.AppUserProfileDto;
import com.github.firulapp.dto.OrganizationRequestDto;
import com.github.firulapp.exceptions.AppUserException;
import com.github.firulapp.exceptions.EmailUtilsException;
import com.github.firulapp.exceptions.OrganizationException;
import com.github.firulapp.exceptions.OrganizationRequestException;
import com.github.firulapp.mapper.impl.OrganizationRequestMapper;
import com.github.firulapp.repository.OrganizationRequestRepository;
import com.github.firulapp.service.AppUserService;
import com.github.firulapp.service.OrganizationRequestService;
import com.github.firulapp.service.OrganizationService;
import com.github.firulapp.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class OrganizationRequestServiceImpl implements OrganizationRequestService {

    @Autowired
    private OrganizationRequestRepository organizationRequestRepository;

    @Autowired
    private OrganizationRequestMapper organizationRequestMapper;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private OrganizationService organizationService;

    private EmailUtils emailUtils = new EmailUtils();

    @Override
    public List<OrganizationRequestDto> getAllRequests() {
        return organizationRequestMapper.mapAsList(organizationRequestRepository.findAll());
    }

    @Override
    public OrganizationRequestDto getRequestByOrganizationName(String name) {
        return organizationRequestMapper.mapToDto(organizationRequestRepository.findByOrganizationName(name));
    }

    @Override
    public OrganizationRequestDto getRequestByStatus(String status) {
        return organizationRequestMapper.mapToDto(organizationRequestRepository.findByStatus(OrganizationRequestStatus.valueOf(status.toUpperCase(Locale.ROOT))));
    }

    @Override
    public OrganizationRequestDto saveOrganizationRequest(OrganizationRequestDto organizationRequestDto) throws OrganizationRequestException {
        try {
            if (organizationRequestDto.getId() == null) {
                organizationRequestDto.setCreatedAt(LocalDateTime.now());
            } else {
                organizationRequestDto.setModifiedAt(LocalDateTime.now());
            }
            return organizationRequestMapper.mapToDto(organizationRequestRepository.save(organizationRequestMapper.mapToEntity(organizationRequestDto)));
        } catch (Exception e){
            throw OrganizationRequestException.missingData();
        }
    }

    @Override
    public OrganizationRequestDto approveRequest(Long id, Long userId) throws OrganizationRequestException, AppUserException, EmailUtilsException {
        Optional<OrganizationRequest> opt = organizationRequestRepository.findById(id);
        if(opt.isPresent()){
            OrganizationRequest organizationRequest = opt.get();
            organizationRequest.setStatus(OrganizationRequestStatus.APROBADA);
            organizationRequest.setModifiedBy(userId);
            organizationRequest.setModifiedAt(LocalDateTime.now());
            emailUtils.sendOrganizationApprovalNotificationEmail(appUserService.getUserById(organizationRequest.getUserId()));
            AppUserProfileDto profileDto = appUserService.getUserById(organizationRequest.getUserId());
            profileDto.setEnabled(Boolean.TRUE);
            appUserService.updateUser(profileDto);
            return organizationRequestMapper.mapToDto(organizationRequestRepository.save(organizationRequest));
        } else {
            throw OrganizationRequestException.notFound(id);
        }
    }

    @Override
    public OrganizationRequestDto rejectRequest(Long id, Long userId) throws OrganizationRequestException, OrganizationException, AppUserException {
        Optional<OrganizationRequest> opt = organizationRequestRepository.findById(id);
        if(opt.isPresent()){
            OrganizationRequest organizationRequest = opt.get();
            organizationRequest.setStatus(OrganizationRequestStatus.RECHAZADA);
            organizationRequest.setModifiedBy(userId);
            organizationRequest.setModifiedAt(LocalDateTime.now());
            appUserService.rejectOrganization(organizationRequest.getUserId());
            return organizationRequestMapper.mapToDto(organizationRequestRepository.save(organizationRequest));
        } else {
            throw OrganizationRequestException.notFound(id);
        }
    }

    @Override
    public OrganizationRequestDto getRequestById(Long id) throws OrganizationRequestException {
        Optional<OrganizationRequest> opt = organizationRequestRepository.findById(id);
        if(opt.isPresent()) {
            return organizationRequestMapper.mapToDto(opt.get());
        } else {
            throw OrganizationRequestException.notFound(id);
        }
    }
}
