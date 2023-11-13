package com.example.flexibleresume.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="personal_info")
public class PersonalInfo {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cv_id")
    private CV cv;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="hobbys")
    private String hobby;

    @Column(name="period_of_hobby")
    private String periodOfHobby;
    @Column(name="hobby_info")
    private String hobbyInfo;



}

