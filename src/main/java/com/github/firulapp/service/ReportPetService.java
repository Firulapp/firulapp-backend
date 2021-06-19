package com.github.firulapp.service;

import com.github.firulapp.dto.FoundPetReportDto;
import com.github.firulapp.dto.ReportPetDto;
import com.github.firulapp.exceptions.*;

import java.util.List;

public interface ReportPetService {

    List<ReportPetDto> getReportsByLocation(Double latitudeLeft, Double longitudeLeft, Double latitudeRight, Double longitudeRight);

    List<ReportPetDto> getReportsByCreationDate(String startDate, String endDate);

    ReportPetDto saveReport(ReportPetDto reportPetDto) throws ReportPetException;

    ReportPetDto getReportById(Long id) throws ReportPetException;

    ReportPetDto saveLostPetReport(ReportPetDto reportPetDto) throws ReportPetException, PetException;

    ReportPetDto saveFoundPetReport(FoundPetReportDto foundPetReportDto) throws ReportPetException;

    List<ReportPetDto> getOpenReports();

    ReportPetDto closeReport(ReportPetDto reportPetDto) throws ReportPetException, BreedException, PetException, AppUserException, SpeciesException;
}
