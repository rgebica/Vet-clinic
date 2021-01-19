package com.clinic.vetclinic.exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException (long doctorId) {
        super("Could not find doctor with id: " + doctorId);
    }
}

