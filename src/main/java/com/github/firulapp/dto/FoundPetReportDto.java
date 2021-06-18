package com.github.firulapp.dto;

public class FoundPetReportDto {
    private ReportPetDto report;
    private PetDto pet;

    public ReportPetDto getReport() {
        return report;
    }

    public void setReport(ReportPetDto report) {
        this.report = report;
    }

    public PetDto getPet() {
        return pet;
    }

    public void setPet(PetDto pet) {
        this.pet = pet;
    }
}
