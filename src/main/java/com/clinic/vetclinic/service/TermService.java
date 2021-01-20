package com.clinic.vetclinic.service;

import com.clinic.vetclinic.dto.CreateTermDto;
import com.clinic.vetclinic.dto.TakeTermDto;
import com.clinic.vetclinic.exception.TermNotFoundException;
import com.clinic.vetclinic.model.Status;
import com.clinic.vetclinic.model.Term;
import com.clinic.vetclinic.model.Visit;
import com.clinic.vetclinic.repository.TermRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TermService {

    TermRepository termRepository;

    public void createTerm(CreateTermDto createTermDto) {
        Term term = new Term();
        term.setDate(createTermDto.getDate());
        term.setHour(createTermDto.getHour());
        term.setDoctorId(createTermDto.getDoctorId());
        term.setStatus(Status.OPEN);
        termRepository.save(term);
    }
}
