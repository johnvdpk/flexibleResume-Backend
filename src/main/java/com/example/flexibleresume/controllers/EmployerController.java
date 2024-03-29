package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.EmployerDto;
import com.example.flexibleresume.dtos.EmployerInputDto;
import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.exceptions.ErrorResponse;
import com.example.flexibleresume.services.EmployerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/employer")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;


    @GetMapping("/{id}")
    public ResponseEntity<EmployerDto> getEmployerById(@PathVariable Long id) {
        EmployerDto employer = employerService.getEmployerById(id);
        if(employer == null) {
           ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het ophalen van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(employer);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<EmployerDto> getJobSeekerByEmail(@PathVariable String email) {
        EmployerDto employerDto = employerService.getEmployerByEmail(email);
        if(employerDto == null) {
            ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het ophalen van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok().body(employerDto);
    }

    @PostMapping
    public ResponseEntity<EmployerDto> addEmployer(@RequestBody EmployerInputDto employerInputDto) {
        EmployerDto newEmployer = employerService.addEmployer(employerInputDto);
        if(newEmployer == null) {
           ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het posten van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployer);
    }

    @PutMapping("/email/{email}")
    public ResponseEntity<EmployerDto> updateEmployer(@PathVariable String email, @Valid @RequestBody EmployerInputDto employerInputDto) {
        EmployerDto updatedEmployer = employerService.updateEmployer(email, employerInputDto);
        if (updatedEmployer == null) {
           ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het updaten van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }


        return ResponseEntity.ok(updatedEmployer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
        if(employerService.getEmployerById(id) != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
