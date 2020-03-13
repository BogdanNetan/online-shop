package org.fasttrackit.onlineshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class ResourceNotFondException extends RuntimeException {


    public ResourceNotFondException(String message) {
        super(message);
    }
}
