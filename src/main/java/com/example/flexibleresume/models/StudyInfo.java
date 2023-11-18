package com.example.flexibleresume.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="study_info")
public class StudyInfo {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cv_id")
    private CV cv;

    @Id
    @GeneratedValue
    private long id;

    @Column(name="education_institue")
    private String educationalInstitute;

    @Column(name="education")
    private String education;

    @Column(name="period_of_study")
    private String periodOfStudy;

    @Column(name="study_info", length = 500)
    private String studyInfo;



}
