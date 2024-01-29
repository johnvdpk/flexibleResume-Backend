package com.example.flexibleresume.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.flexibleresume.dtos.UserInputDto;
import com.example.flexibleresume.user.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private SqlDataSourceScriptDatabaseInitializer sqlDataSourceScriptDatabaseInitializer;

    @Autowired
    private UserService userService;

    @Test
    void testCreateUser() {
        // Arrange
        UserInputDto userInputDto = UserInputDto.builder()
                .email("jane.doe@example.org")
                .id(1L)
                .password("iloveyou")
                .role(Role.USER)
                .build();

        // Act and Assert
        assertEquals("jane.doe@example.org", userService.createUser(userInputDto).getEmail());
    }
}
