package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.services.JobSeekerService;
import com.example.flexibleresume.user.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/werkzoekende") // website is in het Nederlands
public class JobSeekerController {


    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<JobSeeker>>getAllJobSeekers(@RequestParam(value = "id", required = false)Optional<Long> id) {
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers(id);

    return ResponseEntity.ok().body(jobSeekers);

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

//    @PostMapping()
//    public ResponseEntity<JobSeekerDto> addJobSeeker(@Valid @RequestBody JobSeekerInputDto jobSeekerInputDto) {
//        JobSeekerDto jobSeekerDto = jobSeekerService.addJobSeeker(jobSeekerInputDto);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(jobSeekerDto.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).body(jobSeekerDto);
//    }

    @PostMapping
    public ResponseEntity<JobSeekerDto> addJobSeeker(@RequestBody JobSeekerInputDto jobSeekerInputDto) {

        JobSeekerDto jobSeekerDto = jobSeekerService.addJobSeeker(jobSeekerInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobSeekerDto);
    }



    @PutMapping("/{id}")
    public ResponseEntity<JobSeekerDto> updateJobSeeker(@PathVariable Long id, @Valid @RequestBody JobSeekerInputDto jobSeekerInputDto) {
        JobSeekerDto jobSeekerDto = jobSeekerService.updateJobSeeker(id, jobSeekerInputDto);

        return ResponseEntity.ok().body(jobSeekerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobSeekerDto> deleteJobSeeker(@PathVariable Long id) {
        jobSeekerService.deleteJobSeeker(id);

        return ResponseEntity.noContent().build();
    }


}
