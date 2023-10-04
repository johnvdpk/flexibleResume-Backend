package com.example.flexibleresume.repositorys;

import com.example.flexibleresume.models.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository  extends JpaRepository<JobSeeker, Long> {
}
