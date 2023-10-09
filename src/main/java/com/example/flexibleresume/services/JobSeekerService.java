package com.example.flexibleresume.services;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
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
    public JobSeekerDto jobSeekerToDto(JobSeeker jobSeeker) {
    JobSeekerDto jobSeekerDto = new JobSeekerDto();

    jobSeekerDto.setId(jobSeeker.getId());
    jobSeekerDto.setFirstName(jobSeeker.getFirstName());
    jobSeekerDto.setSurName(jobSeeker.getSurName());
    jobSeekerDto.setDateOfBirth(jobSeeker.getDateOfBirth());
    jobSeekerDto.setEmail(jobSeeker.getEmail());
    jobSeekerDto.setPhoneNumber(jobSeeker.getPhoneNumber());
    jobSeekerDto.setZipCode(jobSeeker.getZipCode());
    jobSeekerDto.setHomeAddress(jobSeeker.getHomeAddress());
    jobSeekerDto.setHouseNumber(jobSeeker.getHouseNumber());

    return jobSeekerDto;

    }


    // InputDto naar JobSeeker. Client richting Database
    public JobSeeker inputDtoToJobSeeker(JobSeekerInputDto jobSeekerInputDto) {
        JobSeeker jobSeeker = new JobSeeker();

        jobSeeker.setId(jobSeekerInputDto.getId());
        jobSeeker.setFirstName(jobSeekerInputDto.getFirstName());
        jobSeeker.setSurName(jobSeekerInputDto.getSurName());
        jobSeeker.setDateOfBirth(jobSeekerInputDto.getDateOfBirth());
        jobSeeker.setEmail(jobSeekerInputDto.getEmail());
        jobSeeker.setPhoneNumber(jobSeekerInputDto.getPhoneNumber());
        jobSeeker.setZipCode(jobSeekerInputDto.getZipCode());
        jobSeeker.setHomeAddress(jobSeekerInputDto.getHomeAddress());
        jobSeeker.setHouseNumber(jobSeekerInputDto.getHouseNumber());

        return jobSeeker;
    }


    // Alle Gets


    public List<JobSeeker> getAllJobSeekers(Optional<Long> id) {
        if (id.isPresent()) {
            Optional<JobSeeker> jobSeekerOptional = jobSeekerRepos.findById(id.get());
            return List.of(jobSeekerOptional.get());
        }
        return jobSeekerRepos.findAll();


    }

    public JobSeekerDto getJobSeekerByFirstName(String firstName) {
        Optional<JobSeeker> optionalJobSeekerName = jobSeekerRepos.findByFirstName(firstName);
        JobSeekerDto jobSeekerDto = new JobSeekerDto();

        if (optionalJobSeekerName.isPresent()) {
            JobSeeker jobSeekerEntity = optionalJobSeekerName.get();
            jobSeekerDto = jobSeekerToDto(jobSeekerEntity);
        }

        return jobSeekerDto;
    }

    public JobSeekerDto getJobSeekerBySurName(String surName) {
        Optional<JobSeeker> optionalJobSeekerName = jobSeekerRepos.findBySurName(surName);
        JobSeekerDto jobSeekerDto = new JobSeekerDto();

        if (optionalJobSeekerName.isPresent()) {
            JobSeeker jobSeekerEntity = optionalJobSeekerName.get();
            jobSeekerDto = jobSeekerToDto(jobSeekerEntity);
        }

        return jobSeekerDto;
    }


    // add
    // note to myself. InputDto wordt omgezet naar het model. En vervolgens wordt het weer terug gegegeven aan de dto

    public JobSeekerDto addJobSeeker(JobSeekerInputDto jobSeekerInputDto) {
        JobSeeker jobseeker = inputDtoToJobSeeker(jobSeekerInputDto);
        jobSeekerRepos.save(jobseeker);

        return jobSeekerToDto(jobseeker);

    }


//TODO controleren of deze functie werkt
    public JobSeekerDto updateJobSeeker(Long id,JobSeekerInputDto jobSeekerInputDto) {
        Optional<JobSeeker> jobSeeker = jobSeekerRepos.findById(id);

        if(jobSeeker.isPresent()) {
            JobSeeker updateJobSeeker = new JobSeeker();

            updateJobSeeker.setId(jobSeekerInputDto.getId());
            updateJobSeeker.setFirstName(jobSeekerInputDto.getFirstName());
            updateJobSeeker.setSurName(jobSeekerInputDto.getSurName());
            updateJobSeeker.setDateOfBirth(jobSeekerInputDto.getDateOfBirth());
            updateJobSeeker.setEmail(jobSeekerInputDto.getEmail());
            updateJobSeeker.setPhoneNumber(jobSeekerInputDto.getPhoneNumber());
            updateJobSeeker.setZipCode(jobSeekerInputDto.getZipCode());
            updateJobSeeker.setHomeAddress(jobSeekerInputDto.getHomeAddress());
            updateJobSeeker.setHouseNumber(jobSeekerInputDto.getHouseNumber());
            JobSeeker updatedJobSeeker = jobSeekerRepos.save(updateJobSeeker);

            return jobSeekerToDto(updatedJobSeeker);

        } else {
            throw new RecordNotFoundException("Geen persoon met gegeven id gevonden");
        }



    }




}
