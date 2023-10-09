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

    @OneToOne (mappedBy = "cv")
    @JsonIgnore
    private JobSeeker jobSeeker;

    //CascadeType.ALL zorgt ervoor dat alle bijhorende workInfo ook verwijderd word.
    //orphanRemoval zorgt ervoor dat een verwijderde WorkInfo ook uit de CV wordt gehaald
    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkInfo> workInfos = new ArrayList<>();





}
