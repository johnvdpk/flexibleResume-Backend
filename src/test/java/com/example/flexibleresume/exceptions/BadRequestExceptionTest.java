package com.example.flexibleresume.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BadRequestExceptionTest {

    @Test
    void testConstructor() {
        // Arrange and Act
        BadRequestException actualBadRequestException = new BadRequestException();

        // Assert
        assertNull(actualBadRequestException.getLocalizedMessage());
        assertNull(actualBadRequestException.getMessage());
        assertNull(actualBadRequestException.getCause());
        assertEquals(0, actualBadRequestException.getSuppressed().length);
    }


    @Test
    void testConstructor2() {
        // Arrange and Act
        BadRequestException actualBadRequestException = new BadRequestException("An error occurred");

        // Assert
        assertEquals("An error occurred", actualBadRequestException.getLocalizedMessage());
        assertEquals("An error occurred", actualBadRequestException.getMessage());
        assertNull(actualBadRequestException.getCause());
        assertEquals(0, actualBadRequestException.getSuppressed().length);
    }
}
