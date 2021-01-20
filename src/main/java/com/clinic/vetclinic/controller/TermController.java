package com.clinic.vetclinic.controller;

import com.clinic.vetclinic.dto.CreateTermDto;
import com.clinic.vetclinic.service.TermService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class TermController {

    TermService termService;

    @CrossOrigin
    @PostMapping("/create-term")
    public ResponseEntity<String> createTerm(@RequestBody CreateTermDto createTerm) {
        termService.createTerm(createTerm);
        return new ResponseEntity<>("Term created", CREATED);
    }
}
