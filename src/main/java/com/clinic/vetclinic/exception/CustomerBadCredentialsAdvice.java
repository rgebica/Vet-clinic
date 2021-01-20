package com.clinic.vetclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomerBadCredentialsAdvice {
    @ResponseBody
    @ExceptionHandler(CustomerBadCredentialsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String customerNotFoundHandler(CustomerBadCredentialsException ex) {
        return ex.getMessage();
    }
}
