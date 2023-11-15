package com.example.flexibleresume.models;

import com.example.flexibleresume.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class JobSeekerTest {

    private JobSeeker jobSeeker;

    @BeforeEach
    void setup() {
        // Hier initialiseren we een JobSeeker object met wat testdata
        jobSeeker = new JobSeeker();
        jobSeeker.setId(1L);
        jobSeeker.setFirstName("John");
        jobSeeker.setSurName("Doe");
        jobSeeker.setDateOfBirth(LocalDate.of(1990, 1, 1));
        jobSeeker.setEmail("john.doe@example.com");
        jobSeeker.setPhoneNumber("1234567890");
        jobSeeker.setResidence("Springfield");
        jobSeeker.setZipCode("12345");
        jobSeeker.setHomeAddress("123 Main St");
        jobSeeker.setHouseNumber("101");
        jobSeeker.setCvs(Collections.emptyList()); // Stel in als lege lijst voor nu


    }



    @AfterEach
    void tearDown() {
        // Hier ruimen we de resources op, indien nodig
        jobSeeker = null;
    }

    @Test
    void getFirstName() {
        //arrange
        // De setup heeft al plaatsgevonden in @BeforeEach

        //act
        String firstName = jobSeeker.getFirstName();

        //assert
        assertEquals("John", firstName, "De firstName moet overeenkomen met de ingestelde waarde");
    }

    // Hier kun je meer tests toevoegen voor andere getters en setters

}
