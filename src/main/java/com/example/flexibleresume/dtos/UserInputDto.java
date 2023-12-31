package com.example.flexibleresume.dtos;

import com.example.flexibleresume.user.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;



}
