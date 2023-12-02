package com.project.uywalky.exception;

import com.project.uywalky.dto.LocacionPropietarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocacionPropietarioNotFoundException extends RuntimeException {
    public LocacionPropietarioNotFoundException (String message){
        super(message);
    }
}
