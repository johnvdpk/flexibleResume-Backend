package com.example.flexibleresume.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerDto {


    private String firstName;
    private String surName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String residence;
    private String zipCode;
    private String homeAddress;
    private String houseNumber;

}


