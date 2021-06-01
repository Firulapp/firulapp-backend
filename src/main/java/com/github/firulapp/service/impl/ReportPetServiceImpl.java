package com.github.firulapp.service.impl;

import com.github.firulapp.domain.ReportPet;
import com.github.firulapp.dto.ReportPetDto;
import com.github.firulapp.exceptions.ReportPetException;
import com.github.firulapp.mapper.impl.ReportPetMapper;
import com.github.firulapp.repository.ReportPetRepository;
import com.github.firulapp.service.ReportPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ReportPetServiceImpl implements ReportPetService {

    @Autowired
    private ReportPetRepository repository;

    @Autowired
    private ReportPetMapper mapper;

    @Override
    public List<ReportPetDto> getReportsByLocation(Double latitudeMin, Double longitudeMin, Double latitudeMax, Double longitudeMax) {
        return mapper.mapAsList(repository.findByLocationLatitudeAndLocationLongitude(latitudeMin, longitudeMin, latitudeMax, longitudeMax));
    }

    @Override
    public List<ReportPetDto> getReportsByCreationDate(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return mapper.mapAsList(repository.findByCreatedAt(LocalDateTime.parse(startDate, formatter), LocalDateTime.parse(endDate, formatter)));
    }

    @Override
    public ReportPetDto saveReport(ReportPetDto reportPetDto) throws ReportPetException {
        if(reportPetDto.getId() != null){
            if(reportPetDto.getModifiedBy()!=null) {
                reportPetDto.setModifiedAt(LocalDateTime.now());
            }else{
                throw ReportPetException.missingData();
            }
        } else {
            reportPetDto.setCreatedAt(LocalDateTime.now());
        }
        
        return mapper.mapToDto(repository.save(mapper.mapToEntity(reportPetDto)));
    }

    @Override
    public ReportPetDto getReportById(Long id) throws ReportPetException {
        Optional<ReportPet> report = repository.findById(id);
        if(report.isPresent()){
            return mapper.mapToDto(report.get());
        } else {
            throw ReportPetException.notFound(id);
        }
    }
}
