package com.github.firulapp.service.impl;

import com.github.firulapp.domain.Organization;
import com.github.firulapp.dto.OrganizationDto;
import com.github.firulapp.exceptions.OrganizationException;
import com.github.firulapp.mapper.impl.OrganizationMapper;
import com.github.firulapp.repository.OrganizationRepository;
import com.github.firulapp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public List<OrganizationDto> getAllOrganizations() {
        return organizationMapper.mapAsList(organizationRepository.findAll());
    }

    @Override
    public OrganizationDto getOrganizationByUserId(Long userId) {
        return organizationMapper.mapToDto(organizationRepository.findByUserId(userId));
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        if(organizationDto.getId()==null){
            organizationDto.setCreatedAt(LocalDateTime.now());
        } else{
            organizationDto.setModifiedAt(LocalDateTime.now());
        }
        return organizationMapper.mapToDto(organizationRepository.save(organizationMapper.mapToEntity(organizationDto)));
    }

    @Override
    public void deleteOrganization(Long userId) throws OrganizationException {
        try {
            Organization organization = organizationRepository.findByUserId(userId);
            organizationRepository.delete(organization);
        } catch (Exception e){
            throw OrganizationException.notFoundByUserId(userId);
        }
    }
}
