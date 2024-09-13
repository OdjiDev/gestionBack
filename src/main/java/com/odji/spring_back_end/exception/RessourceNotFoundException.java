package com.odji.spring_back_end.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID=1l;

    public RessourceNotFoundException(String message){
        super(message);
    }


}
