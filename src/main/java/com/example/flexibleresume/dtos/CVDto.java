package com.example.flexibleresume.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CVDto {

    private String fileName;
    private String url;
    private String contentType;
    private String aboutMe;
    private List workInfos;
    private List personalInfos;
    private List studyInfos;
}
