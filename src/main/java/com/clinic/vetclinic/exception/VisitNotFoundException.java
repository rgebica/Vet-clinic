package com.clinic.vetclinic.exception;

public class VisitNotFoundException extends RuntimeException {
    public VisitNotFoundException(long visitId) {
        super("Could not find term with id: " + visitId);
    }
}
