package com.clinic.vetclinic.repository;

import com.clinic.vetclinic.model.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TermRepository extends JpaRepository<Term, Long> {
    @Modifying
    @Query("SELECT t FROM Term t WHERE t.doctorId = ?1")
    List<Term> findTermsByDoctorId(long doctorId);

    @Modifying
    @Query("SELECT t FROM Term t WHERE t.doctorId = ?1 and t.status = 'OPEN'")
    List<Term> findFreeTermsByDoctorId(long doctorId);

    @Modifying
    @Query("SELECT t FROM Term t WHERE t.doctorId = ?1 and t.status = 'TAKEN'")
    List<Term> findTakenTermsByDoctorId(long doctorId);

    @Modifying
    @Query("SELECT t FROM Term t WHERE t.doctorId = ?1 and t.date = ?2 and t.status = 'OPEN'")
    List<Term> findOpenTermsByDoctorIdAndDate(long doctorId, String date);

    @Modifying
    @Query("SELECT t FROM Term t WHERE t.doctorId = ?1 and t.date = ?2")
    List<Term> findTermsByDoctorIdAndDate(long doctorId, String date);

    @Modifying
    @Query("SELECT t FROM Term t WHERE t.doctorId = ?1 and t.date = ?2 and t.status = 'TAKEN'")
    List<Term> findTakenTermsByDoctorIdAndDate(long doctorId, String date);

    List<Term> findAllByTermIdIn(List<Long> longTerms);
}
