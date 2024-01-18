package com.example.flexibleresume.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerJobInfoInputDto {


    @NotBlank(message = "Graag een functieomschrijving invullen")
    private String jobDescription;
    @NotBlank(message = "Graag functie-eisen invullen")
    private String jobRequirements;
    @NotBlank(message = "Graag een vaardigheid invullen")
    private String skill;
    @NotBlank(message = "Graag een opleiding invullen")
    private String education;
    @NotBlank(message = "Graag aantal jaren van ervaring opgeven")
    private String yearsOfExperience;
    @NotBlank(message = "Graag een functie aanbod invullen")
    private String jobOffer;
    @NotBlank(message = "Graag een salaris indicatie invullen")
    private String salaryIndication;
    private String extras;
}
