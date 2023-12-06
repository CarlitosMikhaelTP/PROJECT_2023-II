package com.project.uywalky.Exceptions.NotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocacionPropietarioNotFoundException extends RuntimeException {
    public LocacionPropietarioNotFoundException (String message){
        super(message);
    }
}
