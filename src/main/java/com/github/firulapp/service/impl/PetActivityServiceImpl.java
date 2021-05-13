package com.github.firulapp.service.impl;

import com.github.firulapp.domain.PetActivity;
import com.github.firulapp.dto.PetActivityDto;
import com.github.firulapp.exceptions.PetActivityException;
import com.github.firulapp.mapper.impl.PetActivityMapper;
import com.github.firulapp.repository.PetActivityRepository;
import com.github.firulapp.service.PetActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PetActivityServiceImpl implements PetActivityService {

    @Autowired
    private PetActivityRepository petActivityRepository;

    @Autowired
    private PetActivityMapper petActivityMapper;

    @Override
    public PetActivityDto getPetActivityById(Long id) throws PetActivityException {
        Optional<PetActivity> petActivity = petActivityRepository.findById(id);
        return petActivity.map(p -> petActivityMapper.mapToDto(petActivity.get())).orElseThrow(PetActivityException.notFound(id));
    }

    @Override
    public List<PetActivityDto> getPetActivitiesByPetId(Long petId) {
        return petActivityMapper.mapAsList(petActivityRepository.findByPetIdOrderByActivityDateDescActivityTimeAsc(petId));
    }

    @Override
    public PetActivityDto savePetActivity(PetActivityDto petActivityDto) throws PetActivityException {
        if(petActivityDto.getId() != null){
            if(petActivityDto.getModifiedBy()!=null) {
                petActivityDto.setModifiedAt(LocalDateTime.now());
            }else{
                throw PetActivityException.missingData();
            }
        } else {
            petActivityDto.setCreatedAt(LocalDateTime.now());
        }
        LocalDateTime formattedActivityTime = LocalDateTime.of(petActivityDto.getActivityDate(),
                                                                LocalTime.of(petActivityDto.getActivityTime().getHour(),
                                                                        petActivityDto.getActivityTime().getMinute()));
        petActivityDto.setActivityTime(formattedActivityTime);
        return petActivityMapper.mapToDto(petActivityRepository.save(petActivityMapper.mapToEntity(petActivityDto)));

    }

    @Override
    public void deletePetActivity(Long id) throws PetActivityException {
        Optional<PetActivity> petActivity = petActivityRepository.findById(id);
        if (petActivity.isPresent()) {
            petActivityRepository.delete(petActivity.get());
        } else {
            throw PetActivityException.notFound(id);
        }
    }
}
