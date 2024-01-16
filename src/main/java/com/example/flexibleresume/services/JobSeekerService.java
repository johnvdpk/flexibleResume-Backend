package com.example.flexibleresume.services;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.repositorys.JobSeekerRepository;
import com.example.flexibleresume.repositorys.UserRepository;
import com.example.flexibleresume.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobSeekerService {

    private final JobSeekerRepository jobSeekerRepos;
    private final UserRepository userRepos;
    private final CVRepository CVRepos;



    public JobSeekerDto jobSeekerToDto(JobSeeker jobSeeker) {
    JobSeekerDto jobSeekerDto = new JobSeekerDto();


    jobSeekerDto.setFirstName(jobSeeker.getFirstName());
    jobSeekerDto.setSurName(jobSeeker.getSurName());
    jobSeekerDto.setDateOfBirth(jobSeeker.getDateOfBirth());
    jobSeekerDto.setEmail(jobSeeker.getEmail());
    jobSeekerDto.setPhoneNumber(jobSeeker.getPhoneNumber());
    jobSeekerDto.setResidence(jobSeeker.getResidence());
    jobSeekerDto.setZipCode(jobSeeker.getZipCode());
    jobSeekerDto.setHomeAddress(jobSeeker.getHomeAddress());
    jobSeekerDto.setHouseNumber(jobSeeker.getHouseNumber());

    return jobSeekerDto;

    }



    public JobSeeker inputDtoToJobSeeker(JobSeekerInputDto jobSeekerInputDto) {
        JobSeeker jobSeeker = new JobSeeker();


        jobSeeker.setFirstName(jobSeekerInputDto.getFirstName());
        jobSeeker.setSurName(jobSeekerInputDto.getSurName());
        jobSeeker.setDateOfBirth(jobSeekerInputDto.getDateOfBirth());
        jobSeeker.setEmail(jobSeekerInputDto.getEmail());
        jobSeeker.setPhoneNumber(jobSeekerInputDto.getPhoneNumber());
        jobSeeker.setResidence(jobSeekerInputDto.getResidence());
        jobSeeker.setZipCode(jobSeekerInputDto.getZipCode());
        jobSeeker.setHomeAddress(jobSeekerInputDto.getHomeAddress());
        jobSeeker.setHouseNumber(jobSeekerInputDto.getHouseNumber());

        return jobSeeker;
    }

    public CV addCVToJobSeeker(Long jobSeekerId, CV cv) {
        JobSeeker jobSeeker = jobSeekerRepos.findById(jobSeekerId)
                .orElseThrow(() -> new RecordNotFoundException("JobSeeker niet gevonden"));
        cv.setJobSeeker(jobSeeker);
        return CVRepos.save(cv);
    }



    public List<JobSeekerDto> getAllJobSeekers() {
        List<JobSeeker> jobseekerList = jobSeekerRepos.findAll();
        List<JobSeekerDto> jobseekerDtoList = new ArrayList<>();

        for (JobSeeker jobseeker : jobseekerList) {
            JobSeekerDto dto = jobSeekerToDto(jobseeker);
            jobseekerDtoList.add(dto);
        }
        return jobseekerDtoList;

    }

    public List<JobSeekerDto> getAllJobSeekersBySurName(String surName) {
        List<JobSeeker> jobSeekerList = jobSeekerRepos.findAllJobSeekersBySurName(surName);
        List<JobSeekerDto> jobSeekerDtoList = new ArrayList<>();

        for(JobSeeker jobSeeker : jobSeekerList) {
            JobSeekerDto dto = jobSeekerToDto(jobSeeker);
            jobSeekerDtoList.add(dto);
        }
        return jobSeekerDtoList;
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

    public JobSeekerDto getJobSeekerByEmail(String email) {
        User user = userRepos.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("User niet gevonden"));

        JobSeeker jobSeeker = user.getJobSeeker();
        if (jobSeeker == null) {
            throw new RecordNotFoundException("Geen JobSeeker gekoppeld aan gebruiker");
        }

        return jobSeekerToDto(jobSeeker);
    }


    public JobSeekerDto addJobSeeker(JobSeekerInputDto jobSeekerInputDto ) {

        JobSeeker jobseeker = inputDtoToJobSeeker(jobSeekerInputDto);
        jobSeekerRepos.save(jobseeker);

        return jobSeekerToDto(jobseeker);

    }


    public JobSeekerDto updateJobSeeker(String email, JobSeekerInputDto jobSeekerInputDto) {
        User user = userRepos.findByEmail(email).orElseThrow(() -> new RecordNotFoundException("User niet gevonden"));
        JobSeeker existingJobSeeker = user.getJobSeeker();

        if(existingJobSeeker == null) {
               throw new RecordNotFoundException("Geen JobSeeker gekoppeld aan deze user gevonden");
        }

        existingJobSeeker.setFirstName(jobSeekerInputDto.getFirstName());
        existingJobSeeker.setSurName(jobSeekerInputDto.getSurName());
        existingJobSeeker.setDateOfBirth(jobSeekerInputDto.getDateOfBirth());
        existingJobSeeker.setEmail(jobSeekerInputDto.getEmail());
        existingJobSeeker.setPhoneNumber(jobSeekerInputDto.getPhoneNumber());
        existingJobSeeker.setResidence(jobSeekerInputDto.getResidence());
        existingJobSeeker.setZipCode(jobSeekerInputDto.getZipCode());
        existingJobSeeker.setHomeAddress(jobSeekerInputDto.getHomeAddress());
        existingJobSeeker.setHouseNumber(jobSeekerInputDto.getHouseNumber());


        JobSeeker updatedJobSeeker = jobSeekerRepos.save(existingJobSeeker);


        return jobSeekerToDto(updatedJobSeeker);
    }

    public void deleteJobSeeker(Long id) {
        jobSeekerRepos.deleteById(id);
    }


}
