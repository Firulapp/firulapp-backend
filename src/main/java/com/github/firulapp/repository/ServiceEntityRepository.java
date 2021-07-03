package com.github.firulapp.repository;

import com.github.firulapp.domain.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ServiceEntityRepository extends JpaRepository<ServiceEntity, Long> {

    List<ServiceEntity> findByServiceTypeId(Long serviceTypeId);

    List<ServiceEntity> findByUserId(Long userId);

    @Query(value = "SELECT * FROM servicio " +
                    "WHERE id_tipo_servicio = :serviceTypeId " +
                    "AND id IN (select id_servicio from servicio_especie where id_especie in :species);",
            nativeQuery = true)
    List<ServiceEntity> findByServiceTypeIdAndSpecies(@Param("serviceTypeId") Long serviceTypeId,
                                                      @Param("species") ArrayList<Long> speciesId);
}
