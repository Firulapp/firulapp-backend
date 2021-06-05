package com.github.firulapp.web.controller;

import com.github.firulapp.constants.ApiPaths;
import com.github.firulapp.dto.*;
import com.github.firulapp.exceptions.*;
import com.github.firulapp.service.*;
import com.github.firulapp.web.response.ListResponseDTO;
import com.github.firulapp.web.response.ObjectResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(value = {ApiPaths.PET_ENDPOINTS_URL})
public class PetController {

    @Autowired
    private PetService petService;
    @Autowired
    private PetMedicalRecordService petMedicalRecordService;
    @Autowired
    private PetVaccinationRecordService petVaccinationRecordService;
    @Autowired
    private PetActivityService petActivityService;
    @Autowired
    private ReportPetService reportPetService;

    private Logger logger = LoggerFactory.getLogger(PetController.class);

    @GetMapping(value = ApiPaths.GET_PET_BY_USER_ID)
    public ResponseEntity<ListResponseDTO> getPetsByUserId(@PathVariable(name = "userId") Long userId){
        try {
            return ResponseEntity.ok(ListResponseDTO.success(petService.getPetsByUserId(userId)));
        } catch (PetException exception) {
            return new ResponseEntity<>(ListResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = ApiPaths.GET_PET_BY_USER_AND_SPECIES)
    public ResponseEntity<ListResponseDTO> getPetsByUserAndSpecies(@PathVariable(name = "userId") Long userId,
                                                                   @PathVariable(name = "speciesId") Long speciesId) {
        try {
            return ResponseEntity.ok(ListResponseDTO.success(petService.getPetByUserIdAndSpeciesId(userId, speciesId)));
        } catch (PetException | AppUserException | SpeciesException exception){
            return new ResponseEntity<>(ListResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = ApiPaths.GET_PET_BY_ID)
    public ResponseEntity<ObjectResponseDTO> getPetById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petService.getPetById(id)));
        } catch (PetException exception) {
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.SAVE)
    public ResponseEntity<ObjectResponseDTO> registerOrUpdatePet(@RequestBody PetDto petDto) {
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petService.registerOrUpdatePet(petDto)));
        } catch (PetException | AppUserException | SpeciesException | BreedException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = ApiPaths.DELETE)
    public ResponseEntity<Void> deletePetRegister(@RequestBody PetDto petDto) {
        try {
            petService.deletePetRegister(petDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (PetException exception){
            logger.error(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = ApiPaths.GET_PET_MEDICAL_RECORD_BY_PET_ID)
    public ResponseEntity<ListResponseDTO> getPetMedicalRecordByPetId(@PathVariable(name = "petId") Long petId){
        return ResponseEntity.ok(ListResponseDTO.success(petMedicalRecordService.getPetMedicalRecordsByPetId(petId)));
    }

    @GetMapping(value = ApiPaths.GET_PET_MEDICAL_RECORD_BY_PET_ID_AND_DATE)
    public ResponseEntity<ListResponseDTO> getPetMedicalRecordByPetIdAndConsultDate(
            @PathVariable(name = "petId") Long petId,
            @PathVariable(name = "consultDate") LocalDate consultDate){
        return ResponseEntity.ok(ListResponseDTO.success(
                                petMedicalRecordService.getPetMedicalRecordsByPetIdAndConsultDate(petId, consultDate)
        ));
    }

    @GetMapping(value = ApiPaths.GET_PET_MEDICAL_RECORD_BY_ID)
    public ResponseEntity<ObjectResponseDTO> getPetMedicalRecordById(@PathVariable(name = "id") Long id){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petMedicalRecordService.getPetMedicalRecordById(id)));
        } catch (PetMedicalRecordException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.SAVE_OR_UPDATE_PET_MEDICAL_RECORD)
    public ResponseEntity<ObjectResponseDTO> savePetMedicalRecord(@RequestBody PetMedicalRecordDto dto) {
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petMedicalRecordService.savePetMedicalRecord(dto)));
        } catch (PetMedicalRecordException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = ApiPaths.DELETE_PET_MEDICAL_RECORD)
    public ResponseEntity<Void> deletePetMedicalRecord(@RequestBody PetMedicalRecordDto dto){
        petMedicalRecordService.deletePetMedicalRecord(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = ApiPaths.GET_PET_VACCINATION_RECORD_BY_PET_ID)
    public ResponseEntity<ListResponseDTO> getPetVaccinationRecordByPetId(@PathVariable(name = "petId") Long petId){
        return ResponseEntity.ok(ListResponseDTO.success(petVaccinationRecordService.getPetVaccinationRecordsByPetId(petId)));
    }

    @GetMapping(value = ApiPaths.GET_PET_VACCINATION_RECORD_BY_ID)
    public ResponseEntity<ObjectResponseDTO> getPetVaccinationRecordById(@PathVariable(name = "id") Long id){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petVaccinationRecordService.getPetVaccinationRecordById(id)));
        } catch (PetVaccinationRecordException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.SAVE_OR_UPDATE_PET_VACCINATION_RECORD)
    public ResponseEntity<ObjectResponseDTO> savePetVaccinationRecord(@RequestBody PetVaccinationRecordDto dto) {
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petVaccinationRecordService.savePetVaccinationRecord(dto)));
        } catch (PetVaccinationRecordException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = ApiPaths.DELETE_PET_VACCINATION_RECORD)
    public ResponseEntity<Void> deletePetVaccinationRecord(@RequestBody PetVaccinationRecordDto dto){
        petVaccinationRecordService.deletePetVaccinationRecord(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = ApiPaths.PET_ACTIVITY_BY_ID)
    public ResponseEntity<ObjectResponseDTO> getPetActivityById(@PathVariable(name = "id")Long id){
        try{
            return ResponseEntity.ok(ObjectResponseDTO.success(petActivityService.getPetActivityById(id)));
        } catch (PetActivityException exception) {
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.SAVE_OR_UPDATE_PET_ACTIVITY)
    public ResponseEntity<ObjectResponseDTO> savePetActivity(@RequestBody PetActivityDto petActivityDto){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petActivityService.savePetActivity(petActivityDto)));
        } catch (PetActivityException exception) {
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = ApiPaths.GET_PET_ACTIVITY_BY_PET_ID)
    public ResponseEntity<ListResponseDTO> getPetActivitiesByPetId(@PathVariable(name = "petId")Long petId){
        return ResponseEntity.ok(ListResponseDTO.success(petActivityService.getPetActivitiesByPetId(petId)));
    }

    @DeleteMapping(value = ApiPaths.PET_ACTIVITY_BY_ID)
    public ResponseEntity<Void> deletePetActivity(@PathVariable(name = "id") Long id){
        try {
            petActivityService.deletePetActivity(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (PetActivityException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = ApiPaths.GET_PET_BY_STATUS)
    public ResponseEntity<ListResponseDTO> getPetsByStatus(@PathVariable(name = "status") String status){
        try {
            return ResponseEntity.ok(ListResponseDTO.success(petService.getPetByStatus(status)));
        }catch (PetException exception){
            return new ResponseEntity<>(ListResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.REQUEST_PET_ADOPTION)
    public ResponseEntity<Void> requestPetAdoption(@PathVariable(name = "id") Long petId, @PathVariable(name = "userId") Long adoptingUserId){
        petService.requestPetAdoption(petId, adoptingUserId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = ApiPaths.REQUEST_FOSTER_PET)
    public ResponseEntity<ObjectResponseDTO> requestFosterPet(@PathVariable(name = "id")Long petId,
                                                              @PathVariable(name = "userId") Long fosterUserId,
                                                              @RequestParam int amount){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petService.requestFosterPet(petId, fosterUserId, amount)));
        } catch (PetException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = ApiPaths.REPORT_BY_LOCATION)
    public ResponseEntity<ListResponseDTO> getReportByLocation(@RequestParam(name = "latitudeMin")Double latitudeMin,
                                                    @RequestParam(name = "longitudeMin")Double longitudeMin,
                                                    @RequestParam(name = "latitudeMax")Double latitudeMax,
                                                    @RequestParam(name = "longitudeMax")Double longitudeMax){
        return ResponseEntity.ok(ListResponseDTO.success(reportPetService.getReportsByLocation(latitudeMin, longitudeMin, latitudeMax, longitudeMax)));
    }

    @GetMapping(value = ApiPaths.REPORT_BY_DATES)
    public ResponseEntity<ListResponseDTO> getReportsByCreationDate(@RequestParam(name = "startDate") String startDate,
                                                                      @RequestParam(name = "endDate") String endDate) {
        return ResponseEntity.ok(ListResponseDTO.success(reportPetService.getReportsByCreationDate(startDate, endDate)));
    }

    @GetMapping(value = ApiPaths.REPORT_BY_ID)
    public ResponseEntity<ObjectResponseDTO> getReportById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(reportPetService.getReportById(id)));
        } catch (ReportPetException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.REPORT_URL)
    public ResponseEntity<ObjectResponseDTO> saveOrUpdateReport(@RequestBody ReportPetDto reportPetDto){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(reportPetService.saveReport(reportPetDto)));
        } catch (ReportPetException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.REPORT_LOST_PET)
    public ResponseEntity<ObjectResponseDTO> saveLostPetReport(@RequestBody ReportPetDto reportPetDto){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(reportPetService.saveLostPetReport(reportPetDto)));
        } catch (ReportPetException | PetException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.REPORT_FOUND_PET)
    public ResponseEntity<ObjectResponseDTO> saveFoundPetReport(@RequestBody FoundPetReportDto foundPetReportDto){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(reportPetService.saveFoundPetReport(foundPetReportDto)));
        } catch (ReportPetException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.REPORT_CLOSE)
    public ResponseEntity<ObjectResponseDTO> closeReport(@RequestBody ReportPetDto reportPetDto){
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(reportPetService.closeReport(reportPetDto)));
        } catch (ReportPetException | PetException | BreedException | AppUserException | SpeciesException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = ApiPaths.REPORT_OPEN)
    public ResponseEntity<ListResponseDTO> getAllOpenReports(){
        return ResponseEntity.ok(ListResponseDTO.success(reportPetService.getOpenReports()));
    }
}
