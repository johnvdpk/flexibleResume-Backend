package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.services.JobSeekerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/werkzoekende") // website is voor nu in het nederlands
public class JobSeekerController {


    // Je kan op id, voornaam, achternaam en op iedereen zoeken.
    // Je kan een persoon toevoegen aan de jobseekers.
    //TODO er moet nog een update optie en een delete optie worden toegevoegd.




    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }


    @GetMapping
    public ResponseEntity<List<JobSeeker>>getAllJobSeekers(@RequestParam(value = "id", required = false)Optional<Long> id) {
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers(id);

    return ResponseEntity.ok().body(jobSeekers);

    }


    @GetMapping("/{firstName}")
    public ResponseEntity<JobSeekerDto> getJobSeekerByFirstName(@PathVariable String firstName) {
        JobSeekerDto jobSeekerDto = jobSeekerService.getJobSeekerByFirstName(firstName);

        return ResponseEntity.ok(jobSeekerDto);
    }

    @GetMapping("/{surName}")
    public ResponseEntity<JobSeekerDto> getJobSeekerBySurName(@PathVariable String surName) {
        JobSeekerDto jobSeekerDto = jobSeekerService.getJobSeekerBySurName(surName);

        return ResponseEntity.ok(jobSeekerDto);
    }


    @PostMapping()
    public ResponseEntity<JobSeekerDto> addJobSeeker(@Valid @RequestBody JobSeekerInputDto jobSeekerInputDto) {
        JobSeekerDto jobSeekerDto = jobSeekerService.addJobSeeker(jobSeekerInputDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(jobSeekerDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(jobSeekerDto);
    }




}
