package com.example.flexibleresume.dtos;


import com.example.flexibleresume.models.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CVInputDto {

    private String aboutMe;
    private List workInfos;
    private List personalInfos;
    private List studyInfos;
}
