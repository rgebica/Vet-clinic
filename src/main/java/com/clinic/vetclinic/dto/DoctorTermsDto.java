package com.clinic.vetclinic.dto;

import com.clinic.vetclinic.model.Term;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorTermsDto {
    long doctorId;
    String firstName;
    String lastName;
    List<TermsDto> terms;

    public static DoctorTermsDto from(long doctorId, String firstName, String lastName, List<TermsDto> terms) {
        return DoctorTermsDto.builder()
                .doctorId(doctorId)
                .firstName(firstName)
                .lastName(lastName)
                .terms(terms)
                .build();
    }
}
