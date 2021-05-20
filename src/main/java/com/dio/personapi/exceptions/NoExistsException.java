package com.dio.personapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoExistsException extends Exception {

    public NoExistsException(Long id){
        super("Person with ID " + id + " not found!");
    }

}
