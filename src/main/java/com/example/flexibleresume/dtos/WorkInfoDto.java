package com.example.flexibleresume.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkInfoDto {


    private Long cvId;
    private Long id;
    private String company;
    private String jobTitle;
    private String periodOfEmployment;
    private String jobInfo;

}
