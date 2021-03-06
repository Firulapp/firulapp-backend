package com.github.firulapp.service.impl;

import com.github.firulapp.domain.ConductRule;
import com.github.firulapp.dto.ConductRuleDto;
import com.github.firulapp.exceptions.ConductRuleException;
import com.github.firulapp.exceptions.SpeciesException;
import com.github.firulapp.mapper.impl.ConductRuleMapper;
import com.github.firulapp.repository.ConductRuleRepository;
import com.github.firulapp.service.ConductRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductRuleServiceImpl implements ConductRuleService {

    @Autowired
    private ConductRuleRepository conductRuleRepository;

    @Autowired
    private ConductRuleMapper conductRuleMapper;

    @Override
    public List<ConductRuleDto> getAllRules(Integer listStart, Integer listEnd) throws ConductRuleException {
        List<ConductRuleDto> allRules = conductRuleMapper.mapAsList(conductRuleRepository.findAll());
        if (listStart != null && listEnd!= null && listEnd != 0) {
            if(allRules.size() > listEnd) {
                return allRules.subList(listStart, listEnd);
            }else{
                return allRules;
            }
        }else{
            throw new ConductRuleException(ConductRuleException.BASE_ERROR, "Error al mostrar el listado");
        }
    }

    @Override
    public ConductRuleDto getRuleById(Long id) throws ConductRuleException {
        Optional<ConductRule> conductRule = conductRuleRepository.findById(id);
        return conductRule.map(rule -> conductRuleMapper.mapToDto(rule)).orElseThrow(ConductRuleException.notFound(id));
    }

    @Override
    public ConductRuleDto saveConductRule(ConductRuleDto conductRuleDto) {
        return conductRuleMapper.mapToDto(conductRuleRepository.save(conductRuleMapper.mapToEntity(conductRuleDto)));
    }
}
