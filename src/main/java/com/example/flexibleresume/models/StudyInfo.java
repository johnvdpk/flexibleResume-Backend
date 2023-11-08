package com.example.flexibleresume.models;


import jakarta.persistence.*;

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


    public StudyInfo(CV cv, long id, String educationalInstitute, String education, String periodOfStudy, String studyInfo) {
        this.cv = cv;
        this.id = id;
        this.educationalInstitute = educationalInstitute;
        this.education = education;
        this.periodOfStudy = periodOfStudy;
        this.studyInfo = studyInfo;
    }

    public StudyInfo(){}

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEducationalInstitute() {
        return educationalInstitute;
    }

    public void setEducationalInstitute(String educationalInstitute) {
        this.educationalInstitute = educationalInstitute;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPeriodOfStudy() {
        return periodOfStudy;
    }

    public void setPeriodOfStudy(String periodOfStudy) {
        this.periodOfStudy = periodOfStudy;
    }

    public String getStudyInfo() {
        return studyInfo;
    }

    public void setStudyInfo(String studyInfo) {
        this.studyInfo = studyInfo;
    }
}
