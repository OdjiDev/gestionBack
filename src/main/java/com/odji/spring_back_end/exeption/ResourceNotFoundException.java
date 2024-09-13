package com.odji.spring_back_end.exeption;

//public class ResourceNotFoundException {
//
//        public ResourceNotFoundException(String message) {
//            super();
//        }
//    }


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);

    }
}