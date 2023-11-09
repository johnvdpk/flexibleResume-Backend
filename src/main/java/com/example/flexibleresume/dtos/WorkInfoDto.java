package com.example.flexibleresume.dtos;

import com.example.flexibleresume.models.CV;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkInfoDto {


    private CV cv;
    private Long id;
    private String company;
    private String jobTitle;
    private String periodOfEmployment;
    private String jobInfo;

}
