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

    @CrossOrigin
    @GetMapping("/open-terms-date/{doctorId}/{date}")
    public DoctorTermsDto getOpenDoctorTermsByDate(@PathVariable long doctorId, @PathVariable String date) {
        return doctorService.getOpenTermsByDate(doctorId, date);
    }

    @CrossOrigin
    @GetMapping("/terms-date/{doctorId}/{date}")
    public DoctorTermsDto getDoctorTermsByDate(@PathVariable long doctorId, @PathVariable String date) {
        return doctorService.getDoctorTermsByDate(doctorId, date);
    }

    @CrossOrigin
    @GetMapping("/taken-terms-date/{doctorId}/{date}")
    public DoctorTermsDto getTakenDoctorTermsByDate(@PathVariable long doctorId, @PathVariable String date) {
        return doctorService.getDoctorTakenTermsByDate(doctorId, date);
    }

}
