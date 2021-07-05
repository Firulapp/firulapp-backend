package com.github.firulapp.web.controller;

import com.github.firulapp.constants.ApiPaths;
import com.github.firulapp.dto.ServiceAppointmentDto;
import com.github.firulapp.dto.ServiceDetailsDto;
import com.github.firulapp.dto.ServiceFilterDto;
import com.github.firulapp.exceptions.ServiceAppointmentException;
import com.github.firulapp.exceptions.ServiceEntityException;
import com.github.firulapp.service.ServiceAppointmentService;
import com.github.firulapp.service.ServiceService;
import com.github.firulapp.web.response.ListResponseDTO;
import com.github.firulapp.web.response.ObjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {ApiPaths.SERVICE_URL})
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceAppointmentService appointmentService;

    @GetMapping(value = ApiPaths.SERVICE_ALL)
    public ResponseEntity<ListResponseDTO> getAllServices(){
        return ResponseEntity.ok(ListResponseDTO.success(serviceService.getAllServices()));
    }

    @PostMapping(value = ApiPaths.SERVICE_SAVE)
    public ResponseEntity<ObjectResponseDTO> saveService(@RequestBody ServiceDetailsDto serviceDetailsDto){
        return ResponseEntity.ok(ObjectResponseDTO.success(serviceService.saveService(serviceDetailsDto)));
    }

    @GetMapping(value = ApiPaths.ID)
    public ResponseEntity<ObjectResponseDTO> getServiceById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(ObjectResponseDTO.success(serviceService.getServiceById(id)));
        } catch (ServiceEntityException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = ApiPaths.SERVICE_BY_TYPE)
    public ResponseEntity<ListResponseDTO> getServicesByServiceTypeId(@PathVariable Long id){
        return ResponseEntity.ok(ListResponseDTO.success(serviceService.getServicesByServiceType(id)));
    }

    @GetMapping(value = ApiPaths.SERVICE_BY_USER)
    public ResponseEntity<ListResponseDTO> getServicesByUserId(@PathVariable Long id){
        return ResponseEntity.ok(ListResponseDTO.success(serviceService.getServicesByUserId(id)));
    }

    @PostMapping(value = ApiPaths.SERVICE_FILTER)
    public ResponseEntity<ListResponseDTO> getServicesByFilters(@RequestBody ServiceFilterDto filterDto){
        return ResponseEntity.ok(ListResponseDTO.success(serviceService.getServicesByFilter(filterDto)));
    }

    @DeleteMapping(value = ApiPaths.ID)
    public ResponseEntity<Void> deleteService(@PathVariable Long id){
        try {
            serviceService.deleteService(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (ServiceEntityException exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.SERVICE_APPOINTMENT_ENDPOINTS)
    public ResponseEntity<ObjectResponseDTO> saveServiceAppointment(@RequestBody ServiceAppointmentDto serviceAppointmentDto){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(appointmentService.saveServiceAppointment(serviceAppointmentDto)));
        } catch (ServiceAppointmentException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = ApiPaths.SERVICE_APPOINTMENT_BY_SERVICE_USER_PET)
    public ResponseEntity<ObjectResponseDTO> getServiceAppointmentByServiceIdAndUserIdAndPetId(@PathVariable(name = "serviceId") Long serviceId,
                                                                                               @PathVariable(name = "userId") Long userId,
                                                                                               @PathVariable(name = "petId") Long petId) {
        return ResponseEntity.ok(ObjectResponseDTO
                .success(
                        appointmentService.getServiceAppointmentsByServiceIdAndUserIdAndPetId(serviceId, userId, petId))
        );
    }

    @PostMapping(value = ApiPaths.SERVICE_APPOINTMENT_CANCEL)
    public ResponseEntity<ObjectResponseDTO> cancelAppointment(@PathVariable(name = "serviceAppointmentId") Long serviceAppointmentId,
                                                               @PathVariable(name = "status") String status,
                                                               @PathVariable(name = "modifiedBy") Long modifiedBy){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(appointmentService
                    .updateServiceAppointmentStatus(serviceAppointmentId, status, modifiedBy)));
        } catch (ServiceAppointmentException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }
}
