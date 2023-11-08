package com.example.flexibleresume.models;


import jakarta.persistence.*;

@Entity
@Table(name = "employer_job_info")
public class EmployerJobInfo {

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


    public EmployerJobInfo(Long id, Employer employer, String jobDescription, String jobRequirements, String skill, String education, String yearsOfExperience, String jobOffer, String salaryIndication, String extras) {
        this.id = id;
        this.employer = employer;
        this.jobDescription = jobDescription;
        this.jobRequirements = jobRequirements;
        this.skill = skill;
        this.education = education;
        this.yearsOfExperience = yearsOfExperience;
        this.jobOffer = jobOffer;
        this.salaryIndication = salaryIndication;
        this.extras = extras;
    }

    public EmployerJobInfo(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobRequirements() {
        return jobRequirements;
    }

    public void setJobRequirements(String jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(String jobOffer) {
        this.jobOffer = jobOffer;
    }

    public String getSalaryIndication() {
        return salaryIndication;
    }

    public void setSalaryIndication(String salaryIndication) {
        this.salaryIndication = salaryIndication;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }
}
