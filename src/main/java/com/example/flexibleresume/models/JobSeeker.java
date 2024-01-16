package com.example.flexibleresume.models;

import com.example.flexibleresume.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jobseekers")
public class JobSeeker {

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CV> cvs = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "jobSeeker")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", length = 20)
    private String firstName;
    @Column(name = "sur_name", length = 50)
    private String surName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "phone_numbers", length = 20)
    private String phoneNumber;
    @Column(name = "residences", length = 30)
    private String residence;
    @Column(name = "zipcodes", length = 6)
    private String zipCode;
    @Column(name = "home_addresses", length = 100)
    private String homeAddress;
    @Column(name = "house_numbers", length = 5)
    private String houseNumber;



}