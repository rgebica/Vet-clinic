package com.clinic.vetclinic.repository;

import com.clinic.vetclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findAllByCustomerId(long customerId);
}
