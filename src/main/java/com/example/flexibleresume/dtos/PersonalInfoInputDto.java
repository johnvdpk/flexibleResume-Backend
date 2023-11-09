package com.example.flexibleresume.dtos;

import com.example.flexibleresume.models.CV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoInputDto {

    private CV cv;
    private long id;
    private String hobby;
    private String periodOfHobby;
    private String hobbyInfo;
}