package com.github.firulapp.service.impl;

import com.github.firulapp.domain.ConductRule;
import com.github.firulapp.dto.ConductRuleDto;
import com.github.firulapp.exceptions.ConductRuleException;
import com.github.firulapp.mapper.impl.ConductRuleMapper;
import com.github.firulapp.repository.ConductRuleRepository;
import com.github.firulapp.service.ConductRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConductRuleServiceImpl implements ConductRuleService {

    @Autowired
    private ConductRuleRepository conductRuleRepository;

    @Autowired
    private ConductRuleMapper conductRuleMapper;

    @Override
    public List<ConductRuleDto> getAllRules(){
        return conductRuleMapper.mapAsList(conductRuleRepository.findAll());
    }

    @Override
    public ConductRuleDto getRuleById(Long id) throws ConductRuleException {
        Optional<ConductRule> conductRule = conductRuleRepository.findById(id);
        return conductRule.map(rule -> conductRuleMapper.mapToDto(rule)).orElseThrow(ConductRuleException.notFound(id));
    }

    @Override
    public ConductRuleDto saveConductRule(ConductRuleDto conductRuleDto) {
        if(conductRuleDto.getId() != null){
            conductRuleDto.setModifiedAt(LocalDateTime.now());
            return conductRuleMapper.mapToDto(conductRuleRepository.save(conductRuleMapper.mapToEntity(conductRuleDto)));
        }else {
            ConductRule conductRule = conductRuleMapper.mapToEntity(conductRuleDto);
            conductRule.setStatus(Boolean.TRUE);
            conductRule.setCreatedAt(LocalDateTime.now());
            return conductRuleMapper.mapToDto(conductRuleRepository.save(conductRule));
        }
    }

    @Override
    public void delete(ConductRuleDto conductRuleDto) {
        Optional<ConductRule> conductRule = conductRuleRepository.findById(conductRuleDto.getId());
        conductRule.ifPresent(value -> conductRuleRepository.delete(conductRule.get()));
    }
}
