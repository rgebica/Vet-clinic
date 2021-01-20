package com.clinic.vetclinic.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerVisitDto {
    long customerId;
    String customerName;
    String customerLastName;
    List<TermsDto> visits;

    public static CustomerVisitDto from(long customerId, String customerName, String customerLastName, List<TermsDto> visits) {
        return CustomerVisitDto.builder()
                .customerId(customerId)
                .customerName(customerName)
                .customerLastName(customerLastName)
                .visits(visits)
                .build();
    }
}
