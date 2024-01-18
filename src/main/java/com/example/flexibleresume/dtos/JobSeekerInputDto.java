package com.example.flexibleresume.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerInputDto {


    @NotBlank(message = "Graag een voornaam invullen")
    private String firstName;
    @NotBlank(message = "Graag een achternaam invullen")
    private String surName;
    @NotBlank(message = "Graag een geboortedatum invullen")
    @Past(message = "Graag een geldige geboortedatum invullen")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Graag een email invullen")
    @Email(message = "Graag een geldig email invullen")
    private String email;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Graag een geldig telefoonnummer invullen")
    private String phoneNumber;
    @NotBlank(message = "Graag een woonplaats invullen")
    private String residence;
    @NotBlank(message = "Graag een postcode invullen")
    private String zipCode;
    @NotBlank(message = "Graag een adres invullen")
    private String homeAddress;
    @NotBlank(message = "Graag een huisnummer invullen")
    private String houseNumber;


}
