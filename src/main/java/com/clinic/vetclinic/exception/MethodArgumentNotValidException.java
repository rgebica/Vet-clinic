package com.clinic.vetclinic.exception;

public class MethodArgumentNotValidException extends RuntimeException {
    public MethodArgumentNotValidException() {
        super("Nullable field: ");
    }
}
