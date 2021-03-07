package com.github.firulapp.service.impl;

import com.github.firulapp.domain.HelpPage;
import com.github.firulapp.dto.HelpPageDto;
import com.github.firulapp.exceptions.HelpPageException;
import com.github.firulapp.mapper.impl.HelpPageMapper;
import com.github.firulapp.repository.HelpPageRepository;
import com.github.firulapp.service.HelpPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HelpPageServiceImpl implements HelpPageService {
    @Autowired
    private HelpPageRepository helpPageRepository;

    @Autowired
    private HelpPageMapper helpPageMapper;

    @Override
    public List<HelpPageDto> getAllHelpPages(){
        return helpPageMapper.mapAsList(helpPageRepository.findAll());
    }

    @Override
    public HelpPageDto getHelpPageById(Long id) throws HelpPageException {
        Optional<HelpPage> helpPage = helpPageRepository.findById(id);
        return helpPage.map(help -> helpPageMapper.mapToDto(help)).orElseThrow(HelpPageException.notFound(id));
    }

    @Override
    public HelpPageDto saveHelpPage(HelpPageDto helpPageDto) {
        if(helpPageDto.getId() != null){
            helpPageDto.setModifiedAt(LocalDateTime.now());
            return helpPageMapper.mapToDto(helpPageRepository.save(helpPageMapper.mapToEntity(helpPageDto)));
        }else {
            HelpPage helpPage = helpPageMapper.mapToEntity(helpPageDto);
            helpPage.setStatus(Boolean.TRUE);
            helpPage.setCreatedAt(LocalDateTime.now());
            return helpPageMapper.mapToDto(helpPageRepository.save(helpPage));
        }
    }

    @Override
    public void delete(HelpPageDto helpPageDto) {
        Optional<HelpPage> helpPage = helpPageRepository.findById(helpPageDto.getId());
        helpPage.ifPresent(value -> helpPageRepository.delete(helpPage.get()));
    }
}
