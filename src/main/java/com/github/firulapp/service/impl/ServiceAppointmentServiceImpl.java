package com.github.firulapp.service.impl;

import com.github.firulapp.constants.AppointmentStatus;
import com.github.firulapp.domain.Pet;
import com.github.firulapp.domain.ServiceAppointment;
import com.github.firulapp.dto.AppUserProfileDto;
import com.github.firulapp.dto.PetDto;
import com.github.firulapp.dto.ServiceAppointmentDto;
import com.github.firulapp.dto.ServiceDetailsDto;
import com.github.firulapp.exceptions.*;
import com.github.firulapp.mapper.impl.ServiceAppointmentMapper;
import com.github.firulapp.repository.ServiceAppointmentRepository;
import com.github.firulapp.service.AppUserService;
import com.github.firulapp.service.PetService;
import com.github.firulapp.service.ServiceAppointmentService;
import com.github.firulapp.service.ServiceService;
import com.github.firulapp.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ServiceAppointmentServiceImpl implements ServiceAppointmentService {

    @Autowired
    private ServiceAppointmentMapper mapper;

    @Autowired
    private ServiceAppointmentRepository appointmentRepository;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PetService petService;

    private EmailUtils emailUtils = new EmailUtils();

    @Override
    public ServiceAppointmentDto saveServiceAppointment(ServiceAppointmentDto serviceAppointmentDto)
            throws ServiceAppointmentException, AppUserException, ServiceEntityException, EmailUtilsException, PetException {

        ServiceDetailsDto serviceDetails = serviceService.getServiceById(serviceAppointmentDto.getServiceId());
        AppUserProfileDto client = appUserService.getUserById(serviceAppointmentDto.getUserId());
        AppUserProfileDto serviceUser = appUserService.getUserById(serviceDetails.getServiceDto().getUserId());
        PetDto pet = petService.getPetById(serviceAppointmentDto.getPetId());
        if(!isAppointmentRegistered(serviceAppointmentDto)){
            if(serviceAppointmentDto.getId() != null){
                serviceAppointmentDto.setModifiedAt(LocalDateTime.now());
            } else {
                serviceAppointmentDto.setCreatedAt(LocalDateTime.now());
            }
            ServiceAppointment appointment = appointmentRepository.save(mapper.mapToEntity(serviceAppointmentDto));
            emailUtils.sendAppointmentRegisteredEmail(client, serviceUser, mapper.mapToDto(appointment), pet, serviceDetails.getServiceDto().getTitle());
            return mapper.mapToDto(appointment);
        } else{
            throw ServiceAppointmentException.appointmentAlreadyExists(serviceAppointmentDto);
        }
    }

    private boolean isAppointmentRegistered(ServiceAppointmentDto serviceAppointmentDto) {
        List<ServiceAppointmentDto> appointmentsMade = getServiceAppointmentsByServiceIdAndUserIdAndPetId(
                serviceAppointmentDto.getServiceId(),
                serviceAppointmentDto.getUserId(),
                serviceAppointmentDto.getPetId());
        boolean isAppointmentRegistered = false;
        if(!appointmentsMade.isEmpty()){
            for (ServiceAppointmentDto dto : appointmentsMade) {
                if (dto.getAppointmentDate().atStartOfDay()
                        .equals(serviceAppointmentDto.getAppointmentDate().atStartOfDay())) {
                    isAppointmentRegistered = true;
                    break;
                }
            }
        }
        return isAppointmentRegistered;
    }

    @Override
    public ServiceAppointmentDto updateServiceAppointmentStatus(Long serviceAppointmentId, String status, Long modifiedBy)
            throws ServiceAppointmentException, ServiceEntityException, AppUserException, PetException, EmailUtilsException {
        Optional<ServiceAppointment> serviceAppointment = appointmentRepository.findById(serviceAppointmentId);

        if(serviceAppointment.isPresent()){
            ServiceAppointment appointment = serviceAppointment.get();
            ServiceDetailsDto serviceDetails = serviceService.getServiceById(appointment.getServiceId());
            AppUserProfileDto client = appUserService.getUserById(appointment.getUserId());
            AppUserProfileDto serviceUser = appUserService.getUserById(serviceDetails.getServiceDto().getUserId());
            PetDto pet = petService.getPetById(appointment.getPetId());
            appointment.setStatus(AppointmentStatus.valueOf(status.toUpperCase(Locale.ROOT)));
            appointment.setModifiedBy(modifiedBy);
            appointment.setModifiedAt(LocalDateTime.now());
            if(appointment.getStatus().equals(AppointmentStatus.CANCELADO)){
                emailUtils.sendAppointmentCancelledEmail(client, serviceUser, mapper.mapToDto(appointment), pet, serviceDetails.getServiceDto().getTitle());
            }
            return mapper.mapToDto(appointmentRepository.save(appointment));
        }else{
            throw ServiceAppointmentException.notFound(serviceAppointmentId);
        }
    }

    @Override
    public List<ServiceAppointmentDto> getServiceAppointmentsByServiceId(Long serviceId) {
        return mapper.mapAsList(appointmentRepository.findByServiceId(serviceId));
    }

    @Override
    public List<ServiceAppointmentDto> getServiceAppointmentsByUserId(Long userId) {
        return mapper.mapAsList(appointmentRepository.findByUserId(userId));
    }

    @Override
    public List<ServiceAppointmentDto> getServiceAppointmentsByPetId(Long petId) {
        return mapper.mapAsList(appointmentRepository.findByPetId(petId));
    }

    @Override
    public List<ServiceAppointmentDto> getServiceAppointmentsByServiceIdAndUserIdAndPetId(Long serviceId, Long userId, Long petId) {
        return mapper.mapAsList(appointmentRepository.findByServiceIdAndUserIdAndPetId(serviceId,userId,petId));
    }
}
