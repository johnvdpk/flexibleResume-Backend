package com.example.flexibleresume.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerInputDto {


    private String firstName;
    @NotBlank
    private String surName;
    @NotBlank
    private LocalDate dateOfBirth;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String homeTown;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String homeAddress;
    @NotBlank
    private String houseNumber;


}
