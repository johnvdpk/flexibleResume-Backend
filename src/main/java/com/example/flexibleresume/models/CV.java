package com.example.flexibleresume.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="resumes")

public class CV {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="about_me",length = 500)
    private String aboutme;


    // CV is gekoppeld aan de Jobseeker. De JobSeeker mag meerdere CV's hebben.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    // WorkInfo, PersonalInfo en StudyInfo is gekoppeld aan CV. Meedere van deze klasse kunnen in een cv zitten.

    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkInfo> workInfos = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonalInfo> personalInfos = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<StudyInfo> studyInfos = new ArrayList<>();


    public CV(Long id, String aboutme, JobSeeker jobSeeker, List<WorkInfo> workInfos, List<PersonalInfo> personalInfos, List<StudyInfo> studyInfos) {
        this.id = id;
        this.aboutme = aboutme;
        this.jobSeeker = jobSeeker;
        this.workInfos = workInfos;
        this.personalInfos = personalInfos;
        this.studyInfos = studyInfos;
    }

    public CV() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public List<WorkInfo> getWorkInfos() {
        return workInfos;
    }

    public void setWorkInfos(List<WorkInfo> workInfos) {
        this.workInfos = workInfos;
    }

    public List<PersonalInfo> getPersonalInfos() {
        return personalInfos;
    }

    public void setPersonalInfos(List<PersonalInfo> personalInfos) {
        this.personalInfos = personalInfos;
    }

    public List<StudyInfo> getStudyInfos() {
        return studyInfos;
    }

    public void setStudyInfos(List<StudyInfo> studyInfos) {
        this.studyInfos = studyInfos;
    }
}
