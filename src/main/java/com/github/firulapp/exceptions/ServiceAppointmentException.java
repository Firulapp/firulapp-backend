package com.github.firulapp.exceptions;

import com.github.firulapp.dto.ServiceAppointmentDto;

import java.util.function.Supplier;

public class ServiceAppointmentException extends BusinessException implements Supplier<ServiceAppointmentException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "service.appointment.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String DUPLICATED_ENTRY = BASE_ERROR + ".duplicated";

    public ServiceAppointmentException(String errorCode, String message) {
        super(errorCode, message);
    }

    public static ServiceAppointmentException notFound(Long id) {
        return new ServiceAppointmentException(NOT_FOUND, "Servicio con id " + id + " no encontrado");
    }

    public static ServiceAppointmentException appointmentAlreadyExists(ServiceAppointmentDto dto){
        return new ServiceAppointmentException(DUPLICATED_ENTRY, "La mascota con id " + dto.getPetId() + " ya tiene un " +
                                                "turno para el servicio con id " + dto.getServiceId() + " en la fecha " +
                                                dto.getAppointmentDate().toString());
    }

    @Override
    public ServiceAppointmentException get() {
        return null;
    }
}