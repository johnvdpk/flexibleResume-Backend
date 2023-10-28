package com.example.flexibleresume.models;


import jakarta.persistence.*;

@Entity
@Table(name = "job_info")
public class JobInfo {

    @Id
    @GeneratedValue
    private Long id;

    //    bedrijf / company ←- koppelen met employer ? onetomany
    //    Branch / industry ... zelfde als hierovern.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employer_id")
    private Employer employer;

    @Column(name = "job_descriptions", length=1000)
    private String jobDescription;

    @Column(name = "job_requirements", length = 1000)  // Algemene job requirements naast de skills, education en years of experience
    private String jobRequirements;

    @Column(name= "skills")
    private String skill;

    @Column(name= "educations")
    private String education;

    @Column(name="years_of_experience")
    private String yearsOfExperience;

    @Column(name = "job_offers", length = 1000)  // Algemene job offers, naast salary indication en extras
    private String jobOffer;

    @Column(name = "salary_indications")
    private String salaryIndication;


    @Column(name = "extras")
    private String extras;






}
