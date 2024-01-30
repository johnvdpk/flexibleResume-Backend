package com.example.flexibleresume.dtos;


import com.example.flexibleresume.user.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty(message = "Graag een email invullen")
    @Email(message = "Graag een geldig email invullen")
    private String email;
    @NotEmpty(message = "Graag een password invullen")
    @Size(min = 4, message = "Password moet minimaal 8 karakters bevatten")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
