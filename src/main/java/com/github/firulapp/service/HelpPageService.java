package com.github.firulapp.service;

import com.github.firulapp.dto.HelpPageDto;

import java.util.List;

public interface HelpPageService {

    List<HelpPageDto> getAllHelpPages();

    HelpPageDto getHelpPageById(Long id);

    HelpPageDto saveHelpPage(HelpPageDto helpPageDto);
}
