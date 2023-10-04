package com.example.flexibleresume.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="jobseekers")
public class JobSeeker {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="sur_name")
    private String surName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;


}
