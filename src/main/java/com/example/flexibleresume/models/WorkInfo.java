package com.example.flexibleresume.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="work_info")
public class WorkInfo {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private CV cv;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="companys")
    private String company;

    @Column(name="jobtitles")
    private String jobTitle;

    @Column(name="period_of_employment")
    private String periodOfEmployment;

    @Column(name="job_information")
    private String jobInfo;


    public WorkInfo(CV cv, Long id, String company, String jobTitle, String periodOfEmployment, String jobInfo) {
        this.cv = cv;
        this.id = id;
        this.company = company;
        this.jobTitle = jobTitle;
        this.periodOfEmployment = periodOfEmployment;
        this.jobInfo = jobInfo;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPeriodOfEmployment() {
        return periodOfEmployment;
    }

    public void setPeriodOfEmployment(String periodOfEmployment) {
        this.periodOfEmployment = periodOfEmployment;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }
}
