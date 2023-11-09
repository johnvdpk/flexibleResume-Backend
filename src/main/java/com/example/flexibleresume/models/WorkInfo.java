package com.example.flexibleresume.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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



}
