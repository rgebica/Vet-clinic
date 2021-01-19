package com.clinic.vetclinic.controller;

import com.clinic.vetclinic.dto.TakeTermDto;
import com.clinic.vetclinic.service.VisitService;
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
public class VisitController {

    VisitService visitService;

    @CrossOrigin
    @PostMapping("/take-term")
    public ResponseEntity<String> createUser(@RequestBody TakeTermDto takeTermDto) {
        visitService.takeTerm(takeTermDto);
        return new ResponseEntity<>("Term taken", CREATED);
    }
}