package com.example.flexibleresume.models;

import com.example.flexibleresume.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

    // @Collum geef ik altijd aan, dit is overzichtelijker.
    // Telefoonnummer, huisnummer en postcode zijn allemaal strings. Het kan zijn dat er andere tekens dan cijfers in voor komen en er worden geen berekeningen mee gemaakt.

    //Een 'jobseeker' werkzoekende kan meedere CV's hebben. Dit wordt eigenlijk in de frontend gedaan. maar voor de zekerheid is er een onetomany koppeling gemaakt.
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CV> cvs = new ArrayList<>();

    // One-to-One relatie met User entity
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
    @Column(name = "home_towns", length = 30)
    private String homeTown;
    @Column(name = "zipcodes", length = 6)
    private String zipCode;
    @Column(name = "home_addresses", length = 100)
    private String homeAddress;
    @Column(name = "house_numbers", length = 5)
    private String houseNumber;



}