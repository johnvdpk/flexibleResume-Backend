package com.example.flexibleresume.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="workinfo")
public class WorkInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="jobtitles")
    private String jobTitle;

    @Column(name="companys")
    private String company;

    @Column(name="period_of_employment")
    private String PeriodOfEmployment;

    @Column(name="job_information")
    private String jobInfo;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;



}
