package com.github.firulapp.service;

import com.github.firulapp.dto.ConductRuleDto;
import com.github.firulapp.exceptions.ConductRuleException;

import java.util.List;

public interface ConductRuleService {

    List<ConductRuleDto> getAllRules();

    ConductRuleDto getRuleById(Long id) throws ConductRuleException;

    ConductRuleDto saveConductRule(ConductRuleDto conductRuleDto);

    void delete(ConductRuleDto conductRuleDto);
}
