package com.github.firulapp.web.response;

import java.util.List;

public class ParamResponseDTO<T>{

    private List<T> list;

    public ParamResponseDTO(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static ParamResponseDTO success(List<?> list) {
        return new ParamResponseDTO(list);
    }
}
