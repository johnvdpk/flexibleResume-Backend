package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.services.JobSeekerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/werkzoekende") // website is in het Nederlands
public class JobSeekerController {


    private final JobSeekerService jobSeekerService;



    @GetMapping("/naam")
    public ResponseEntity<List<JobSeekerDto>> getAllJobSeekers(@RequestParam(value = "surName", required = false) Optional<String> surName) {

        List<JobSeekerDto> jobSeekerDtos;

        if (surName.isEmpty()){

            jobSeekerDtos = jobSeekerService.getAllJobSeekers();

        } else {
            jobSeekerDtos = jobSeekerService.getAllJobSeekersBySurName(surName.get());

        }

        return ResponseEntity.ok().body(jobSeekerDtos);

    }


    @GetMapping("/voornaam/{firstName}")
    public ResponseEntity<JobSeekerDto> getJobSeekerByFirstName(@PathVariable String firstName) {
        JobSeekerDto jobSeekerDto = jobSeekerService.getJobSeekerByFirstName(firstName);

        return ResponseEntity.ok(jobSeekerDto);
    }

    @GetMapping("/achternaam/{surName}")
    public ResponseEntity<JobSeekerDto> getJobSeekerBySurName(@PathVariable String surName) {
        JobSeekerDto jobSeekerDto = jobSeekerService.getJobSeekerBySurName(surName);

        return ResponseEntity.ok(jobSeekerDto);
    }


    @PostMapping
    public ResponseEntity<JobSeekerDto> addJobSeeker(@RequestBody JobSeekerInputDto jobSeekerInputDto)
    {
        JobSeekerDto jobSeekerDto = jobSeekerService.addJobSeeker(jobSeekerInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobSeekerDto);
    }


    @PutMapping("/email/{email}")
    public ResponseEntity<JobSeekerDto> updateJobSeeker(@PathVariable String email, @Valid @RequestBody JobSeekerInputDto jobSeekerInputDto) {
        JobSeekerDto jobSeekerDto = jobSeekerService.updateJobSeeker(email, jobSeekerInputDto);

        return ResponseEntity.ok().body(jobSeekerDto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<JobSeekerDto> getJobSeekerByEmail(@PathVariable String email) {
        JobSeekerDto jobSeekerDto = jobSeekerService.getJobSeekerByEmail(email);

        return ResponseEntity.ok().body(jobSeekerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobSeekerDto> deleteJobSeeker(@PathVariable Long id) {
        jobSeekerService.deleteJobSeeker(id);

        return ResponseEntity.noContent().build();
    }


}
