package com.example.flexibleresume.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employer_job_info")
public class EmployerJobInfo {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employer_id")
    private Employer employer;

    @Column(name = "job_descriptions", length=1000)
    private String jobDescription;

    @Column(name = "job_requirements", length = 1000)
    private String jobRequirements;

    @Column(name= "skills")
    private String skill;

    @Column(name= "educations")
    private String education;

    @Column(name="years_of_experience")
    private String yearsOfExperience;

    @Column(name = "job_offers", length = 1000)
    private String jobOffer;

    @Column(name = "salary_indications")
    private String salaryIndication;

    @Column(name = "extras")
    private String extras;



}
