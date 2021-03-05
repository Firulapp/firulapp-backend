package com.github.firulapp.web.controller;

import com.github.firulapp.constants.ApiPaths;
import com.github.firulapp.dto.*;
import com.github.firulapp.exceptions.*;
import com.github.firulapp.service.*;
import com.github.firulapp.web.response.ListResponseDTO;
import com.github.firulapp.web.response.ObjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.JobKOctets;

@Controller
@RequestMapping(value = {ApiPaths.PARAM_ENDPOINTS_URL})
public class ParamController {

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private BreedService breedService;

    @Autowired
    private ConductRuleService conductRuleService;

    @Autowired
    private HelpPageService helpPageService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private PetCareService petCareService;

    @GetMapping(value = ApiPaths.SPECIES_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllSpecies(){
        return ResponseEntity.ok(ListResponseDTO.success(speciesService.getAllSpecies()));
    }

    @GetMapping(value = ApiPaths.SPECIES_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getSpeciesById(@PathVariable Long id) throws SpeciesException {
        return ResponseEntity.ok(ObjectResponseDTO.success(speciesService.getSpeciesById(id)));
    }

    @PostMapping(value = ApiPaths.SPECIES_SAVE)
    private ResponseEntity<ObjectResponseDTO> saveSpecies(@RequestBody SpeciesDto speciesDto) throws SpeciesException {
        return ResponseEntity.ok(ObjectResponseDTO.success(speciesService.saveSpecies(speciesDto)));
    }

    @GetMapping(value = ApiPaths.BREED_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllBreeds(){
        return ResponseEntity.ok(ListResponseDTO.success(breedService.getAllBreeds()));
    }

    @GetMapping(value = ApiPaths.BREED_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getBreedById(@PathVariable Long id) throws BreedException {
        return ResponseEntity.ok(ObjectResponseDTO.success(breedService.getBreedById(id)));
    }

    @PostMapping(value = ApiPaths.BREED_SAVE)
    private ResponseEntity<ObjectResponseDTO> saveBreed(@RequestBody BreedDto breedDto){
        return ResponseEntity.ok(ObjectResponseDTO.success(breedService.saveBreed(breedDto)));
    }

    @GetMapping(value = ApiPaths.CONDUCT_RULE_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllConductRules(){
        return ResponseEntity.ok(ListResponseDTO.success(conductRuleService.getAllRules()));
    }

    @GetMapping(value = ApiPaths.CONDUCT_RULE_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getConductRuleById(@PathVariable Long id) throws ConductRuleException {
        return ResponseEntity.ok(ObjectResponseDTO.success(conductRuleService.getRuleById(id)));
    }

    @PostMapping(value = ApiPaths.CONDUCT_RULE_SAVE)
    private ResponseEntity<ObjectResponseDTO> saveConductRule(@RequestBody ConductRuleDto conductRuleDto) {
        return ResponseEntity.ok(ObjectResponseDTO.success(conductRuleService.saveConductRule(conductRuleDto)));
    }

    @GetMapping(value = ApiPaths.HELP_PAGE_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllHelpPages(){
        return ResponseEntity.ok(ListResponseDTO.success(helpPageService.getAllHelpPages()));
    }

    @GetMapping(value = ApiPaths.HELP_PAGE_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getHelpPageById(@PathVariable Long id) throws HelpPageException {
        return ResponseEntity.ok(ObjectResponseDTO.success(helpPageService.getHelpPageById(id)));
    }

    @PostMapping(value = ApiPaths.HELP_PAGE_SAVE)
    private ResponseEntity<ObjectResponseDTO> saveHelpPage(@RequestBody HelpPageDto helpPageDto) {
        return ResponseEntity.ok(ObjectResponseDTO.success(helpPageService.saveHelpPage(helpPageDto)));
    }

    @GetMapping(value = ApiPaths.SERVICE_TYPE_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllServiceTypes(){
        return ResponseEntity.ok(ListResponseDTO.success(helpPageService.getAllHelpPages()));
    }

    @GetMapping(value = ApiPaths.SERVICE_TYPE_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getServiceType(@PathVariable Long id) throws ServiceTypeException {
        return ResponseEntity.ok(ObjectResponseDTO.success(serviceTypeService.getServiceTypeById(id)));
    }

    @PostMapping(value = ApiPaths.SERVICE_TYPE_SAVE)
    private ResponseEntity<ObjectResponseDTO> saveServiceType(@RequestBody ServiceTypeDto serviceTypeDto) {
        return ResponseEntity.ok(ObjectResponseDTO.success(serviceTypeService.saveServiceType(serviceTypeDto)));
    }

    @GetMapping(value = ApiPaths.PET_CARE_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllPetCare(){
        return ResponseEntity.ok(ListResponseDTO.success(petCareService.getAllPetCares()));
    }

    @GetMapping(value = ApiPaths.PET_CARE_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getPetCareId(@PathVariable Long id) throws PetCareException {
        return ResponseEntity.ok(ObjectResponseDTO.success(petCareService.getPetCareById(id)));
    }

    @PostMapping(ApiPaths.PET_CARE_SAVE)
    private ResponseEntity<ObjectResponseDTO> savePetCare(@RequestBody PetCareDto petCareDto) {
        return ResponseEntity.ok(ObjectResponseDTO.success(petCareService.savePetCare(petCareDto)));
    }
}
