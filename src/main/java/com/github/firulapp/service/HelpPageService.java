package com.github.firulapp.service;

import com.github.firulapp.dto.HelpPageDto;
import com.github.firulapp.exceptions.HelpPageException;

import java.util.List;

public interface HelpPageService {

    List<HelpPageDto> getAllHelpPages(Integer listStart, Integer listEnd) throws HelpPageException;

    HelpPageDto getHelpPageById(Long id) throws HelpPageException;

    HelpPageDto saveHelpPage(HelpPageDto helpPageDto);
}
