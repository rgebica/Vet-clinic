package com.clinic.vetclinic.controller;

import com.clinic.vetclinic.dto.DoctorTermsDto;
import com.clinic.vetclinic.service.DoctorService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class DoctorTermsController {

    DoctorService doctorService;

    @CrossOrigin
    @GetMapping("/all-terms/{doctorId}")
    public DoctorTermsDto getDoctorTerms(@PathVariable long doctorId) {
        return doctorService.getAllDoctorTerms(doctorId);
    }

    @CrossOrigin
    @GetMapping("/open-terms/{doctorId}")
    public DoctorTermsDto getOpenDoctorTerms(@PathVariable long doctorId) {
        return doctorService.getAllFreeDoctorTerms(doctorId);
    }

    @CrossOrigin
    @GetMapping("/taken-terms/{doctorId}")
    public DoctorTermsDto getTakenDoctorTerms(@PathVariable long doctorId) {
        return doctorService.getAllTakenDoctorTerms(doctorId);
    }
}
