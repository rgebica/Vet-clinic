package com.clinic.vetclinic.repository;

import com.clinic.vetclinic.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
