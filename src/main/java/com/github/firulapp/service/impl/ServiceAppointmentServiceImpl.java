package com.github.firulapp.service.impl;

import com.github.firulapp.constants.AppointmentStatus;
import com.github.firulapp.domain.ServiceAppointment;
import com.github.firulapp.dto.ServiceAppointmentDto;
import com.github.firulapp.exceptions.ServiceAppointmentException;
import com.github.firulapp.mapper.impl.ServiceAppointmentMapper;
import com.github.firulapp.repository.ServiceAppointmentRepository;
import com.github.firulapp.service.ServiceAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ServiceAppointmentServiceImpl implements ServiceAppointmentService {

    @Autowired
    private ServiceAppointmentMapper mapper;

    @Autowired
    private ServiceAppointmentRepository repository;

    @Override
    public ServiceAppointmentDto saveServiceAppointment(ServiceAppointmentDto serviceAppointmentDto)
            throws ServiceAppointmentException {
        if(!isAppointmentRegistered(serviceAppointmentDto)){
            if(serviceAppointmentDto.getId() != null){
                serviceAppointmentDto.setModifiedAt(LocalDateTime.now());
            } else {
                serviceAppointmentDto.setCreatedAt(LocalDateTime.now());
                serviceAppointmentDto.setStatus(AppointmentStatus.PENDIENTE);
            }
            return mapper.mapToDto(repository.save(mapper.mapToEntity(serviceAppointmentDto)));
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
    public void cancelAppointment(Long serviceAppointmentId)
            throws ServiceAppointmentException {
        Optional<ServiceAppointment> serviceAppointment = repository.findById(serviceAppointmentId);
        if(serviceAppointment.isPresent()){
            repository.delete(serviceAppointment.get());
        }else{
            throw ServiceAppointmentException.notFound(serviceAppointmentId);
        }
    }

    @Override
    public List<ServiceAppointmentDto> getServiceAppointmentsByServiceId(Long serviceId) {
        return mapper.mapAsList(repository.findByServiceId(serviceId));
    }

    @Override
    public List<ServiceAppointmentDto> getServiceAppointmentsByUserId(Long userId) {
        return mapper.mapAsList(repository.findByUserId(userId));
    }

    @Override
    public List<ServiceAppointmentDto> getServiceAppointmentsByPetId(Long petId) {
        return mapper.mapAsList(repository.findByPetId(petId));
    }

    @Override
    public List<ServiceAppointmentDto> getServiceAppointmentsByServiceIdAndUserIdAndPetId(Long serviceId, Long userId, Long petId) {
        return mapper.mapAsList(repository.findByServiceIdAndUserIdAndPetId(serviceId,userId,petId));
    }
}
