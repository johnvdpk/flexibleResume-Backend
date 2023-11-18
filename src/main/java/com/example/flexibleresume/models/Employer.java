package com.example.flexibleresume.models;

import com.example.flexibleresume.user.User;
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
@Table(name="employers")
public class Employer {

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployerJobInfo> jobInfos = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employer")
    private User user;

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
    private String officeAdressNumber;

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



}
