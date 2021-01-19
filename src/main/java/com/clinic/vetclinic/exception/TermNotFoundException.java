package com.clinic.vetclinic.exception;

public class TermNotFoundException extends RuntimeException {
    public TermNotFoundException (long termId) {
        super("Could not find term with id: " + termId);
    }
}
