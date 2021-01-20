package com.clinic.vetclinic.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateTermDto {
    @NonNull
    String date;
    @NonNull
    String hour;
    @NonNull
    long doctorId;
}
