package com.example.flexibleresume.dtos;

import com.example.flexibleresume.models.Employer;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerJobInfoDto {

    private Long id;
    private Employer employer;
    private String jobDescription;
    private String jobRequirements;
    private String skill;
    private String education;
    private String yearsOfExperience;
    private String jobOffer;
    private String salaryIndication;
    private String extras;
}
