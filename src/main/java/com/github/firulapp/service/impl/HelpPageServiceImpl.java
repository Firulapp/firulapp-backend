package com.github.firulapp.service.impl;

import com.github.firulapp.domain.HelpPage;
import com.github.firulapp.dto.HelpPageDto;
import com.github.firulapp.exceptions.HelpPageException;
import com.github.firulapp.mapper.impl.HelpPageMapper;
import com.github.firulapp.repository.HelpPageRepository;
import com.github.firulapp.service.HelpPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelpPageServiceImpl implements HelpPageService {
    @Autowired
    private HelpPageRepository helpPageRepository;

    @Autowired
    private HelpPageMapper helpPageMapper;

    @Override
    public List<HelpPageDto> getAllHelpPages(Integer listStart, Integer listEnd) throws HelpPageException {
        List<HelpPageDto> allPages= helpPageMapper.mapAsList(helpPageRepository.findAll());
        if (listStart != null && listEnd!= null && listEnd != 0) {
            if(allPages.size() > listEnd) {
                return allPages.subList(listStart, listEnd);
            }else{
                return allPages;
            }
        }else{
            throw new HelpPageException(HelpPageException.BASE_ERROR, "Error al mostrar el listado");
        }
    }

    @Override
    public HelpPageDto getHelpPageById(Long id) throws HelpPageException {
        Optional<HelpPage> helpPage = helpPageRepository.findById(id);
        return helpPage.map(help -> helpPageMapper.mapToDto(help)).orElseThrow(HelpPageException.notFound(id));
    }

    @Override
    public HelpPageDto saveHelpPage(HelpPageDto helpPageDto) {
        return helpPageMapper.mapToDto(helpPageRepository.save(helpPageMapper.mapToEntity(helpPageDto)));
    }
}
