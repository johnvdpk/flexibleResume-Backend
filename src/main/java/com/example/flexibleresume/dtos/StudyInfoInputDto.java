package com.example.flexibleresume.dtos;

import com.example.flexibleresume.models.CV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyInfoInputDto {

    private Long cvId;
    private Long id;
    private String educationalInstitute;
    private String education;
    private String periodOfStudy;
    private String studyInfo;

}
