package com.clinic.vetclinic.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException (long customerId, long codePin) {
        super("Could not find customer with userId: " + customerId + "and codePin " + codePin);
    }
}
