package com.clinic.vetclinic.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorVisitDto {
    long doctorId;
    String firstName;
    String lastName;
    List<TermsDto> visits;

    public static DoctorVisitDto from(long doctorId, String firstName, String lastName, List<TermsDto> visits) {
        return DoctorVisitDto.builder()
                .doctorId(doctorId)
                .firstName(firstName)
                .lastName(lastName)
                .visits(visits)
                .build();
    }
}
