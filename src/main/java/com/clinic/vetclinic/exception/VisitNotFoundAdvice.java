package com.clinic.vetclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class VisitNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(VisitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String visitNotFoundHandler(VisitNotFoundException ex) {
        return ex.getMessage();
    }
}
