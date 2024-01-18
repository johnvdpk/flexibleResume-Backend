package com.example.flexibleresume.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoInputDto {

    private Long cvId;
    private Long id;
    @NotBlank(message = "Graag een hobby invullen")
    private String hobby;
    @NotBlank(message = "Graag een periode van hobby invullen")
    private String periodOfHobby;
    @NotBlank(message = "Graag informatie over de hobby invullen")
    private String hobbyInfo;
}
