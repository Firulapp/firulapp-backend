package com.github.firulapp.repository;

import com.github.firulapp.domain.ReportPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportPetRepository extends JpaRepository<ReportPet, Long> {

    @Query(value = "SELECT * FROM reporte_mascota rp " +
            "WHERE rp.fecha_creacion BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<ReportPet> findByCreatedAt(@Param("startDate") LocalDateTime startDate,
                                    @Param("endDate") LocalDateTime endDate);

    @Query(value = "SELECT * FROM reporte_mascota rp " +
            "WHERE (rp.latitud_ubicacion BETWEEN :latitudeMin AND :latitudeMax) " +
                "AND (rp.longitud_ubicacion BETWEEN :longitudeMin AND :longitudeMax)",
            nativeQuery = true)
    List<ReportPet> findByLocationLatitudeAndLocationLongitude(@Param("latitudeMin") Double latitudeMin,
                                                                 @Param("longitudeMin") Double longitudeMin,
                                                                 @Param("latitudeMax") Double latitudeMax,
                                                                 @Param("longitudeMax") Double longitudeMax);
}
