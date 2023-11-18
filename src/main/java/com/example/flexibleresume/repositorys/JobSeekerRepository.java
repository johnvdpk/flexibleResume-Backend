package com.example.flexibleresume.repositorys;

import com.example.flexibleresume.models.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobSeekerRepository  extends JpaRepository<JobSeeker, Long> {


Optional<JobSeeker> findByFirstName(String firstName);
Optional<JobSeeker> findBySurName(String surName);
List<JobSeeker> findAllJobSeekersBySurName(String surName);



}
