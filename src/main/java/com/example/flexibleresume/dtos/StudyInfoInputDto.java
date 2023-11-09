package com.example.flexibleresume.dtos;

import com.example.flexibleresume.models.CV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyInfoInputDto {

    private CV cv;
    private long id;
    private String educationalInstitute;
    private String education;
    private String periodOfStudy;
    private String studyInfo;

}