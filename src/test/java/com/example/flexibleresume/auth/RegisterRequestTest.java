package com.example.flexibleresume.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RegisterRequestTest {

    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", "Role")).canEqual("Other"));
    }


    @Test
    void testCanEqual2() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertTrue(buildResult.canEqual(buildResult2));
    }


    @Test
    void testConstructor() {
        // Arrange and Act
        RegisterRequest actualRegisterRequest = new RegisterRequest();
        actualRegisterRequest.setEmail("jane.doe@example.org");
        actualRegisterRequest.setFirstname("Jane");
        actualRegisterRequest.setLastname("Doe");
        actualRegisterRequest.setPassword("iloveyou");
        actualRegisterRequest.setRole("Role");
        String actualToStringResult = actualRegisterRequest.toString();
        String actualEmail = actualRegisterRequest.getEmail();
        String actualFirstname = actualRegisterRequest.getFirstname();
        String actualLastname = actualRegisterRequest.getLastname();
        String actualPassword = actualRegisterRequest.getPassword();

        // Assert that nothing has changed
        assertEquals("Doe", actualLastname);
        assertEquals("Jane", actualFirstname);
        assertEquals(
                "RegisterRequest(firstname=Jane, lastname=Doe, email=jane.doe@example.org, password=iloveyou," + " role=Role)",
                actualToStringResult);
        assertEquals("Role", actualRegisterRequest.getRole());
        assertEquals("iloveyou", actualPassword);
        assertEquals("jane.doe@example.org", actualEmail);
    }


    @Test
    void testConstructor2() {
        // Arrange and Act
        RegisterRequest actualRegisterRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou",
                "Role");
        actualRegisterRequest.setEmail("jane.doe@example.org");
        actualRegisterRequest.setFirstname("Jane");
        actualRegisterRequest.setLastname("Doe");
        actualRegisterRequest.setPassword("iloveyou");
        actualRegisterRequest.setRole("Role");
        String actualToStringResult = actualRegisterRequest.toString();
        String actualEmail = actualRegisterRequest.getEmail();
        String actualFirstname = actualRegisterRequest.getFirstname();
        String actualLastname = actualRegisterRequest.getLastname();
        String actualPassword = actualRegisterRequest.getPassword();

        // Assert that nothing has changed
        assertEquals("Doe", actualLastname);
        assertEquals("Jane", actualFirstname);
        assertEquals(
                "RegisterRequest(firstname=Jane, lastname=Doe, email=jane.doe@example.org, password=iloveyou," + " role=Role)",
                actualToStringResult);
        assertEquals("Role", actualRegisterRequest.getRole());
        assertEquals("iloveyou", actualPassword);
        assertEquals("jane.doe@example.org", actualEmail);
    }


    @Test
    void testEquals() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, null);
    }

    @Test
    void testEquals2() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, "Different type to RegisterRequest");
    }

    @Test
    void testEquals3() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertEquals(buildResult, buildResult);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, buildResult.hashCode());
    }


    @Test
    void testEquals4() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertEquals(buildResult, buildResult2);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, buildResult2.hashCode());
    }

    @Test
    void testEquals5() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("john.smith@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    @Test
    void testEquals6() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email(null)
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }


    @Test
    void testEquals7() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("John")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }


    @Test
    void testEquals8() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname(null)
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }


    @Test
    void testEquals9() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Smith")
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }


    @Test
    void testEquals10() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname(null)
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }


    @Test
    void testEquals11() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("Jane")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }


    @Test
    void testEquals12() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password(null)
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }


    @Test
    void testEquals13() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Jane")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals14() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role(null)
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }


    @Test
    void testEquals15() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email(null)
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email(null)
                .firstname("Jane")
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertEquals(buildResult, buildResult2);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, buildResult2.hashCode());
    }


    @Test
    void testEquals16() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname(null)
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname(null)
                .lastname("Doe")
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertEquals(buildResult, buildResult2);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, buildResult2.hashCode());
    }


    @Test
    void testEquals17() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname(null)
                .password("iloveyou")
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname(null)
                .password("iloveyou")
                .role("Role")
                .build();

        // Act and Assert
        assertEquals(buildResult, buildResult2);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, buildResult2.hashCode());
    }


    @Test
    void testEquals18() {
        // Arrange
        RegisterRequest buildResult = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password(null)
                .role("Role")
                .build();
        RegisterRequest buildResult2 = RegisterRequest.builder()
                .email("jane.doe@example.org")
                .firstname("Jane")
                .lastname("Doe")
                .password(null)
                .role("Role")
                .build();

        // Act and Assert
        assertEquals(buildResult, buildResult2);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, buildResult2.hashCode());
    }
}
