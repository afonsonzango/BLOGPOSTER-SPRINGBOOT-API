package com.bloger.afonsonzango.api.globals.application.dtos.response_dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class APIResponseDTO<T> {
    private boolean error;
    private HttpStatus status;
    private String message;
    private T data;

    public APIResponseDTO(boolean error, HttpStatus status, String message, T data) {
        this.error = error;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}











