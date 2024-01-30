package com.example.flexibleresume.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CVDtoTest {

    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new CVDto()).canEqual("Other"));
    }


    @Test
    void testCanEqual2() {
        // Arrange
        CVDto cvDto = new CVDto();

        // Act and Assert
        assertTrue(cvDto.canEqual(new CVDto()));
    }

    @Test
    void testConstructor() {
        // Arrange and Act
        CVDto actualCvDto = new CVDto();
        actualCvDto.setAboutMe("About Me");
        actualCvDto.setContentType("text/plain");
        actualCvDto.setFileName("foo.txt");
        ArrayList<PersonalInfoDto> personalInfos = new ArrayList<>();
        actualCvDto.setPersonalInfos(personalInfos);
        ArrayList<StudyInfoDto> studyInfos = new ArrayList<>();
        actualCvDto.setStudyInfos(studyInfos);
        actualCvDto.setUrl("https://example.org/example");
        ArrayList<WorkInfoDto> workInfos = new ArrayList<>();
        actualCvDto.setWorkInfos(workInfos);
        String actualToStringResult = actualCvDto.toString();
        String actualAboutMe = actualCvDto.getAboutMe();
        String actualContentType = actualCvDto.getContentType();
        String actualFileName = actualCvDto.getFileName();
        List<PersonalInfoDto> actualPersonalInfos = actualCvDto.getPersonalInfos();
        List<StudyInfoDto> actualStudyInfos = actualCvDto.getStudyInfos();
        String actualUrl = actualCvDto.getUrl();
        List<WorkInfoDto> actualWorkInfos = actualCvDto.getWorkInfos();

        // Assert that nothing has changed
        assertEquals("About Me", actualAboutMe);
        assertEquals("CVDto(fileName=foo.txt, url=https://example.org/example, contentType=text/plain, aboutMe=About Me,"
                + " workInfos=[], personalInfos=[], studyInfos=[])", actualToStringResult);
        assertEquals("foo.txt", actualFileName);
        assertEquals("https://example.org/example", actualUrl);
        assertEquals("text/plain", actualContentType);
        assertEquals(actualPersonalInfos, actualStudyInfos);
        assertEquals(actualPersonalInfos, actualWorkInfos);
        assertSame(personalInfos, actualPersonalInfos);
        assertSame(studyInfos, actualStudyInfos);
        assertSame(workInfos, actualWorkInfos);
    }

    @Test
    void testConstructor2() {
        // Arrange
        ArrayList<WorkInfoDto> workInfos = new ArrayList<>();
        ArrayList<PersonalInfoDto> personalInfos = new ArrayList<>();

        // Act
        CVDto actualCvDto = new CVDto("foo.txt", "https://example.org/example", "text/plain", "About Me", workInfos,
                personalInfos, new ArrayList<>());
        actualCvDto.setAboutMe("About Me");
        actualCvDto.setContentType("text/plain");
        actualCvDto.setFileName("foo.txt");
        ArrayList<PersonalInfoDto> personalInfos2 = new ArrayList<>();
        actualCvDto.setPersonalInfos(personalInfos2);
        ArrayList<StudyInfoDto> studyInfos = new ArrayList<>();
        actualCvDto.setStudyInfos(studyInfos);
        actualCvDto.setUrl("https://example.org/example");
        ArrayList<WorkInfoDto> workInfos2 = new ArrayList<>();
        actualCvDto.setWorkInfos(workInfos2);
        String actualToStringResult = actualCvDto.toString();
        String actualAboutMe = actualCvDto.getAboutMe();
        String actualContentType = actualCvDto.getContentType();
        String actualFileName = actualCvDto.getFileName();
        List<PersonalInfoDto> actualPersonalInfos = actualCvDto.getPersonalInfos();
        List<StudyInfoDto> actualStudyInfos = actualCvDto.getStudyInfos();
        String actualUrl = actualCvDto.getUrl();
        List<WorkInfoDto> actualWorkInfos = actualCvDto.getWorkInfos();

        // Assert that nothing has changed
        assertEquals("About Me", actualAboutMe);
        assertEquals("CVDto(fileName=foo.txt, url=https://example.org/example, contentType=text/plain, aboutMe=About Me,"
                + " workInfos=[], personalInfos=[], studyInfos=[])", actualToStringResult);
        assertEquals("foo.txt", actualFileName);
        assertEquals("https://example.org/example", actualUrl);
        assertEquals("text/plain", actualContentType);
        assertEquals(workInfos, actualPersonalInfos);
        assertEquals(workInfos, actualStudyInfos);
        assertEquals(workInfos, actualWorkInfos);
        assertSame(personalInfos2, actualPersonalInfos);
        assertSame(studyInfos, actualStudyInfos);
        assertSame(workInfos2, actualWorkInfos);
    }


    @Test
    void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals(new CVDto(), null);
        assertNotEquals(new CVDto(), "Different type to CVDto");
    }


    @Test
    void testEquals2() {
        // Arrange
        CVDto cvDto = new CVDto();

        // Act and Assert
        assertEquals(cvDto, cvDto);
        int expectedHashCodeResult = cvDto.hashCode();
        assertEquals(expectedHashCodeResult, cvDto.hashCode());
    }


    @Test
    void testEquals3() {
        // Arrange
        CVDto cvDto = new CVDto();
        CVDto cvDto2 = new CVDto();

        // Act and Assert
        assertEquals(cvDto, cvDto2);
        int expectedHashCodeResult = cvDto.hashCode();
        assertEquals(expectedHashCodeResult, cvDto2.hashCode());
    }


    @Test
    void testEquals4() {
        // Arrange
        ArrayList<WorkInfoDto> workInfos = new ArrayList<>();
        ArrayList<PersonalInfoDto> personalInfos = new ArrayList<>();
        CVDto cvDto = new CVDto("foo.txt", "https://example.org/example", "text/plain", "About Me", workInfos,
                personalInfos, new ArrayList<>());

        // Act and Assert
        assertNotEquals(cvDto, new CVDto());
    }


    @Test
    void testEquals5() {
        // Arrange
        CVDto cvDto = new CVDto();
        ArrayList<WorkInfoDto> workInfos = new ArrayList<>();
        ArrayList<PersonalInfoDto> personalInfos = new ArrayList<>();

        // Act and Assert
        assertNotEquals(cvDto, new CVDto("foo.txt", "https://example.org/example", "text/plain", "About Me", workInfos,
                personalInfos, new ArrayList<>()));
    }


    @Test
    void testEquals6() {
        // Arrange
        CVDto cvDto = new CVDto();
        cvDto.setUrl("https://example.org/example");

        // Act and Assert
        assertNotEquals(cvDto, new CVDto());
    }


    @Test
    void testEquals7() {
        // Arrange
        CVDto cvDto = new CVDto();
        cvDto.setContentType("text/plain");

        // Act and Assert
        assertNotEquals(cvDto, new CVDto());
    }


    @Test
    void testEquals8() {
        // Arrange
        CVDto cvDto = new CVDto();
        cvDto.setAboutMe("About Me");

        // Act and Assert
        assertNotEquals(cvDto, new CVDto());
    }


    @Test
    void testEquals9() {
        // Arrange
        CVDto cvDto = new CVDto();
        cvDto.setWorkInfos(new ArrayList<>());

        // Act and Assert
        assertNotEquals(cvDto, new CVDto());
    }


    @Test
    void testEquals10() {
        // Arrange
        CVDto cvDto = new CVDto();
        cvDto.setPersonalInfos(new ArrayList<>());

        // Act and Assert
        assertNotEquals(cvDto, new CVDto());
    }


    @Test
    void testEquals11() {
        // Arrange
        CVDto cvDto = new CVDto();
        cvDto.setStudyInfos(new ArrayList<>());

        // Act and Assert
        assertNotEquals(cvDto, new CVDto());
    }


    @Test
    void testEquals12() {
        // Arrange
        ArrayList<WorkInfoDto> workInfos = new ArrayList<>();
        ArrayList<PersonalInfoDto> personalInfos = new ArrayList<>();
        CVDto cvDto = new CVDto("foo.txt", "https://example.org/example", "text/plain", "About Me", workInfos,
                personalInfos, new ArrayList<>());
        ArrayList<WorkInfoDto> workInfos2 = new ArrayList<>();
        ArrayList<PersonalInfoDto> personalInfos2 = new ArrayList<>();
        CVDto cvDto2 = new CVDto("foo.txt", "https://example.org/example", "text/plain", "About Me", workInfos2,
                personalInfos2, new ArrayList<>());

        // Act and Assert
        assertEquals(cvDto, cvDto2);
        int expectedHashCodeResult = cvDto.hashCode();
        assertEquals(expectedHashCodeResult, cvDto2.hashCode());
    }


    @Test
    void testEquals13() {
        // Arrange
        CVDto cvDto = new CVDto();

        CVDto cvDto2 = new CVDto();
        cvDto2.setUrl("https://example.org/example");

        // Act and Assert
        assertNotEquals(cvDto, cvDto2);
    }


    @Test
    void testEquals14() {
        // Arrange
        CVDto cvDto = new CVDto();

        CVDto cvDto2 = new CVDto();
        cvDto2.setContentType("text/plain");

        // Act and Assert
        assertNotEquals(cvDto, cvDto2);
    }


    @Test
    void testEquals15() {
        // Arrange
        CVDto cvDto = new CVDto();

        CVDto cvDto2 = new CVDto();
        cvDto2.setAboutMe("About Me");

        // Act and Assert
        assertNotEquals(cvDto, cvDto2);
    }


    @Test
    void testEquals16() {
        // Arrange
        CVDto cvDto = new CVDto();

        CVDto cvDto2 = new CVDto();
        cvDto2.setWorkInfos(new ArrayList<>());

        // Act and Assert
        assertNotEquals(cvDto, cvDto2);
    }


    @Test
    void testEquals17() {
        // Arrange
        CVDto cvDto = new CVDto();

        CVDto cvDto2 = new CVDto();
        cvDto2.setPersonalInfos(new ArrayList<>());

        // Act and Assert
        assertNotEquals(cvDto, cvDto2);
    }


    @Test
    void testEquals18() {
        // Arrange
        CVDto cvDto = new CVDto();

        CVDto cvDto2 = new CVDto();
        cvDto2.setStudyInfos(new ArrayList<>());

        // Act and Assert
        assertNotEquals(cvDto, cvDto2);
    }
}
