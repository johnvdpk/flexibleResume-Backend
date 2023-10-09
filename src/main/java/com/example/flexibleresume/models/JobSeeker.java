package com.example.flexibleresume.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="jobseekers")
public class JobSeeker {

    // @Collum geef ik altijd aan, dit is overzichtelijker.
    // Telefoonnummer, huisnummer en postcode zijn allemaal strings. Het kan zijn dat er andere tekens dan cijfers in voor komen en er worden geen berekeningen mee gemaakt.

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name", length = 20)
    private String firstName;
    @Column(name = "sur_name", length = 50)
    private String surName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "phonenumbers", length = 20)
    private String phoneNumber;
    @Column(name = "zipcodes", length = 6)
    private String zipCode;
    @Column(name = "home_addresses", length = 100)
    private String homeAddress;
    @Column(name = "house_numbers", length = 5)
    private String houseNumber;


    //  De contructor, gevuld en leeg.

    public JobSeeker(Long id, String firstName, String surName, LocalDate dateOfBirth, String email, String phoneNumber, String zipCode, String homeAddress, String houseNumber) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.homeAddress = homeAddress;
        this.houseNumber = houseNumber;
    }

    public JobSeeker() {

    }

    // Getters en Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}