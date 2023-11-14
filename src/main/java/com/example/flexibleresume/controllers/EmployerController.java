package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.EmployerDto;
import com.example.flexibleresume.dtos.EmployerInputDto;
import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.services.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/werkgever") // Nederlandse website
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;


    @GetMapping("/{id}")
    public ResponseEntity<EmployerDto> getEmployerById(@PathVariable Long id) {
        EmployerDto employer = employerService.getEmployerById(id);
        return ResponseEntity.ok(employer);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<EmployerDto> getJobSeekerByEmail(@PathVariable String email) {
        EmployerDto employerDto = employerService.getEmployerByEmail(email);

        return ResponseEntity.ok().body(employerDto);
    }

    @PostMapping
    public ResponseEntity<EmployerDto> addEmployer(@RequestBody EmployerInputDto employerInputDto) {
        EmployerDto newEmployer = employerService.addEmployer(employerInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployerDto> updateEmployer(@PathVariable Long id, @RequestBody EmployerInputDto employerInputDto) {
        EmployerDto updatedEmployer = employerService.updateEmployer(id, employerInputDto);
        return ResponseEntity.ok(updatedEmployer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
        return ResponseEntity.noContent().build();
    }
}
