package com.example.flexibleresume.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto {


    @NotEmpty(message = "bedrijfsnaam ma niet leeg zijn")
    private String company;
    @NotBlank(message = "industrie mag niet leeg zijn")
    private String industry;
    @NotBlank(message = "adres mag niet leeg zijn")
    private String officeAdress;
    @NotBlank(message = "kantoornummer mag niet leeg zijn")
    private String officeAdressNumber;
    @NotBlank(message = "postcode mag niet leeg zijn")
    private String officeZipcode;
    @NotBlank(message = "plaats mag niet leeg zijn")
    private String officeCityLocation;
    @Pattern(regexp = "^[0-9]{8}$", message = "ongeldig kvk nummer")
    private String kvk;
    @Size(max = 500, message = "missie mag niet langer zijn dan 500 karakters")
    private String mission;
    @Size(max = 500, message = "visie mag niet langer zijn dan 500 karakters")
    private String vision;
    @Pattern(regexp = "^[0-9]{1,4}$", message = "ongeldig aantal werknemers")
    private String numberOfEmployees;
}
