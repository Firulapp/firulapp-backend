package com.github.firulapp.repository;

import com.github.firulapp.domain.AppRole;
import com.github.firulapp.dto.AppRoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, AppRoleDTO> {

    AppRole findById();
}
