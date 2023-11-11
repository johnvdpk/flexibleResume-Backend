package com.example.flexibleresume.dtos;

import com.example.flexibleresume.models.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerJobInfoInputDto {



    private String jobDescription;
    private String jobRequirements;
    private String skill;
    private String education;
    private String yearsOfExperience;
    private String jobOffer;
    private String salaryIndication;
    private String extras;
}
