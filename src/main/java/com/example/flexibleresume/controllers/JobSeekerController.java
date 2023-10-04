package com.example.flexibleresume.controllers;

import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.services.JobSeekerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/werkzoekende") // website is voor nu in het nederlands
public class JobSeekerController {


    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }


    @GetMapping
    public ResponseEntity<List<JobSeeker>>getAllJobSeekers(@RequestParam(value = "id", required = false)Optional<Long> id) {
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers(id);

    return ResponseEntity.ok().body(jobSeekers);

    }



}
