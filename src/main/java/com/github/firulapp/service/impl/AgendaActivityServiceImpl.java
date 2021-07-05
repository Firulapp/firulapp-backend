package com.github.firulapp.service.impl;

import com.github.firulapp.dto.*;
import com.github.firulapp.exceptions.AgendaActivityException;
import com.github.firulapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class AgendaActivityServiceImpl implements AgendaActivityService {

    @Autowired
    private PetMedicalRecordService medicalRecordService;

    @Autowired
    private PetVaccinationRecordService vaccinationRecordService;

    @Autowired
    private PetActivityService activityService;

    @Autowired
    private PetService petService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceAppointmentService appointmentService;

    @Override
    public List<AgendaActivityDto> getAgendaActivityByUserId(Long userId) throws AgendaActivityException {
        try {
            List<AgendaActivityDto> userAgenda = new ArrayList<>();
            if(!petService.getPetsByUserId(userId).isEmpty() || petService.getPetsByUserId(userId) == null) {
                List<PetDto> userPets = petService.getPetsByUserId(userId);
                for (PetDto pet : userPets) {
                    List<PetMedicalRecordDto> petMedicalRecords = medicalRecordService.getPetMedicalRecordsByPetId(pet.getId());
                    List<PetVaccinationRecordDto> petVaccinationRecords = vaccinationRecordService.getPetVaccinationRecordsByPetId(pet.getId());
                    List<PetActivityDto> petActivities = activityService.getPetActivitiesByPetId(pet.getId());
                    List<ServiceAppointmentDto> petAppointments = appointmentService.getServiceAppointmentsByPetId(pet.getId());
                    for (PetMedicalRecordDto medicalRecord : petMedicalRecords) {
                        AgendaActivityDto agendaActivity = new AgendaActivityDto();
                        agendaActivity.setUserId(userId);
                        agendaActivity.setPetId(pet.getId());
                        agendaActivity.setPetMedicalRecordId(medicalRecord.getId());
                        agendaActivity.setActivityDate(medicalRecord.getConsultedAt());
                        agendaActivity.setActivityTime(LocalDateTime.of(medicalRecord.getConsultedAt(), LocalTime.of(8, 0)));
                        agendaActivity.setDetails(medicalRecord.getDiagnostic());
                        userAgenda.add(agendaActivity);
                    }
                    for (PetVaccinationRecordDto vaccinationRecord : petVaccinationRecords) {
                        AgendaActivityDto agendaActivity = new AgendaActivityDto();
                        agendaActivity.setUserId(userId);
                        agendaActivity.setPetId(pet.getId());
                        agendaActivity.setPetVaccinationRecordId(vaccinationRecord.getId());
                        agendaActivity.setActivityDate(vaccinationRecord.getVaccinationDate());
                        agendaActivity.setActivityTime(LocalDateTime.of(vaccinationRecord.getVaccinationDate(), LocalTime.of(8, 0)));
                        agendaActivity.setDetails(vaccinationRecord.getVaccine());
                        userAgenda.add(agendaActivity);
                    }
                    for (PetActivityDto petActivity : petActivities) {
                        AgendaActivityDto agendaActivity = new AgendaActivityDto();
                        agendaActivity.setUserId(userId);
                        agendaActivity.setPetId(pet.getId());
                        agendaActivity.setActivityId(petActivity.getId());
                        agendaActivity.setActivityDate(petActivity.getActivityDate());
                        agendaActivity.setActivityTime(petActivity.getActivityTime());
                        agendaActivity.setDetails(petActivity.getActivityTitle());
                        userAgenda.add(agendaActivity);
                    }
                    for(ServiceAppointmentDto dto : petAppointments){
                        AgendaActivityDto agendaActivity = new AgendaActivityDto();
                        agendaActivity.setUserId(userId);
                        agendaActivity.setPetId(dto.getPetId());
                        agendaActivity.setServiceId(dto.getServiceId());
                        agendaActivity.setActivityDate(dto.getAppointmentDate());
                        agendaActivity.setDetails(serviceService.getServiceById(dto.getServiceId()).getServiceDto().getTitle());
                        userAgenda.add(agendaActivity);
                    }
                }
            } else {
                List<ServiceAppointmentDto> appointments = appointmentService.getServiceAppointmentsByUserId(userId);
                if(appointments != null) {
                    for (ServiceAppointmentDto dto : appointments) {
                        AgendaActivityDto agendaActivity = new AgendaActivityDto();
                        agendaActivity.setUserId(userId);
                        agendaActivity.setPetId(dto.getPetId());
                        agendaActivity.setServiceId(dto.getServiceId());
                        agendaActivity.setClientId(dto.getUserId());
                        agendaActivity.setActivityDate(dto.getAppointmentDate());
                        agendaActivity.setDetails(serviceService.getServiceById(dto.getServiceId()).getServiceDto().getTitle());
                        userAgenda.add(agendaActivity);
                    }
                }
            }
            return sortedAgenda(userAgenda);
        }catch (Exception e){
            throw new AgendaActivityException("agenda.error","No se pudo mostrar las actividades");
        }
    }

    private List<AgendaActivityDto> sortedAgenda(List<AgendaActivityDto> userAgenda) {
        Comparator<AgendaActivityDto> activityComparator = Comparator.comparing(AgendaActivityDto::getActivityTime);
        userAgenda.sort(activityComparator);
        return userAgenda;
    }
}
