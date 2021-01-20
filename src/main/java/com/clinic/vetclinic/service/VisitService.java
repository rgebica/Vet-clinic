package com.clinic.vetclinic.service;

import com.clinic.vetclinic.dto.CancelVisitDto;
import com.clinic.vetclinic.dto.CustomerVisitDto;
import com.clinic.vetclinic.dto.TakeTermDto;
import com.clinic.vetclinic.dto.TermsDto;
import com.clinic.vetclinic.exception.*;
import com.clinic.vetclinic.model.Customer;
import com.clinic.vetclinic.model.Status;
import com.clinic.vetclinic.model.Term;
import com.clinic.vetclinic.model.Visit;
import com.clinic.vetclinic.repository.CustomerRepository;
import com.clinic.vetclinic.repository.TermRepository;
import com.clinic.vetclinic.repository.VisitRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VisitService {

    VisitRepository visitRepository;
    CustomerRepository customerRepository;
    TermRepository termRepository;

    public void takeTerm(TakeTermDto takeTermDto) {
        Visit visit = new Visit();
        Term term = termRepository.findById(takeTermDto.getTermId())
                .orElseThrow(() -> new TermNotFoundException(takeTermDto.getTermId()));
        if (checkUserCredentials(takeTermDto.getUserId(), takeTermDto.getCodePin()) && checkIfTermIsOpen(takeTermDto.getTermId())) {
            visit.setTermId(takeTermDto.getTermId());
            visit.setCustomerId(takeTermDto.getUserId());
            term.setStatus(Status.TAKEN);
            visitRepository.save(visit);
            termRepository.save(term);
        }
    }

    public void cancelVisit(CancelVisitDto cancelVisitDto) {
        Visit visit = visitRepository.findById(cancelVisitDto.getVisitId())
                .orElseThrow(() -> new VisitNotFoundException(cancelVisitDto.getVisitId()));
        Term term = termRepository.findById(visit.getTermId())
                .orElseThrow(() -> new TermNotFoundException(visit.getTermId()));
        if (checkUserCredentials(cancelVisitDto.getUserId(), cancelVisitDto.getCodePin())) {
            visitRepository.delete(visit);
            term.setStatus(Status.OPEN);
            termRepository.save(term);
        }
    }

    boolean checkIfTermIsOpen(long termId) {
        TermsDto term = findTermById(termId);
        if (term.getStatus().equals(Status.OPEN)) {
            return true;
        } else {
            throw new TermIsAlreadyTakenException(termId);
        }
    }

    boolean checkUserCredentials(long customerId, long codePin) {
        if (customerRepository.existsByCustomerIdAndCodePin(customerId, codePin)) {
            return true;
        } else {
            throw new CustomerBadCredentialsException(customerId, codePin);
        }
    }

    TermsDto findTermById(long termId) {
        return termRepository.findById(termId)
                .map(Term::dto)
                .orElseThrow(() -> new TermNotFoundException(termId));
    }

    public CustomerVisitDto customerVisits(long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        List<Long> longTerms = visitRepository.findAllByCustomerId(customerId).stream()
                .map(Visit::getTermId)
                .collect(Collectors.toList());

        List<TermsDto> visits = termRepository.findAllByTermIdIn(longTerms).stream()
                .map(Term::dto)
                .collect(Collectors.toList());

        return CustomerVisitDto.builder()
                .customerId(customerId)
                .customerName(customer.getFirstName())
                .customerLastName(customer.getLastName())
                .visits(visits)
                .build();
    }
}
