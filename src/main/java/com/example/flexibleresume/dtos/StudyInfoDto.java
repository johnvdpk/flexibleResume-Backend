package com.example.flexibleresume.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyInfoDto {

    private Long cvId;
    private Long id;
    @NotBlank(message = "Graag een onderwijsinstelling invullen")
    private String educationalInstitute;
    @NotBlank(message = "Graag een opleiding invullen")
    private String education;
    @NotBlank(message = "Graag een periode van studie invullen")
    private String periodOfStudy;
    @NotBlank(message = "Graag informatie over de studie invullen")
    private String studyInfo;

}
