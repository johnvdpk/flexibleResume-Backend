package com.example.flexibleresume.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.flexibleresume.user.Role;
import com.example.flexibleresume.user.User;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StudyInfoTest {

    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new StudyInfo()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() throws UnsupportedEncodingException {
        // Arrange
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEmployer(new Employer());
        user.setId(1L);
        user.setJobSeeker(new JobSeeker());
        user.setPassword("iloveyou");
        user.setRole(Role.USER);

        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setCvs(new ArrayList<>());
        jobSeeker.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker.setEmail("jane.doe@example.org");
        jobSeeker.setFirstName("Jane");
        jobSeeker.setHomeAddress("42 Main St");
        jobSeeker.setHouseNumber("42");
        jobSeeker.setId(1L);
        jobSeeker.setPhoneNumber("6625550144");
        jobSeeker.setResidence("Residence");
        jobSeeker.setSurName("Doe");
        jobSeeker.setUser(user);
        jobSeeker.setZipCode("21654");

        CV cv = new CV();
        cv.setAboutMe("About Me");
        cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        StudyInfo studyInfo = new StudyInfo();
        studyInfo.setCv(cv);
        studyInfo.setEducation("Education");
        studyInfo.setEducationalInstitute("Educational Institute");
        studyInfo.setId(1L);
        studyInfo.setPeriodOfStudy("Period Of Study");
        studyInfo.setStudyInfo("Study Info");

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(new Employer());
        user2.setId(1L);
        user2.setJobSeeker(new JobSeeker());
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("jane.doe@example.org");
        jobSeeker2.setFirstName("Jane");
        jobSeeker2.setHomeAddress("42 Main St");
        jobSeeker2.setHouseNumber("42");
        jobSeeker2.setId(1L);
        jobSeeker2.setPhoneNumber("6625550144");
        jobSeeker2.setResidence("Residence");
        jobSeeker2.setSurName("Doe");
        jobSeeker2.setUser(user2);
        jobSeeker2.setZipCode("21654");

        CV cv2 = new CV();
        cv2.setAboutMe("About Me");
        cv2.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv2.setFileName("foo.txt");
        cv2.setId(1L);
        cv2.setJobSeeker(jobSeeker2);
        cv2.setPersonalInfos(new ArrayList<>());
        cv2.setStudyInfos(new ArrayList<>());
        cv2.setWorkInfos(new ArrayList<>());

        StudyInfo studyInfo2 = new StudyInfo();
        studyInfo2.setCv(cv2);
        studyInfo2.setEducation("Education");
        studyInfo2.setEducationalInstitute("Educational Institute");
        studyInfo2.setId(1L);
        studyInfo2.setPeriodOfStudy("Period Of Study");
        studyInfo2.setStudyInfo("Study Info");

        // Act and Assert
        assertTrue(studyInfo.canEqual(studyInfo2));
    }

    @Test
    void testConstructor() throws UnsupportedEncodingException {
        // Arrange and Act
        StudyInfo actualStudyInfo = new StudyInfo();
        Employer employer = new Employer();
        employer.setCompany("Company");
        employer.setId(1L);
        employer.setIndustry("Industry");
        employer.setJobInfos(new ArrayList<>());
        employer.setKvk("Kvk");
        employer.setMission("Mission");
        employer.setNumberOfEmployees("42");
        employer.setOfficeAdress("Office Adress");
        employer.setOfficeAdressNumber("42");
        employer.setOfficeCityLocation("Office City Location");
        employer.setOfficeZipcode("Office Zipcode");
        employer.setUser(new User());
        employer.setVision("Vision");
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setCvs(new ArrayList<>());
        jobSeeker.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker.setEmail("jane.doe@example.org");
        jobSeeker.setFirstName("Jane");
        jobSeeker.setHomeAddress("42 Main St");
        jobSeeker.setHouseNumber("42");
        jobSeeker.setId(1L);
        jobSeeker.setPhoneNumber("6625550144");
        jobSeeker.setResidence("Residence");
        jobSeeker.setSurName("Doe");
        jobSeeker.setUser(new User());
        jobSeeker.setZipCode("21654");
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEmployer(employer);
        user.setId(1L);
        user.setJobSeeker(jobSeeker);
        user.setPassword("iloveyou");
        user.setRole(Role.USER);
        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("jane.doe@example.org");
        jobSeeker2.setFirstName("Jane");
        jobSeeker2.setHomeAddress("42 Main St");
        jobSeeker2.setHouseNumber("42");
        jobSeeker2.setId(1L);
        jobSeeker2.setPhoneNumber("6625550144");
        jobSeeker2.setResidence("Residence");
        jobSeeker2.setSurName("Doe");
        jobSeeker2.setUser(user);
        jobSeeker2.setZipCode("21654");
        CV cv = new CV();
        cv.setAboutMe("About Me");
        cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());
        actualStudyInfo.setCv(cv);
        actualStudyInfo.setEducation("Education");
        actualStudyInfo.setEducationalInstitute("Educational Institute");
        actualStudyInfo.setId(1L);
        actualStudyInfo.setPeriodOfStudy("Period Of Study");
        actualStudyInfo.setStudyInfo("Study Info");
        String actualToStringResult = actualStudyInfo.toString();
        CV actualCv = actualStudyInfo.getCv();
        String actualEducation = actualStudyInfo.getEducation();
        String actualEducationalInstitute = actualStudyInfo.getEducationalInstitute();
        long actualId = actualStudyInfo.getId();
        String actualPeriodOfStudy = actualStudyInfo.getPeriodOfStudy();

        // Assert that nothing has changed
        assertEquals("Education", actualEducation);
        assertEquals("Educational Institute", actualEducationalInstitute);
        assertEquals("Period Of Study", actualPeriodOfStudy);
        assertEquals("Study Info", actualStudyInfo.getStudyInfo());
        assertEquals("StudyInfo(cv=CV(id=1, docFile=[65, 88, 65, 88, 65, 88, 65, 88], fileName=foo.txt, aboutMe=About Me,"
                        + " jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=null, employer=null,"
                        + " id=null, email=null, password=null, role=null), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01,"
                        + " email=jane.doe@example.org, phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42"
                        + " Main St, houseNumber=42), employer=Employer(jobInfos=[], user=User(jobSeeker=null, employer=null,"
                        + " id=null, email=null, password=null, role=null), id=1, company=Company, industry=Industry, officeAdress"
                        + "=Office Adress, officeAdressNumber=42, officeZipcode=Office Zipcode, officeCityLocation=Office City"
                        + " Location, kvk=Kvk, mission=Mission, vision=Vision, numberOfEmployees=42), id=1, email=jane.doe@example.org,"
                        + " password=iloveyou, role=USER), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane"
                        + ".doe@example.org, phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42 Main St,"
                        + " houseNumber=42), workInfos=[], personalInfos=[], studyInfos=[]), id=1, educationalInstitute=Educational"
                        + " Institute, education=Education, periodOfStudy=Period Of Study, studyInfo=Study Info)",
                actualToStringResult);
        assertEquals(1L, actualId);
        assertSame(cv, actualCv);
    }

    @Test
    void testConstructor2() throws UnsupportedEncodingException {
        // Arrange
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEmployer(new Employer());
        user.setId(1L);
        user.setJobSeeker(new JobSeeker());
        user.setPassword("iloveyou");
        user.setRole(Role.USER);

        Employer employer = new Employer();
        employer.setCompany("Company");
        employer.setId(1L);
        employer.setIndustry("Industry");
        employer.setJobInfos(new ArrayList<>());
        employer.setKvk("Kvk");
        employer.setMission("Mission");
        employer.setNumberOfEmployees("42");
        employer.setOfficeAdress("Office Adress");
        employer.setOfficeAdressNumber("42");
        employer.setOfficeCityLocation("Office City Location");
        employer.setOfficeZipcode("Office Zipcode");
        employer.setUser(user);
        employer.setVision("Vision");

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(new Employer());
        user2.setId(1L);
        user2.setJobSeeker(new JobSeeker());
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setCvs(new ArrayList<>());
        jobSeeker.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker.setEmail("jane.doe@example.org");
        jobSeeker.setFirstName("Jane");
        jobSeeker.setHomeAddress("42 Main St");
        jobSeeker.setHouseNumber("42");
        jobSeeker.setId(1L);
        jobSeeker.setPhoneNumber("6625550144");
        jobSeeker.setResidence("Residence");
        jobSeeker.setSurName("Doe");
        jobSeeker.setUser(user2);
        jobSeeker.setZipCode("21654");

        User user3 = new User();
        user3.setEmail("jane.doe@example.org");
        user3.setEmployer(employer);
        user3.setId(1L);
        user3.setJobSeeker(jobSeeker);
        user3.setPassword("iloveyou");
        user3.setRole(Role.USER);

        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("jane.doe@example.org");
        jobSeeker2.setFirstName("Jane");
        jobSeeker2.setHomeAddress("42 Main St");
        jobSeeker2.setHouseNumber("42");
        jobSeeker2.setId(1L);
        jobSeeker2.setPhoneNumber("6625550144");
        jobSeeker2.setResidence("Residence");
        jobSeeker2.setSurName("Doe");
        jobSeeker2.setUser(user3);
        jobSeeker2.setZipCode("21654");

        CV cv = new CV();
        cv.setAboutMe("About Me");
        cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        // Act
        StudyInfo actualStudyInfo = new StudyInfo(cv, 1L, "Educational Institute", "Education", "Period Of Study",
                "Study Info");

        // Assert
        assertEquals("Education", actualStudyInfo.getEducation());
        assertEquals("Educational Institute", actualStudyInfo.getEducationalInstitute());
        assertEquals("Period Of Study", actualStudyInfo.getPeriodOfStudy());
        assertEquals("Study Info", actualStudyInfo.getStudyInfo());
        assertEquals(1L, actualStudyInfo.getId());
        assertSame(cv, actualStudyInfo.getCv());
    }

    @Test
    void testEquals() throws UnsupportedEncodingException {
        // Arrange
        Employer employer = new Employer();
        employer.setCompany("Company");
        employer.setId(1L);
        employer.setIndustry("Industry");
        employer.setJobInfos(new ArrayList<>());
        employer.setKvk("Kvk");
        employer.setMission("Mission");
        employer.setNumberOfEmployees("42");
        employer.setOfficeAdress("Office Adress");
        employer.setOfficeAdressNumber("42");
        employer.setOfficeCityLocation("Office City Location");
        employer.setOfficeZipcode("Office Zipcode");
        employer.setUser(new User());
        employer.setVision("Vision");

        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setCvs(new ArrayList<>());
        jobSeeker.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker.setEmail("jane.doe@example.org");
        jobSeeker.setFirstName("Jane");
        jobSeeker.setHomeAddress("42 Main St");
        jobSeeker.setHouseNumber("42");
        jobSeeker.setId(1L);
        jobSeeker.setPhoneNumber("6625550144");
        jobSeeker.setResidence("Residence");
        jobSeeker.setSurName("Doe");
        jobSeeker.setUser(new User());
        jobSeeker.setZipCode("21654");

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEmployer(employer);
        user.setId(1L);
        user.setJobSeeker(jobSeeker);
        user.setPassword("iloveyou");
        user.setRole(Role.USER);

        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("jane.doe@example.org");
        jobSeeker2.setFirstName("Jane");
        jobSeeker2.setHomeAddress("42 Main St");
        jobSeeker2.setHouseNumber("42");
        jobSeeker2.setId(1L);
        jobSeeker2.setPhoneNumber("6625550144");
        jobSeeker2.setResidence("Residence");
        jobSeeker2.setSurName("Doe");
        jobSeeker2.setUser(user);
        jobSeeker2.setZipCode("21654");

        CV cv = new CV();
        cv.setAboutMe("About Me");
        cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        StudyInfo studyInfo = new StudyInfo();
        studyInfo.setCv(cv);
        studyInfo.setEducation("Education");
        studyInfo.setEducationalInstitute("Educational Institute");
        studyInfo.setId(1L);
        studyInfo.setPeriodOfStudy("Period Of Study");
        studyInfo.setStudyInfo("Study Info");

        // Act and Assert
        assertNotEquals(studyInfo, null);
    }

    @Test
    void testEquals2() throws UnsupportedEncodingException {
        // Arrange
        Employer employer = new Employer();
        employer.setCompany("Company");
        employer.setId(1L);
        employer.setIndustry("Industry");
        employer.setJobInfos(new ArrayList<>());
        employer.setKvk("Kvk");
        employer.setMission("Mission");
        employer.setNumberOfEmployees("42");
        employer.setOfficeAdress("Office Adress");
        employer.setOfficeAdressNumber("42");
        employer.setOfficeCityLocation("Office City Location");
        employer.setOfficeZipcode("Office Zipcode");
        employer.setUser(new User());
        employer.setVision("Vision");

        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setCvs(new ArrayList<>());
        jobSeeker.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker.setEmail("jane.doe@example.org");
        jobSeeker.setFirstName("Jane");
        jobSeeker.setHomeAddress("42 Main St");
        jobSeeker.setHouseNumber("42");
        jobSeeker.setId(1L);
        jobSeeker.setPhoneNumber("6625550144");
        jobSeeker.setResidence("Residence");
        jobSeeker.setSurName("Doe");
        jobSeeker.setUser(new User());
        jobSeeker.setZipCode("21654");

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEmployer(employer);
        user.setId(1L);
        user.setJobSeeker(jobSeeker);
        user.setPassword("iloveyou");
        user.setRole(Role.USER);

        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("jane.doe@example.org");
        jobSeeker2.setFirstName("Jane");
        jobSeeker2.setHomeAddress("42 Main St");
        jobSeeker2.setHouseNumber("42");
        jobSeeker2.setId(1L);
        jobSeeker2.setPhoneNumber("6625550144");
        jobSeeker2.setResidence("Residence");
        jobSeeker2.setSurName("Doe");
        jobSeeker2.setUser(user);
        jobSeeker2.setZipCode("21654");

        CV cv = new CV();
        cv.setAboutMe("About Me");
        cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        StudyInfo studyInfo = new StudyInfo();
        studyInfo.setCv(cv);
        studyInfo.setEducation("Education");
        studyInfo.setEducationalInstitute("Educational Institute");
        studyInfo.setId(1L);
        studyInfo.setPeriodOfStudy("Period Of Study");
        studyInfo.setStudyInfo("Study Info");

        // Act and Assert
        assertNotEquals(studyInfo, "Different type to StudyInfo");
    }

    @Test
    void testEquals3() throws UnsupportedEncodingException {
        // Arrange
        Employer employer = new Employer();
        employer.setCompany("Company");
        employer.setId(1L);
        employer.setIndustry("Industry");
        employer.setJobInfos(new ArrayList<>());
        employer.setKvk("Kvk");
        employer.setMission("Mission");
        employer.setNumberOfEmployees("42");
        employer.setOfficeAdress("Office Adress");
        employer.setOfficeAdressNumber("42");
        employer.setOfficeCityLocation("Office City Location");
        employer.setOfficeZipcode("Office Zipcode");
        employer.setUser(new User());
        employer.setVision("Vision");

        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setCvs(new ArrayList<>());
        jobSeeker.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker.setEmail("jane.doe@example.org");
        jobSeeker.setFirstName("Jane");
        jobSeeker.setHomeAddress("42 Main St");
        jobSeeker.setHouseNumber("42");
        jobSeeker.setId(1L);
        jobSeeker.setPhoneNumber("6625550144");
        jobSeeker.setResidence("Residence");
        jobSeeker.setSurName("Doe");
        jobSeeker.setUser(new User());
        jobSeeker.setZipCode("21654");

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEmployer(employer);
        user.setId(1L);
        user.setJobSeeker(jobSeeker);
        user.setPassword("iloveyou");
        user.setRole(Role.USER);

        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("jane.doe@example.org");
        jobSeeker2.setFirstName("Jane");
        jobSeeker2.setHomeAddress("42 Main St");
        jobSeeker2.setHouseNumber("42");
        jobSeeker2.setId(1L);
        jobSeeker2.setPhoneNumber("6625550144");
        jobSeeker2.setResidence("Residence");
        jobSeeker2.setSurName("Doe");
        jobSeeker2.setUser(user);
        jobSeeker2.setZipCode("21654");

        CV cv = new CV();
        cv.setAboutMe("About Me");
        cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        StudyInfo studyInfo = new StudyInfo();
        studyInfo.setCv(cv);
        studyInfo.setEducation("Education");
        studyInfo.setEducationalInstitute("Educational Institute");
        studyInfo.setId(1L);
        studyInfo.setPeriodOfStudy("Period Of Study");
        studyInfo.setStudyInfo("Study Info");

        // Act and Assert
        assertEquals(studyInfo, studyInfo);
        int expectedHashCodeResult = studyInfo.hashCode();
        assertEquals(expectedHashCodeResult, studyInfo.hashCode());
    }

    @Test
    void testEquals4() throws UnsupportedEncodingException {
        // Arrange
        Employer employer = new Employer();
        employer.setCompany("Company");
        employer.setId(1L);
        employer.setIndustry("Industry");
        employer.setJobInfos(new ArrayList<>());
        employer.setKvk("Kvk");
        employer.setMission("Mission");
        employer.setNumberOfEmployees("42");
        employer.setOfficeAdress("Office Adress");
        employer.setOfficeAdressNumber("42");
        employer.setOfficeCityLocation("Office City Location");
        employer.setOfficeZipcode("Office Zipcode");
        employer.setUser(new User());
        employer.setVision("Vision");

        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setCvs(new ArrayList<>());
        jobSeeker.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker.setEmail("jane.doe@example.org");
        jobSeeker.setFirstName("Jane");
        jobSeeker.setHomeAddress("42 Main St");
        jobSeeker.setHouseNumber("42");
        jobSeeker.setId(1L);
        jobSeeker.setPhoneNumber("6625550144");
        jobSeeker.setResidence("Residence");
        jobSeeker.setSurName("Doe");
        jobSeeker.setUser(new User());
        jobSeeker.setZipCode("21654");

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEmployer(employer);
        user.setId(1L);
        user.setJobSeeker(jobSeeker);
        user.setPassword("iloveyou");
        user.setRole(Role.USER);

        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("jane.doe@example.org");
        jobSeeker2.setFirstName("Jane");
        jobSeeker2.setHomeAddress("42 Main St");
        jobSeeker2.setHouseNumber("42");
        jobSeeker2.setId(1L);
        jobSeeker2.setPhoneNumber("6625550144");
        jobSeeker2.setResidence("Residence");
        jobSeeker2.setSurName("Doe");
        jobSeeker2.setUser(user);
        jobSeeker2.setZipCode("21654");

        CV cv = new CV();
        cv.setAboutMe("About Me");
        cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        StudyInfo studyInfo = new StudyInfo();
        studyInfo.setCv(cv);
        studyInfo.setEducation("Education");
        studyInfo.setEducationalInstitute("Educational Institute");
        studyInfo.setId(1L);
        studyInfo.setPeriodOfStudy("Period Of Study");
        studyInfo.setStudyInfo("Study Info");

        Employer employer2 = new Employer();
        employer2.setCompany("Company");
        employer2.setId(1L);
        employer2.setIndustry("Industry");
        employer2.setJobInfos(new ArrayList<>());
        employer2.setKvk("Kvk");
        employer2.setMission("Mission");
        employer2.setNumberOfEmployees("42");
        employer2.setOfficeAdress("Office Adress");
        employer2.setOfficeAdressNumber("42");
        employer2.setOfficeCityLocation("Office City Location");
        employer2.setOfficeZipcode("Office Zipcode");
        employer2.setUser(new User());
        employer2.setVision("Vision");

        JobSeeker jobSeeker3 = new JobSeeker();
        jobSeeker3.setCvs(new ArrayList<>());
        jobSeeker3.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker3.setEmail("jane.doe@example.org");
        jobSeeker3.setFirstName("Jane");
        jobSeeker3.setHomeAddress("42 Main St");
        jobSeeker3.setHouseNumber("42");
        jobSeeker3.setId(1L);
        jobSeeker3.setPhoneNumber("6625550144");
        jobSeeker3.setResidence("Residence");
        jobSeeker3.setSurName("Doe");
        jobSeeker3.setUser(new User());
        jobSeeker3.setZipCode("21654");

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(employer2);
        user2.setId(1L);
        user2.setJobSeeker(jobSeeker3);
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

        JobSeeker jobSeeker4 = new JobSeeker();
        jobSeeker4.setCvs(new ArrayList<>());
        jobSeeker4.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker4.setEmail("jane.doe@example.org");
        jobSeeker4.setFirstName("Jane");
        jobSeeker4.setHomeAddress("42 Main St");
        jobSeeker4.setHouseNumber("42");
        jobSeeker4.setId(1L);
        jobSeeker4.setPhoneNumber("6625550144");
        jobSeeker4.setResidence("Residence");
        jobSeeker4.setSurName("Doe");
        jobSeeker4.setUser(user2);
        jobSeeker4.setZipCode("21654");

        CV cv2 = new CV();
        cv2.setAboutMe("About Me");
        cv2.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv2.setFileName("foo.txt");
        cv2.setId(1L);
        cv2.setJobSeeker(jobSeeker4);
        cv2.setPersonalInfos(new ArrayList<>());
        cv2.setStudyInfos(new ArrayList<>());
        cv2.setWorkInfos(new ArrayList<>());

        StudyInfo studyInfo2 = new StudyInfo();
        studyInfo2.setCv(cv2);
        studyInfo2.setEducation("Education");
        studyInfo2.setEducationalInstitute("Educational Institute");
        studyInfo2.setId(1L);
        studyInfo2.setPeriodOfStudy("Period Of Study");
        studyInfo2.setStudyInfo("Study Info");

        // Act and Assert
        assertEquals(studyInfo, studyInfo2);
        int expectedHashCodeResult = studyInfo.hashCode();
        assertEquals(expectedHashCodeResult, studyInfo2.hashCode());
    }

    @Test
    void testEquals5() throws UnsupportedEncodingException {
        // Arrange
        Employer employer = new Employer();
        employer.setCompany("Company");
        employer.setId(1L);
        employer.setIndustry("Industry");
        employer.setJobInfos(new ArrayList<>());
        employer.setKvk("Kvk");
        employer.setMission("Mission");
        employer.setNumberOfEmployees("42");
        employer.setOfficeAdress("Office Adress");
        employer.setOfficeAdressNumber("42");
        employer.setOfficeCityLocation("Office City Location");
        employer.setOfficeZipcode("Office Zipcode");
        employer.setUser(new User());
        employer.setVision("Vision");

        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setCvs(new ArrayList<>());
        jobSeeker.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker.setEmail("jane.doe@example.org");
        jobSeeker.setFirstName("Jane");
        jobSeeker.setHomeAddress("42 Main St");
        jobSeeker.setHouseNumber("42");
        jobSeeker.setId(1L);
        jobSeeker.setPhoneNumber("6625550144");
        jobSeeker.setResidence("Residence");
        jobSeeker.setSurName("Doe");
        jobSeeker.setUser(new User());
        jobSeeker.setZipCode("21654");

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEmployer(employer);
        user.setId(1L);
        user.setJobSeeker(jobSeeker);
        user.setPassword("iloveyou");
        user.setRole(Role.USER);

        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("jane.doe@example.org");
        jobSeeker2.setFirstName("Jane");
        jobSeeker2.setHomeAddress("42 Main St");
        jobSeeker2.setHouseNumber("42");
        jobSeeker2.setId(1L);
        jobSeeker2.setPhoneNumber("6625550144");
        jobSeeker2.setResidence("Residence");
        jobSeeker2.setSurName("Doe");
        jobSeeker2.setUser(user);
        jobSeeker2.setZipCode("21654");

        CV cv = new CV();
        cv.setAboutMe("foo.txt");
        cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        StudyInfo studyInfo = new StudyInfo();
        studyInfo.setCv(cv);
        studyInfo.setEducation("Education");
        studyInfo.setEducationalInstitute("Educational Institute");
        studyInfo.setId(1L);
        studyInfo.setPeriodOfStudy("Period Of Study");
        studyInfo.setStudyInfo("Study Info");

        Employer employer2 = new Employer();
        employer2.setCompany("Company");
        employer2.setId(1L);
        employer2.setIndustry("Industry");
        employer2.setJobInfos(new ArrayList<>());
        employer2.setKvk("Kvk");
        employer2.setMission("Mission");
        employer2.setNumberOfEmployees("42");
        employer2.setOfficeAdress("Office Adress");
        employer2.setOfficeAdressNumber("42");
        employer2.setOfficeCityLocation("Office City Location");
        employer2.setOfficeZipcode("Office Zipcode");
        employer2.setUser(new User());
        employer2.setVision("Vision");

        JobSeeker jobSeeker3 = new JobSeeker();
        jobSeeker3.setCvs(new ArrayList<>());
        jobSeeker3.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker3.setEmail("jane.doe@example.org");
        jobSeeker3.setFirstName("Jane");
        jobSeeker3.setHomeAddress("42 Main St");
        jobSeeker3.setHouseNumber("42");
        jobSeeker3.setId(1L);
        jobSeeker3.setPhoneNumber("6625550144");
        jobSeeker3.setResidence("Residence");
        jobSeeker3.setSurName("Doe");
        jobSeeker3.setUser(new User());
        jobSeeker3.setZipCode("21654");

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(employer2);
        user2.setId(1L);
        user2.setJobSeeker(jobSeeker3);
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

        JobSeeker jobSeeker4 = new JobSeeker();
        jobSeeker4.setCvs(new ArrayList<>());
        jobSeeker4.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker4.setEmail("jane.doe@example.org");
        jobSeeker4.setFirstName("Jane");
        jobSeeker4.setHomeAddress("42 Main St");
        jobSeeker4.setHouseNumber("42");
        jobSeeker4.setId(1L);
        jobSeeker4.setPhoneNumber("6625550144");
        jobSeeker4.setResidence("Residence");
        jobSeeker4.setSurName("Doe");
        jobSeeker4.setUser(user2);
        jobSeeker4.setZipCode("21654");

        CV cv2 = new CV();
        cv2.setAboutMe("About Me");
        cv2.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv2.setFileName("foo.txt");
        cv2.setId(1L);
        cv2.setJobSeeker(jobSeeker4);
        cv2.setPersonalInfos(new ArrayList<>());
        cv2.setStudyInfos(new ArrayList<>());
        cv2.setWorkInfos(new ArrayList<>());

        StudyInfo studyInfo2 = new StudyInfo();
        studyInfo2.setCv(cv2);
        studyInfo2.setEducation("Education");
        studyInfo2.setEducationalInstitute("Educational Institute");
        studyInfo2.setId(1L);
        studyInfo2.setPeriodOfStudy("Period Of Study");
        studyInfo2.setStudyInfo("Study Info");

        // Act and Assert
        assertNotEquals(studyInfo, studyInfo2);
    }
}
