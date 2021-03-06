package com.github.firulapp.web.controller;

import com.github.firulapp.constants.ApiPaths;
import com.github.firulapp.dto.*;
import com.github.firulapp.exceptions.*;
import com.github.firulapp.service.*;
import com.github.firulapp.web.response.ListResponseDTO;
import com.github.firulapp.web.response.ObjectResponseDTO;
import com.github.firulapp.web.response.ParamResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private ResponseEntity<ParamResponseDTO> getAllSpecies(@RequestParam(required=false, value="_start") int listStart,
                                                           @RequestParam(required=false, value="_end") int listEnd)
            throws SpeciesException {
        return ResponseEntity.ok(ParamResponseDTO.success(speciesService.getAllSpecies(listStart, listEnd)));
    }

    @GetMapping(value = ApiPaths.SPECIES_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getSpeciesById(@PathVariable Long id) throws SpeciesException {
        return ResponseEntity.ok(ObjectResponseDTO.success(speciesService.getSpeciesById(id)));
    }

    @PostMapping(value = ApiPaths.SPECIES_ENDPOINTS)
    private ResponseEntity<ObjectResponseDTO> saveSpecies(@RequestBody SpeciesDto speciesDto) {
        return ResponseEntity.ok(ObjectResponseDTO.success(speciesService.saveSpecies(speciesDto)));
    }

    @GetMapping(value = ApiPaths.BREED_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllBreeds(@RequestParam(required=false, value="_start") int listStart,
                                                         @RequestParam(required=false, value="_end") int listEnd)
            throws BreedException{
        return ResponseEntity.ok(ListResponseDTO.success(breedService.getAllBreeds(listStart, listEnd)));
    }

    @GetMapping(value = ApiPaths.BREED_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getBreedById(@PathVariable Long id) throws BreedException {
        return ResponseEntity.ok(ObjectResponseDTO.success(breedService.getBreedById(id)));
    }

    @PostMapping(value = ApiPaths.BREED_ENDPOINTS)
    private ResponseEntity<ObjectResponseDTO> saveBreed(@RequestBody BreedDto breedDto){
        return ResponseEntity.ok(ObjectResponseDTO.success(breedService.saveBreed(breedDto)));
    }

    @GetMapping(value = ApiPaths.CONDUCT_RULE_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllConductRules(@RequestParam(required=false, value="_start") int listStart,
                                                               @RequestParam(required=false, value="_end") int listEnd)
            throws ConductRuleException{
        return ResponseEntity.ok(ListResponseDTO.success(conductRuleService.getAllRules(listStart, listEnd)));
    }

    @GetMapping(value = ApiPaths.CONDUCT_RULE_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getConductRuleById(@PathVariable Long id) throws ConductRuleException {
        return ResponseEntity.ok(ObjectResponseDTO.success(conductRuleService.getRuleById(id)));
    }

    @PostMapping(value = ApiPaths.CONDUCT_RULE_ENDPOINTS)
    private ResponseEntity<ObjectResponseDTO> saveConductRule(@RequestBody ConductRuleDto conductRuleDto) {
        return ResponseEntity.ok(ObjectResponseDTO.success(conductRuleService.saveConductRule(conductRuleDto)));
    }

    @GetMapping(value = ApiPaths.HELP_PAGE_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllHelpPages(@RequestParam(required=false, value="_start") int listStart,
                                                            @RequestParam(required=false, value="_end") int listEnd)
            throws HelpPageException{
        return ResponseEntity.ok(ListResponseDTO.success(helpPageService.getAllHelpPages(listStart, listEnd)));
    }

    @GetMapping(value = ApiPaths.HELP_PAGE_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getHelpPageById(@PathVariable Long id) throws HelpPageException {
        return ResponseEntity.ok(ObjectResponseDTO.success(helpPageService.getHelpPageById(id)));
    }

    @PostMapping(value = ApiPaths.HELP_PAGE_ENDPOINTS)
    private ResponseEntity<ObjectResponseDTO> saveHelpPage(@RequestBody HelpPageDto helpPageDto) {
        return ResponseEntity.ok(ObjectResponseDTO.success(helpPageService.saveHelpPage(helpPageDto)));
    }

    @GetMapping(value = ApiPaths.SERVICE_TYPE_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllServiceTypes(@RequestParam(required=false, value="_start") int listStart,
                                                               @RequestParam(required=false, value="_end") int listEnd)
            throws ServiceTypeException{
        return ResponseEntity.ok(ListResponseDTO.success(serviceTypeService.getAllServiceTypes(listStart, listEnd)));
    }

    @GetMapping(value = ApiPaths.SERVICE_TYPE_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getServiceType(@PathVariable Long id) throws ServiceTypeException {
        return ResponseEntity.ok(ObjectResponseDTO.success(serviceTypeService.getServiceTypeById(id)));
    }

    @PostMapping(value = ApiPaths.SERVICE_TYPE_ENDPOINTS)
    private ResponseEntity<ObjectResponseDTO> saveServiceType(@RequestBody ServiceTypeDto serviceTypeDto) {
        return ResponseEntity.ok(ObjectResponseDTO.success(serviceTypeService.saveServiceType(serviceTypeDto)));
    }

    @GetMapping(value = ApiPaths.PET_CARE_ENDPOINTS)
    private ResponseEntity<ListResponseDTO> getAllPetCare(@RequestParam(required=false, value="_start") int listStart,
                                                          @RequestParam(required=false, value="_end") int listEnd)
            throws PetCareException{
        return ResponseEntity.ok(ListResponseDTO.success(petCareService.getAllPetCares(listStart, listEnd)));
    }

    @GetMapping(value = ApiPaths.PET_CARE_BY_ID)
    private ResponseEntity<ObjectResponseDTO> getPetCareId(@PathVariable Long id) throws PetCareException {
        return ResponseEntity.ok(ObjectResponseDTO.success(petCareService.getPetCareById(id)));
    }

    @PostMapping(ApiPaths.PET_CARE_ENDPOINTS)
    private ResponseEntity<ObjectResponseDTO> savePetCare(@RequestBody PetCareDto petCareDto) {
        return ResponseEntity.ok(ObjectResponseDTO.success(petCareService.savePetCare(petCareDto)));
    }
}
