package com.github.firulapp.service;

import com.github.firulapp.dto.ReportPetDto;
import com.github.firulapp.exceptions.ReportPetException;

import java.util.List;

public interface ReportPetService {

    List<ReportPetDto> getReportsByLocation(Double latitudeLeft, Double longitudeLeft, Double latitudeRight, Double longitudeRight);

    List<ReportPetDto> getReportsByCreationDate(String startDate, String endDate);

    ReportPetDto saveReport(ReportPetDto reportPetDto) throws ReportPetException;

    ReportPetDto getReportById(Long id) throws ReportPetException;
}
