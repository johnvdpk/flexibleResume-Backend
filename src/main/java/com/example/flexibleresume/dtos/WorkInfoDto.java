package com.example.flexibleresume.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkInfoDto {


    private Long cvId;
    private Long id;
    @NotBlank(message = "Graag een bedrijf invullen")
    private String company;
    @NotBlank(message = "Graag een functie invullen")
    private String jobTitle;
    @NotBlank(message = "Graag een periode van werk invullen")
    private String periodOfEmployment;
    @NotBlank(message = "Graag informatie over de functie invullen")
    private String jobInfo;

}
