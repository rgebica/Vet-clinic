package com.clinic.vetclinic.dto;

import com.clinic.vetclinic.model.Status;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TermsDto {
    long termId;
    String date;
    String hour;
    Status status;
}
