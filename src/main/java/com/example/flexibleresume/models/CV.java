package com.example.flexibleresume.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resumes")

public class CV {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private byte[] docFile;
    private String fileName;

    @Column(name = "about_me", length = 500)
    private String aboutMe;

    @ManyToOne
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkInfo> workInfos = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonalInfo> personalInfos = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudyInfo> studyInfos = new ArrayList<>();


}