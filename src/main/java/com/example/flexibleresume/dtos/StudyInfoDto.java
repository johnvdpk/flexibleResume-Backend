package com.example.flexibleresume.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyInfoDto {

    private Long cvId;
    private Long id;
    private String educationalInstitute;
    private String education;
    private String periodOfStudy;
    private String studyInfo;

}
