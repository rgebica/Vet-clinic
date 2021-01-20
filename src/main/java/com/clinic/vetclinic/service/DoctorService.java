package com.clinic.vetclinic.service;

import com.clinic.vetclinic.dto.DoctorTermsDto;
import com.clinic.vetclinic.dto.TermsDto;
import com.clinic.vetclinic.exception.DoctorNotFoundException;
import com.clinic.vetclinic.model.Doctor;
import com.clinic.vetclinic.model.Term;
import com.clinic.vetclinic.repository.DoctorRepository;
import com.clinic.vetclinic.repository.TermRepository;
import com.clinic.vetclinic.repository.VisitRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorService {

    DoctorRepository doctorRepository;
    TermRepository termRepository;
    VisitRepository visitRepository;

    public DoctorTermsDto getAllDoctorTerms(long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        List<TermsDto> terms = termRepository.findTermsByDoctorId(doctorId).stream()
                .map(Term::dto)
                .collect(Collectors.toList());

        return DoctorTermsDto.builder()
                .doctorId(doctor.getDoctorId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .terms(terms)
                .build();
    }

    public DoctorTermsDto getAllFreeDoctorTerms(long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        List<TermsDto> terms = termRepository.findFreeTermsByDoctorId(doctorId).stream()
                .map(Term::dto)
                .collect(Collectors.toList());

        return DoctorTermsDto.builder()
                .doctorId(doctor.getDoctorId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .terms(terms)
                .build();
    }

    public DoctorTermsDto getAllTakenDoctorTerms(long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        List<TermsDto> terms = termRepository.findTakenTermsByDoctorId(doctorId).stream()
                .map(Term::dto)
                .collect(Collectors.toList());

        return DoctorTermsDto.builder()
                .doctorId(doctor.getDoctorId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .terms(terms)
                .build();
    }

    public DoctorTermsDto getOpenTermsByDate(long doctorId, String date) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        List<TermsDto> terms = termRepository.findOpenTermsByDoctorIdAndDate(doctorId, date).stream()
                .map(Term::dto)
                .collect(Collectors.toList());

        return DoctorTermsDto.builder()
                .doctorId(doctor.getDoctorId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .terms(terms)
                .build();
    }

    public DoctorTermsDto getDoctorTermsByDate(long doctorId, String date) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        List<TermsDto> terms = termRepository.findTermsByDoctorIdAndDate(doctorId, date).stream()
                .map(Term::dto)
                .collect(Collectors.toList());

        return DoctorTermsDto.builder()
                .doctorId(doctor.getDoctorId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .terms(terms)
                .build();
    }

    public DoctorTermsDto getDoctorTakenTermsByDate(long doctorId, String date) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        List<TermsDto> terms = termRepository.findTakenTermsByDoctorIdAndDate(doctorId, date).stream()
                .map(Term::dto)
                .collect(Collectors.toList());

        return DoctorTermsDto.builder()
                .doctorId(doctor.getDoctorId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .terms(terms)
                .build();
    }
}
