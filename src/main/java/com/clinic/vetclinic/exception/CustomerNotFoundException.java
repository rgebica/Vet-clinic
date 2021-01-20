package com.clinic.vetclinic.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(long customerId) {
        super("Could not find customer with userId: " + customerId);
    }
}
