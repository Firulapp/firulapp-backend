package com.github.firulapp.repository;

import com.github.firulapp.domain.AppSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppSessionRepository extends JpaRepository<AppSession, Long> {

    AppSession findByUserId(Long userId);
}
