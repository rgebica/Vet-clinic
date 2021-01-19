package com.clinic.vetclinic.exception;

public class TermIsAlreadyTakenException extends RuntimeException {
    public TermIsAlreadyTakenException (long termId) {
        super("Term with id: " + termId + " is already taken");
    }
}
