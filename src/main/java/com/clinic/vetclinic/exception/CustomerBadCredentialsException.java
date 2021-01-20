package com.clinic.vetclinic.exception;

public class CustomerBadCredentialsException extends RuntimeException {
    public CustomerBadCredentialsException(long customerId, long codePin) {
        super("Could not find customer with userId: " + customerId + "and codePin " + codePin);
    }
}
