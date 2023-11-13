package com.example.flexibleresume.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @Column(name = "about_me", length = 500)
    private String aboutMe;


    // CV is gekoppeld aan de Jobseeker. De JobSeeker mag meerdere CV's hebben.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    // WorkInfo, PersonalInfo en StudyInfo is gekoppeld aan CV. Meedere van deze klasse kunnen in een cv zitten.

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkInfo> workInfos = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonalInfo> personalInfos = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudyInfo> studyInfos = new ArrayList<>();


}