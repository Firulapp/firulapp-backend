package com.github.firulapp.repository;

import com.github.firulapp.domain.ServiceAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceAppointmentRepository extends JpaRepository<ServiceAppointment, Long> {


    List<ServiceAppointment> findByServiceId(Long serviceId);

    List<ServiceAppointment> findByUserId(Long userId);

    List<ServiceAppointment> findByPetId(Long petId);

    List<ServiceAppointment> findByServiceIdAndUserIdAndPetId(Long serviceId, Long userId, Long petId);

}
