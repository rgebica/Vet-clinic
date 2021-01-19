package com.clinic.vetclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TermIsAlreadyTakenAdvice {
    @ResponseBody
    @ExceptionHandler(TermIsAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String termTakenHandler(TermIsAlreadyTakenException ex) {
        return ex.getMessage();
    }
}
