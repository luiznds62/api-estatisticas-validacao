package com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST) //404
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}