package com.clinic.vetclinic.model;

import com.clinic.vetclinic.dto.TermsDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "vet", name = "term")
public class Term {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long termId;
    @NotNull
    private String date;
    @NotNull
    private String hour;
    @NotNull
    private long doctorId;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    public TermsDto dto() {
        return TermsDto.builder()
                .termId(termId)
                .date(date)
                .hour(hour)
                .status(status)
                .doctorId(doctorId)
                .build();
    }
}
