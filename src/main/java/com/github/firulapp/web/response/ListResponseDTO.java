package com.github.firulapp.web.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ListResponseDTO<T> extends BaseResponseDTO {

    private List<T> list;

    private static Logger logger = LoggerFactory.getLogger(ListResponseDTO.class);

    public ListResponseDTO(List<T> list) {
        this.list = list;
    }

    public ListResponseDTO(boolean success, HttpStatus httpStatus, List<T> list) {
        super(success, httpStatus);
        this.list = list;
    }

    public ListResponseDTO(boolean success, String errorCode, String message, HttpStatus httpStatus) {
        super(success, errorCode, message, httpStatus);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static ListResponseDTO success(List<?> list) {
        return new ListResponseDTO(true, HttpStatus.OK, list);
    }

    public static ListResponseDTO error(String errorCode, String errorMessage, HttpStatus httpStatus){
        logger.error(errorMessage);
        return new ListResponseDTO(false, errorCode, errorMessage, httpStatus);
    }
}