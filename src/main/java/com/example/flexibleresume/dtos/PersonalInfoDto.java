package com.example.flexibleresume.dtos;

import com.example.flexibleresume.models.CV;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoDto {



    private long id;
    private String hobby;
    private String periodOfHobby;
    private String hobbyInfo;
}
