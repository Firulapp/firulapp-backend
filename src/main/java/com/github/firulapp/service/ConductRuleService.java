package com.github.firulapp.service;

import com.github.firulapp.dto.ConductRuleDto;

import java.util.List;

public interface ConductRuleService {

    List<ConductRuleDto> getAllRules();

    ConductRuleDto getRuleById(Long id);

    ConductRuleDto saveConductRule(ConductRuleDto conductRuleDto);
}
