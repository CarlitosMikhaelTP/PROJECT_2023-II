package com.project.uywalky.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TipoTransaccionNotFoundException extends RuntimeException{
    public TipoTransaccionNotFoundException (String message){
        super(message);
    }
}
