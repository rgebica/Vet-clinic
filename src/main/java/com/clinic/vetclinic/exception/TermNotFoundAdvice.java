package com.clinic.vetclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TermNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TermNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String termNotFoundHandler(TermNotFoundException ex) {
        return ex.getMessage();
    }
}
