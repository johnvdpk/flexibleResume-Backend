package com.example.flexibleresume.services;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.JobSeekerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerService {

    private final JobSeekerRepository jobSeekerRepos;

    public JobSeekerService(JobSeekerRepository jobSeekerRepos) {
        this.jobSeekerRepos = jobSeekerRepos;
    }

    // JobSeeker naar JobSeekerDto. Database richting client.
    public JobSeekerDto clientToDatabase(JobSeeker jobSeeker) {
    JobSeekerDto jobSeekerDto = new JobSeekerDto();

    jobSeekerDto.setId(jobSeeker.getId());
    jobSeekerDto.setFirstName(jobSeeker.getFirstName());
    jobSeekerDto.setSurName(jobSeeker.getSurName());
    jobSeekerDto.setDateOfBirth(jobSeeker.getDateOfBirth());
    jobSeekerDto.setEmail(jobSeeker.getEmail());
    jobSeekerDto.setZipCode(jobSeeker.getZipCode());
    jobSeekerDto.setHomeAddress(jobSeeker.getHomeAddress());

    return jobSeekerDto;

    }


    // InputDto naar JobSeeker. Client richting Database



    public List<JobSeeker> getAllJobSeekers(Optional<Long> id) {
        if (id.isPresent()) {
            Optional<JobSeeker> jobSeekerOptional = jobSeekerRepos.findById(id.get());
            return List.of(jobSeekerOptional.get());
        }
        return jobSeekerRepos.findAll();


    }


}
