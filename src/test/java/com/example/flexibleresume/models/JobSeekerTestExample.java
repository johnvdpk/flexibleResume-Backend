//package com.example.flexibleresume.models;
//
//import com.example.flexibleresume.user.User;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class JobSeekerTestExample {
//
//    private JobSeeker jobSeeker;
//
//    @BeforeEach
//    void setup() {
//        // Hier initialiseren we een JobSeeker object met wat testdata
//        jobSeeker = new JobSeeker();
//        jobSeeker.setId(1L);
//        jobSeeker.setFirstName("John");
//        jobSeeker.setSurName("Doe");
//        jobSeeker.setDateOfBirth(LocalDate.of(1990, 1, 1));
//        jobSeeker.setEmail("john.doe@example.com");
//        jobSeeker.setPhoneNumber("1234567890");
//        jobSeeker.setResidence("Springfield");
//        jobSeeker.setZipCode("12345");
//        jobSeeker.setHomeAddress("123 Main St");
//        jobSeeker.setHouseNumber("101");
//        jobSeeker.setCvs(Collections.emptyList()); // Stel in als lege lijst voor nu
//
//
//    }
//
//
//
//    @AfterEach
//    void tearDown() {
//
//        jobSeeker = null;
//    }
//
//    @Test
//    void getFirstName() {
//        //arrange
//        // De setup heeft al plaatsgevonden in @BeforeEach
//
//        //act
//        String firstName = jobSeeker.getFirstName();
//
//        //assert
//        assertEquals("John", firstName, "De firstName moet overeenkomen met de ingestelde waarde");
//    }
//
//    @Test
//    void getAndSetSurName() {
//        // Act
//        String expectedSurName = "Doe";
//        jobSeeker.setSurName(expectedSurName);
//        String actualSurName = jobSeeker.getSurName();
//
//        // Assert
//        assertEquals(expectedSurName, actualSurName, "De surName moet overeenkomen met de ingestelde waarde");
//    }
//
//    @Test
//    void getAndSetDateOfBirth() {
//        // Act
//        LocalDate expectedDateOfBirth = LocalDate.of(1990, 1, 1);
//        jobSeeker.setDateOfBirth(expectedDateOfBirth);
//        LocalDate actualDateOfBirth = jobSeeker.getDateOfBirth();
//
//        // Assert
//        assertEquals(expectedDateOfBirth, actualDateOfBirth, "De dateOfBirth moet overeenkomen met de ingestelde waarde");
//    }
//
//    @Test
//    void getAndSetEmail() {
//        // Act
//        String expectedEmail = "john.doe@example.com";
//        jobSeeker.setEmail(expectedEmail);
//        String actualEmail = jobSeeker.getEmail();
//
//        // Assert
//        assertEquals(expectedEmail, actualEmail, "De email moet overeenkomen met de ingestelde waarde");
//    }
//
//    @Test
//    void getAndSetPhoneNumber() {
//        // Act
//        String expectedPhoneNumber = "1234567890";
//        jobSeeker.setPhoneNumber(expectedPhoneNumber);
//        String actualPhoneNumber = jobSeeker.getPhoneNumber();
//
//        // Assert
//        assertEquals(expectedPhoneNumber, actualPhoneNumber, "De phoneNumber moet overeenkomen met de ingestelde waarde");
//    }
//
//    @Test
//    void getAndSetResidence() {
//        // Act
//        String expectedResidence = "Springfield";
//        jobSeeker.setResidence(expectedResidence);
//        String actualResidence = jobSeeker.getResidence();
//
//        // Assert
//        assertEquals(expectedResidence, actualResidence, "De residence moet overeenkomen met de ingestelde waarde");
//    }
//
//    @Test
//    void getAndSetZipCode() {
//        // Act
//        String expectedZipCode = "12345";
//        jobSeeker.setZipCode(expectedZipCode);
//        String actualZipCode = jobSeeker.getZipCode();
//
//        // Assert
//        assertEquals(expectedZipCode, actualZipCode, "De zipCode moet overeenkomen met de ingestelde waarde");
//    }
//
//    @Test
//    void getAndSetHomeAddress() {
//        // Act
//        String expectedHomeAddress = "123 Main St";
//        jobSeeker.setHomeAddress(expectedHomeAddress);
//        String actualHomeAddress = jobSeeker.getHomeAddress();
//
//        // Assert
//        assertEquals(expectedHomeAddress, actualHomeAddress, "De homeAddress moet overeenkomen met de ingestelde waarde");
//    }
//
//    @Test
//    void getAndSetHouseNumber() {
//        // Act
//        String expectedHouseNumber = "101";
//        jobSeeker.setHouseNumber(expectedHouseNumber);
//        String actualHouseNumber = jobSeeker.getHouseNumber();
//
//        // Assert
//        assertEquals(expectedHouseNumber, actualHouseNumber, "De houseNumber moet overeenkomen met de ingestelde waarde");
//    }
//
//    // Test voor de lijst van CV's
//    @Test
//    void getAndSetCvs() {
//        // Arrange
//        List<CV> expectedCvs = new ArrayList<>();
//        CV cv = new CV(); // Stel hier de vereiste velden in
//        expectedCvs.add(cv);
//
//        // Act
//        jobSeeker.setCvs(expectedCvs);
//        List<CV> actualCvs = jobSeeker.getCvs();
//
//        // Assert
//        assertEquals(expectedCvs, actualCvs, "De lijst van CV's moet overeenkomen met de ingestelde lijst");
//    }
//
//    // Test voor de User veld
//    @Test
//    void getAndSetUser() {
//        // Arrange
//        User expectedUser = new User();
//        // Stel hier de vereiste velden in voor User
//
//        // Act
//        jobSeeker.setUser(expectedUser);
//        User actualUser = jobSeeker.getUser();
//
//        // Assert
//        assertEquals(expectedUser, actualUser, "De gekoppelde User moet overeenkomen met de ingestelde User");
//    }
//
//
//}
