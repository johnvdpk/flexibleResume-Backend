package com.example.flexibleresume.models;


import jakarta.persistence.*;

@Entity
@Table(name="personal_info")
public class PersonalInfo {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cv_id")
    private CV cv;

    @Id
    @GeneratedValue
    private long id;

    @Column(name="hobbys")
    private String hobby;

    @Column(name="period_of_hobby")
    private String periodOfHobby;
    @Column(name="hobby_info")
    private String hobbyInfo;


    public PersonalInfo(CV cv, long id, String hobby, String periodOfHobby, String hobbyInfo) {
        this.cv = cv;
        this.id = id;
        this.hobby = hobby;
        this.periodOfHobby = periodOfHobby;
        this.hobbyInfo = hobbyInfo;
    }

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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPeriodOfHobby() {
        return periodOfHobby;
    }

    public void setPeriodOfHobby(String periodOfHobby) {
        this.periodOfHobby = periodOfHobby;
    }

    public String getHobbyInfo() {
        return hobbyInfo;
    }

    public void setHobbyInfo(String hobbyInfo) {
        this.hobbyInfo = hobbyInfo;
    }
}

