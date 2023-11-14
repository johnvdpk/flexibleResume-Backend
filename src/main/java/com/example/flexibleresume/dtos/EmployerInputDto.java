package com.example.flexibleresume.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerInputDto {


    private String industry;
    private String officeAdress;
    private String OfficeAdressNumber;
    private String officeZipcode;
    private String officeCityLocation;
    private String kvk;
    private String mission;
    private String vision;
    private String numberOfEmployees;

}
