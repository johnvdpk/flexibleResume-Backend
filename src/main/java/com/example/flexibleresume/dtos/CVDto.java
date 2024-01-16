package com.example.flexibleresume.dtos;
import com.example.flexibleresume.models.PersonalInfo;
import com.example.flexibleresume.models.StudyInfo;
import com.example.flexibleresume.models.WorkInfo;
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
    private List<WorkInfo> workInfos;
    private List<PersonalInfo> personalInfos;
    private List<StudyInfo> studyInfos;
}
