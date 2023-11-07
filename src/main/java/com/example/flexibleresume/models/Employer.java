package com.example.flexibleresume.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employers")
public class Employer {

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployerJobInfo> jobInfos = new ArrayList<>();


    @Id
    @GeneratedValue
    private Long id;

    @Column(name="companys")
    private String company;

    @Column(name="industries")
    private String industry;

    @Column(name="office_addresses")
    private String officeAdress;

    @Column(name="office_adress_numbers")
    private String getOfficeAdressNumber;

    @Column(name="office_zipcode")
    private String officeZipcode;

    @Column(name="office_city_locations")
    private String officeCityLocation;

    @Column(name="kvk_number")
    private String kvk;

    @Column(name= "missions", length = 600)
    private String mission;
    @Column(name = "visions", length = 600)
    private String vision;
    @Column(name = "number_of_employees")
    private String numberOfEmployees;


    public Employer(List<EmployerJobInfo> jobInfos, Long id, String company, String industry, String officeAdress, String getOfficeAdressNumber, String officeZipcode, String officeCityLocation, String kvk, String mission, String vision, String numberOfEmployees) {
        this.jobInfos = jobInfos;
        this.id = id;
        this.company = company;
        this.industry = industry;
        this.officeAdress = officeAdress;
        this.getOfficeAdressNumber = getOfficeAdressNumber;
        this.officeZipcode = officeZipcode;
        this.officeCityLocation = officeCityLocation;
        this.kvk = kvk;
        this.mission = mission;
        this.vision = vision;
        this.numberOfEmployees = numberOfEmployees;
    }

    public List<EmployerJobInfo> getJobInfos() {
        return jobInfos;
    }

    public void setJobInfos(List<EmployerJobInfo> jobInfos) {
        this.jobInfos = jobInfos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getOfficeAdress() {
        return officeAdress;
    }

    public void setOfficeAdress(String officeAdress) {
        this.officeAdress = officeAdress;
    }

    public String getGetOfficeAdressNumber() {
        return getOfficeAdressNumber;
    }

    public void setGetOfficeAdressNumber(String getOfficeAdressNumber) {
        this.getOfficeAdressNumber = getOfficeAdressNumber;
    }

    public String getOfficeZipcode() {
        return officeZipcode;
    }

    public void setOfficeZipcode(String officeZipcode) {
        this.officeZipcode = officeZipcode;
    }

    public String getOfficeCityLocation() {
        return officeCityLocation;
    }

    public void setOfficeCityLocation(String officeCityLocation) {
        this.officeCityLocation = officeCityLocation;
    }

    public String getKvk() {
        return kvk;
    }

    public void setKvk(String kvk) {
        this.kvk = kvk;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
