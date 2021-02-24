package com.github.firulapp.mapper;

import ma.glasnost.orika.MapperFacade;

import java.util.List;

public interface BaseMapper<E, D> {

    List<D> mapAsList(List<E> list);

    D mapToDto(E entity);

    E mapToEntity(D dto);

    MapperFacade getMapper();

}
