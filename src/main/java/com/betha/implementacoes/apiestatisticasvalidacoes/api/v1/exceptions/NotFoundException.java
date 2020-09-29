package com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND) //404
public class NotFoundException extends RuntimeException{
    public NotFoundException(int id,String entityName) {
        super(entityName + " not found with id: " + id);
    }

    public NotFoundException(int id) {
        super("Entity not found with id: " + id);
    }

    public NotFoundException(String uuid) {
        super("Entity not found with uuid: " + uuid);
    }
}
