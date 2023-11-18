package com.example.flexibleresume.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoDto {


    private Long cvId;
    private Long id;
    private String hobby;
    private String periodOfHobby;
    private String hobbyInfo;
}
