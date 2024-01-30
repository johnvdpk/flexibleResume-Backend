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

class WorkInfoTest {

    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new WorkInfo()).canEqual("Other"));
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

        WorkInfo workInfo = new WorkInfo();
        workInfo.setCompany("Company");
        workInfo.setCv(cv);
        workInfo.setId(1L);
        workInfo.setJobInfo("Job Info");
        workInfo.setJobTitle("Dr");
        workInfo.setPeriodOfEmployment("Period Of Employment");

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

        WorkInfo workInfo2 = new WorkInfo();
        workInfo2.setCompany("Company");
        workInfo2.setCv(cv2);
        workInfo2.setId(1L);
        workInfo2.setJobInfo("Job Info");
        workInfo2.setJobTitle("Dr");
        workInfo2.setPeriodOfEmployment("Period Of Employment");

        // Act and Assert
        assertTrue(workInfo.canEqual(workInfo2));
    }

    @Test
    void testConstructor() throws UnsupportedEncodingException {
        // Arrange and Act
        WorkInfo actualWorkInfo = new WorkInfo();
        actualWorkInfo.setCompany("Company");
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
        actualWorkInfo.setCv(cv);
        actualWorkInfo.setId(1L);
        actualWorkInfo.setJobInfo("Job Info");
        actualWorkInfo.setJobTitle("Dr");
        actualWorkInfo.setPeriodOfEmployment("Period Of Employment");
        String actualToStringResult = actualWorkInfo.toString();
        String actualCompany = actualWorkInfo.getCompany();
        CV actualCv = actualWorkInfo.getCv();
        Long actualId = actualWorkInfo.getId();
        String actualJobInfo = actualWorkInfo.getJobInfo();
        String actualJobTitle = actualWorkInfo.getJobTitle();

        // Assert that nothing has changed
        assertEquals("Company", actualCompany);
        assertEquals("Dr", actualJobTitle);
        assertEquals("Job Info", actualJobInfo);
        assertEquals("Period Of Employment", actualWorkInfo.getPeriodOfEmployment());
        assertEquals("WorkInfo(cv=CV(id=1, docFile=[65, 88, 65, 88, 65, 88, 65, 88], fileName=foo.txt, aboutMe=About Me,"
                + " jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=null, employer=null,"
                + " id=null, email=null, password=null, role=null), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01,"
                + " email=jane.doe@example.org, phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42"
                + " Main St, houseNumber=42), employer=Employer(jobInfos=[], user=User(jobSeeker=null, employer=null,"
                + " id=null, email=null, password=null, role=null), id=1, company=Company, industry=Industry, officeAdress"
                + "=Office Adress, officeAdressNumber=42, officeZipcode=Office Zipcode, officeCityLocation=Office City"
                + " Location, kvk=Kvk, mission=Mission, vision=Vision, numberOfEmployees=42), id=1, email=jane.doe@example.org,"
                + " password=iloveyou, role=USER), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane"
                + ".doe@example.org, phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42 Main St,"
                + " houseNumber=42), workInfos=[], personalInfos=[], studyInfos=[]), id=1, company=Company, jobTitle=Dr,"
                + " periodOfEmployment=Period Of Employment, jobInfo=Job Info)", actualToStringResult);
        assertEquals(1L, actualId.longValue());
        assertSame(cv, actualCv);
    }


    @Test
    void testConstructor2() throws UnsupportedEncodingException {
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

        // Act
        WorkInfo actualWorkInfo = new WorkInfo(cv, 1L, "Company", "Dr", "Period Of Employment", "Job Info");
        actualWorkInfo.setCompany("Company");
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
        actualWorkInfo.setCv(cv2);
        actualWorkInfo.setId(1L);
        actualWorkInfo.setJobInfo("Job Info");
        actualWorkInfo.setJobTitle("Dr");
        actualWorkInfo.setPeriodOfEmployment("Period Of Employment");
        String actualToStringResult = actualWorkInfo.toString();
        String actualCompany = actualWorkInfo.getCompany();
        CV actualCv = actualWorkInfo.getCv();
        Long actualId = actualWorkInfo.getId();
        String actualJobInfo = actualWorkInfo.getJobInfo();
        String actualJobTitle = actualWorkInfo.getJobTitle();

        // Assert that nothing has changed
        assertEquals("Company", actualCompany);
        assertEquals("Dr", actualJobTitle);
        assertEquals("Job Info", actualJobInfo);
        assertEquals("Period Of Employment", actualWorkInfo.getPeriodOfEmployment());
        assertEquals("WorkInfo(cv=CV(id=1, docFile=[65, 88, 65, 88, 65, 88, 65, 88], fileName=foo.txt, aboutMe=About Me,"
                + " jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=null, employer=null,"
                + " id=null, email=null, password=null, role=null), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01,"
                + " email=jane.doe@example.org, phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42"
                + " Main St, houseNumber=42), employer=Employer(jobInfos=[], user=User(jobSeeker=null, employer=null,"
                + " id=null, email=null, password=null, role=null), id=1, company=Company, industry=Industry, officeAdress"
                + "=Office Adress, officeAdressNumber=42, officeZipcode=Office Zipcode, officeCityLocation=Office City"
                + " Location, kvk=Kvk, mission=Mission, vision=Vision, numberOfEmployees=42), id=1, email=jane.doe@example.org,"
                + " password=iloveyou, role=USER), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane"
                + ".doe@example.org, phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42 Main St,"
                + " houseNumber=42), workInfos=[], personalInfos=[], studyInfos=[]), id=1, company=Company, jobTitle=Dr,"
                + " periodOfEmployment=Period Of Employment, jobInfo=Job Info)", actualToStringResult);
        assertEquals(1L, actualId.longValue());
        assertEquals(cv, actualCv);
        assertSame(cv2, actualCv);
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

        WorkInfo workInfo = new WorkInfo();
        workInfo.setCompany("Company");
        workInfo.setCv(cv);
        workInfo.setId(1L);
        workInfo.setJobInfo("Job Info");
        workInfo.setJobTitle("Dr");
        workInfo.setPeriodOfEmployment("Period Of Employment");

        // Act and Assert
        assertNotEquals(workInfo, null);
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

        WorkInfo workInfo = new WorkInfo();
        workInfo.setCompany("Company");
        workInfo.setCv(cv);
        workInfo.setId(1L);
        workInfo.setJobInfo("Job Info");
        workInfo.setJobTitle("Dr");
        workInfo.setPeriodOfEmployment("Period Of Employment");

        // Act and Assert
        assertNotEquals(workInfo, "Different type to WorkInfo");
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

        WorkInfo workInfo = new WorkInfo();
        workInfo.setCompany("Company");
        workInfo.setCv(cv);
        workInfo.setId(1L);
        workInfo.setJobInfo("Job Info");
        workInfo.setJobTitle("Dr");
        workInfo.setPeriodOfEmployment("Period Of Employment");

        // Act and Assert
        assertEquals(workInfo, workInfo);
        int expectedHashCodeResult = workInfo.hashCode();
        assertEquals(expectedHashCodeResult, workInfo.hashCode());
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

        WorkInfo workInfo = new WorkInfo();
        workInfo.setCompany("Company");
        workInfo.setCv(cv);
        workInfo.setId(1L);
        workInfo.setJobInfo("Job Info");
        workInfo.setJobTitle("Dr");
        workInfo.setPeriodOfEmployment("Period Of Employment");

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

        WorkInfo workInfo2 = new WorkInfo();
        workInfo2.setCompany("Company");
        workInfo2.setCv(cv2);
        workInfo2.setId(1L);
        workInfo2.setJobInfo("Job Info");
        workInfo2.setJobTitle("Dr");
        workInfo2.setPeriodOfEmployment("Period Of Employment");

        // Act and Assert
        assertEquals(workInfo, workInfo2);
        int expectedHashCodeResult = workInfo.hashCode();
        assertEquals(expectedHashCodeResult, workInfo2.hashCode());
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
        cv.setAboutMe("About Me");
        cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        WorkInfo workInfo = new WorkInfo();
        workInfo.setCompany("foo.txt");
        workInfo.setCv(cv);
        workInfo.setId(1L);
        workInfo.setJobInfo("Job Info");
        workInfo.setJobTitle("Dr");
        workInfo.setPeriodOfEmployment("Period Of Employment");

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

        WorkInfo workInfo2 = new WorkInfo();
        workInfo2.setCompany("Company");
        workInfo2.setCv(cv2);
        workInfo2.setId(1L);
        workInfo2.setJobInfo("Job Info");
        workInfo2.setJobTitle("Dr");
        workInfo2.setPeriodOfEmployment("Period Of Employment");

        // Act and Assert
        assertNotEquals(workInfo, workInfo2);
    }


    @Test
    void testEquals6() throws UnsupportedEncodingException {
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

        WorkInfo workInfo = new WorkInfo();
        workInfo.setCompany(null);
        workInfo.setCv(cv);
        workInfo.setId(1L);
        workInfo.setJobInfo("Job Info");
        workInfo.setJobTitle("Dr");
        workInfo.setPeriodOfEmployment("Period Of Employment");

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

        WorkInfo workInfo2 = new WorkInfo();
        workInfo2.setCompany("Company");
        workInfo2.setCv(cv2);
        workInfo2.setId(1L);
        workInfo2.setJobInfo("Job Info");
        workInfo2.setJobTitle("Dr");
        workInfo2.setPeriodOfEmployment("Period Of Employment");

        // Act and Assert
        assertNotEquals(workInfo, workInfo2);
    }

    @Test
    void testEquals7() throws UnsupportedEncodingException {
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

        WorkInfo workInfo = new WorkInfo();
        workInfo.setCompany("Company");
        workInfo.setCv(cv);
        workInfo.setId(1L);
        workInfo.setJobInfo("Job Info");
        workInfo.setJobTitle("Dr");
        workInfo.setPeriodOfEmployment("Period Of Employment");

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

        WorkInfo workInfo2 = new WorkInfo();
        workInfo2.setCompany("Company");
        workInfo2.setCv(cv2);
        workInfo2.setId(1L);
        workInfo2.setJobInfo("Job Info");
        workInfo2.setJobTitle("Dr");
        workInfo2.setPeriodOfEmployment("Period Of Employment");

        // Act and Assert
        assertNotEquals(workInfo, workInfo2);
    }
}
