package com.example.flexibleresume.dtos;

import com.example.flexibleresume.user.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInputDto {

    private Long id;
    @NotEmpty(message = "Graag een email invullen")
    private String email;
    @NotEmpty(message = "Graag een password invullen")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;



}
