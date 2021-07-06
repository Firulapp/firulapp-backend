package com.github.firulapp.service;

import com.github.firulapp.dto.ServiceAppointmentDto;
import com.github.firulapp.exceptions.*;

import java.util.List;

public interface ServiceAppointmentService {

    ServiceAppointmentDto saveServiceAppointment(ServiceAppointmentDto serviceAppointmentDto) throws ServiceAppointmentException, AppUserException, ServiceEntityException, EmailUtilsException, PetException;

    ServiceAppointmentDto updateServiceAppointmentStatus(Long serviceAppointmentId, String status, Long modifiedBy) throws ServiceAppointmentException, ServiceEntityException, AppUserException, PetException, EmailUtilsException;

    List<ServiceAppointmentDto> getServiceAppointmentsByServiceId(Long serviceId);

    List<ServiceAppointmentDto> getServiceAppointmentsByUserId(Long userId);

    List<ServiceAppointmentDto> getServiceAppointmentsByPetId(Long petId);

    List<ServiceAppointmentDto> getServiceAppointmentsByServiceIdAndUserIdAndPetId(Long serviceId, Long userId, Long petId);
}
