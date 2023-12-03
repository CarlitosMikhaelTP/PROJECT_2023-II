package com.project.uywalky.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaseoNotFoundException extends RuntimeException{
    public PaseoNotFoundException (String message){
        super(message);
    }
}
