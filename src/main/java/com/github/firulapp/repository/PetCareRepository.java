package com.github.firulapp.repository;

import com.github.firulapp.domain.PetCare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetCareRepository extends JpaRepository<PetCare, Long> {

    @Query(value = "select id, nombre, descripcion, " +
                    "estado, null AS imagen, link, id_especie, " +
                    "id_raza, fecha_creacion, usuario_creacion, " +
                    "fecha_modificacion, usuario_modificacion from public.cuidado_mascota", nativeQuery = true)
    List<PetCare> findAll();

    List<PetCare> findBySpeciesIdAndBreedId(Long speciesId, Long breedId);
}
