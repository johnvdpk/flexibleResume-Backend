package com.example.flexibleresume.repositorys;

import com.example.flexibleresume.models.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JobSeekerRepository  extends JpaRepository<JobSeeker, Long> {

    // Maakt het mogelijk om ook in de tabel jobseekers te zoeken naar voor en achternaam

Optional<JobSeeker> findByFirstName(String firstName);
Optional<JobSeeker> findBySurName(String surName);



}
