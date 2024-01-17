package com.example.flexibleresume.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.flexibleresume.user.Role;
import com.example.flexibleresume.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class JobSeekerTest {

    @Test
    void testCanEqual() {
        assertFalse((new JobSeeker()).canEqual("Other"));
    }


    @Test
    void testCanEqual2() {
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

        User user4 = new User();
        user4.setEmail("jane.doe@example.org");
        user4.setEmployer(new Employer());
        user4.setId(1L);
        user4.setJobSeeker(new JobSeeker());
        user4.setPassword("iloveyou");
        user4.setRole(Role.USER);

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
        employer2.setUser(user4);
        employer2.setVision("Vision");

        User user5 = new User();
        user5.setEmail("jane.doe@example.org");
        user5.setEmployer(new Employer());
        user5.setId(1L);
        user5.setJobSeeker(new JobSeeker());
        user5.setPassword("iloveyou");
        user5.setRole(Role.USER);

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
        jobSeeker3.setUser(user5);
        jobSeeker3.setZipCode("21654");

        User user6 = new User();
        user6.setEmail("jane.doe@example.org");
        user6.setEmployer(employer2);
        user6.setId(1L);
        user6.setJobSeeker(jobSeeker3);
        user6.setPassword("iloveyou");
        user6.setRole(Role.USER);

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
        jobSeeker4.setUser(user6);
        jobSeeker4.setZipCode("21654");
        assertTrue(jobSeeker2.canEqual(jobSeeker4));
    }


    @Test
    void testConstructor() {
        JobSeeker actualJobSeeker = new JobSeeker();
        ArrayList<CV> cvs = new ArrayList<>();
        actualJobSeeker.setCvs(cvs);
        LocalDate dateOfBirth = LocalDate.of(1970, 1, 1);
        actualJobSeeker.setDateOfBirth(dateOfBirth);
        actualJobSeeker.setEmail("jane.doe@example.org");
        actualJobSeeker.setFirstName("Jane");
        actualJobSeeker.setHomeAddress("42 Main St");
        actualJobSeeker.setHouseNumber("42");
        actualJobSeeker.setId(1L);
        actualJobSeeker.setPhoneNumber("6625550144");
        actualJobSeeker.setResidence("Residence");
        actualJobSeeker.setSurName("Doe");
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
        employer2.setUser(user);
        employer2.setVision("Vision");
        Employer employer3 = new Employer();
        employer3.setCompany("Company");
        employer3.setId(1L);
        employer3.setIndustry("Industry");
        employer3.setJobInfos(new ArrayList<>());
        employer3.setKvk("Kvk");
        employer3.setMission("Mission");
        employer3.setNumberOfEmployees("42");
        employer3.setOfficeAdress("Office Adress");
        employer3.setOfficeAdressNumber("42");
        employer3.setOfficeCityLocation("Office City Location");
        employer3.setOfficeZipcode("Office Zipcode");
        employer3.setUser(new User());
        employer3.setVision("Vision");
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
        jobSeeker2.setUser(new User());
        jobSeeker2.setZipCode("21654");
        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(employer3);
        user2.setId(1L);
        user2.setJobSeeker(jobSeeker2);
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);
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
        jobSeeker3.setUser(user2);
        jobSeeker3.setZipCode("21654");
        User user3 = new User();
        user3.setEmail("jane.doe@example.org");
        user3.setEmployer(employer2);
        user3.setId(1L);
        user3.setJobSeeker(jobSeeker3);
        user3.setPassword("iloveyou");
        user3.setRole(Role.USER);
        actualJobSeeker.setUser(user3);
        actualJobSeeker.setZipCode("21654");
        String actualToStringResult = actualJobSeeker.toString();
        List<CV> actualCvs = actualJobSeeker.getCvs();
        LocalDate actualDateOfBirth = actualJobSeeker.getDateOfBirth();
        String actualEmail = actualJobSeeker.getEmail();
        String actualFirstName = actualJobSeeker.getFirstName();
        String actualHomeAddress = actualJobSeeker.getHomeAddress();
        String actualHouseNumber = actualJobSeeker.getHouseNumber();
        Long actualId = actualJobSeeker.getId();
        String actualPhoneNumber = actualJobSeeker.getPhoneNumber();
        String actualResidence = actualJobSeeker.getResidence();
        String actualSurName = actualJobSeeker.getSurName();
        User actualUser = actualJobSeeker.getUser();
        assertEquals("21654", actualJobSeeker.getZipCode());
        assertEquals("42 Main St", actualHomeAddress);
        assertEquals("42", actualHouseNumber);
        assertEquals("6625550144", actualPhoneNumber);
        assertEquals("Doe", actualSurName);
        assertEquals("Jane", actualFirstName);
        assertEquals("JobSeeker(cvs=[], user=User(jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=JobSeeker(cvs=[],"
                        + " user=User(jobSeeker=null, employer=null, id=null, email=null, password=null, role=null), id=1,"
                        + " firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe@example.org, phoneNumber=6625550144,"
                        + " residence=Residence, zipCode=21654, homeAddress=42 Main St, houseNumber=42), employer=Employer(jobInfos=[],"
                        + " user=User(jobSeeker=null, employer=null, id=null, email=null, password=null, role=null), id=1,"
                        + " company=Company, industry=Industry, officeAdress=Office Adress, officeAdressNumber=42, officeZipcode=Office"
                        + " Zipcode, officeCityLocation=Office City Location, kvk=Kvk, mission=Mission, vision=Vision,"
                        + " numberOfEmployees=42), id=1, email=jane.doe@example.org, password=iloveyou, role=USER), id=1,"
                        + " firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe@example.org, phoneNumber=6625550144,"
                        + " residence=Residence, zipCode=21654, homeAddress=42 Main St, houseNumber=42), employer=Employer(jobInfos=[],"
                        + " user=User(jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=null, employer=null, id=null, email=null,"
                        + " password=null, role=null), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe"
                        + "@example.org, phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42 Main St,"
                        + " houseNumber=42), employer=Employer(jobInfos=[], user=User(jobSeeker=null, employer=null, id=null,"
                        + " email=null, password=null, role=null), id=1, company=Company, industry=Industry, officeAdress=Office"
                        + " Adress, officeAdressNumber=42, officeZipcode=Office Zipcode, officeCityLocation=Office City Location,"
                        + " kvk=Kvk, mission=Mission, vision=Vision, numberOfEmployees=42), id=1, email=jane.doe@example.org,"
                        + " password=iloveyou, role=USER), id=1, company=Company, industry=Industry, officeAdress=Office Adress,"
                        + " officeAdressNumber=42, officeZipcode=Office Zipcode, officeCityLocation=Office City Location, kvk=Kvk,"
                        + " mission=Mission, vision=Vision, numberOfEmployees=42), id=1, email=jane.doe@example.org, password=iloveyou,"
                        + " role=USER), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe@example.org,"
                        + " phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42 Main St, houseNumber=42)",
                actualToStringResult);
        assertEquals("Residence", actualResidence);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
        assertSame(user3, actualUser);
        assertSame(cvs, actualCvs);
        assertSame(dateOfBirth, actualDateOfBirth);
    }


    @Test
    void testConstructor2() {
        ArrayList<CV> cvs = new ArrayList<>();

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
        employer2.setUser(user);
        employer2.setVision("Vision");

        Employer employer3 = new Employer();
        employer3.setCompany("Company");
        employer3.setId(1L);
        employer3.setIndustry("Industry");
        employer3.setJobInfos(new ArrayList<>());
        employer3.setKvk("Kvk");
        employer3.setMission("Mission");
        employer3.setNumberOfEmployees("42");
        employer3.setOfficeAdress("Office Adress");
        employer3.setOfficeAdressNumber("42");
        employer3.setOfficeCityLocation("Office City Location");
        employer3.setOfficeZipcode("Office Zipcode");
        employer3.setUser(new User());
        employer3.setVision("Vision");

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
        jobSeeker2.setUser(new User());
        jobSeeker2.setZipCode("21654");

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(employer3);
        user2.setId(1L);
        user2.setJobSeeker(jobSeeker2);
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

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
        jobSeeker3.setUser(user2);
        jobSeeker3.setZipCode("21654");

        User user3 = new User();
        user3.setEmail("jane.doe@example.org");
        user3.setEmployer(employer2);
        user3.setId(1L);
        user3.setJobSeeker(jobSeeker3);
        user3.setPassword("iloveyou");
        user3.setRole(Role.USER);
        JobSeeker actualJobSeeker = new JobSeeker(cvs, user3, 1L, "Jane", "Doe", LocalDate.of(1970, 1, 1),
                "jane.doe@example.org", "6625550144", "Residence", "21654", "42 Main St", "42");
        ArrayList<CV> cvs2 = new ArrayList<>();
        actualJobSeeker.setCvs(cvs2);
        LocalDate dateOfBirth = LocalDate.of(1970, 1, 1);
        actualJobSeeker.setDateOfBirth(dateOfBirth);
        actualJobSeeker.setEmail("jane.doe@example.org");
        actualJobSeeker.setFirstName("Jane");
        actualJobSeeker.setHomeAddress("42 Main St");
        actualJobSeeker.setHouseNumber("42");
        actualJobSeeker.setId(1L);
        actualJobSeeker.setPhoneNumber("6625550144");
        actualJobSeeker.setResidence("Residence");
        actualJobSeeker.setSurName("Doe");
        Employer employer4 = new Employer();
        employer4.setCompany("Company");
        employer4.setId(1L);
        employer4.setIndustry("Industry");
        employer4.setJobInfos(new ArrayList<>());
        employer4.setKvk("Kvk");
        employer4.setMission("Mission");
        employer4.setNumberOfEmployees("42");
        employer4.setOfficeAdress("Office Adress");
        employer4.setOfficeAdressNumber("42");
        employer4.setOfficeCityLocation("Office City Location");
        employer4.setOfficeZipcode("Office Zipcode");
        employer4.setUser(new User());
        employer4.setVision("Vision");
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
        jobSeeker4.setUser(new User());
        jobSeeker4.setZipCode("21654");
        User user4 = new User();
        user4.setEmail("jane.doe@example.org");
        user4.setEmployer(employer4);
        user4.setId(1L);
        user4.setJobSeeker(jobSeeker4);
        user4.setPassword("iloveyou");
        user4.setRole(Role.USER);
        Employer employer5 = new Employer();
        employer5.setCompany("Company");
        employer5.setId(1L);
        employer5.setIndustry("Industry");
        employer5.setJobInfos(new ArrayList<>());
        employer5.setKvk("Kvk");
        employer5.setMission("Mission");
        employer5.setNumberOfEmployees("42");
        employer5.setOfficeAdress("Office Adress");
        employer5.setOfficeAdressNumber("42");
        employer5.setOfficeCityLocation("Office City Location");
        employer5.setOfficeZipcode("Office Zipcode");
        employer5.setUser(user4);
        employer5.setVision("Vision");
        Employer employer6 = new Employer();
        employer6.setCompany("Company");
        employer6.setId(1L);
        employer6.setIndustry("Industry");
        employer6.setJobInfos(new ArrayList<>());
        employer6.setKvk("Kvk");
        employer6.setMission("Mission");
        employer6.setNumberOfEmployees("42");
        employer6.setOfficeAdress("Office Adress");
        employer6.setOfficeAdressNumber("42");
        employer6.setOfficeCityLocation("Office City Location");
        employer6.setOfficeZipcode("Office Zipcode");
        employer6.setUser(new User());
        employer6.setVision("Vision");
        JobSeeker jobSeeker5 = new JobSeeker();
        jobSeeker5.setCvs(new ArrayList<>());
        jobSeeker5.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker5.setEmail("jane.doe@example.org");
        jobSeeker5.setFirstName("Jane");
        jobSeeker5.setHomeAddress("42 Main St");
        jobSeeker5.setHouseNumber("42");
        jobSeeker5.setId(1L);
        jobSeeker5.setPhoneNumber("6625550144");
        jobSeeker5.setResidence("Residence");
        jobSeeker5.setSurName("Doe");
        jobSeeker5.setUser(new User());
        jobSeeker5.setZipCode("21654");
        User user5 = new User();
        user5.setEmail("jane.doe@example.org");
        user5.setEmployer(employer6);
        user5.setId(1L);
        user5.setJobSeeker(jobSeeker5);
        user5.setPassword("iloveyou");
        user5.setRole(Role.USER);
        JobSeeker jobSeeker6 = new JobSeeker();
        jobSeeker6.setCvs(new ArrayList<>());
        jobSeeker6.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker6.setEmail("jane.doe@example.org");
        jobSeeker6.setFirstName("Jane");
        jobSeeker6.setHomeAddress("42 Main St");
        jobSeeker6.setHouseNumber("42");
        jobSeeker6.setId(1L);
        jobSeeker6.setPhoneNumber("6625550144");
        jobSeeker6.setResidence("Residence");
        jobSeeker6.setSurName("Doe");
        jobSeeker6.setUser(user5);
        jobSeeker6.setZipCode("21654");
        User user6 = new User();
        user6.setEmail("jane.doe@example.org");
        user6.setEmployer(employer5);
        user6.setId(1L);
        user6.setJobSeeker(jobSeeker6);
        user6.setPassword("iloveyou");
        user6.setRole(Role.USER);
        actualJobSeeker.setUser(user6);
        actualJobSeeker.setZipCode("21654");
        String actualToStringResult = actualJobSeeker.toString();
        List<CV> actualCvs = actualJobSeeker.getCvs();
        LocalDate actualDateOfBirth = actualJobSeeker.getDateOfBirth();
        String actualEmail = actualJobSeeker.getEmail();
        String actualFirstName = actualJobSeeker.getFirstName();
        String actualHomeAddress = actualJobSeeker.getHomeAddress();
        String actualHouseNumber = actualJobSeeker.getHouseNumber();
        Long actualId = actualJobSeeker.getId();
        String actualPhoneNumber = actualJobSeeker.getPhoneNumber();
        String actualResidence = actualJobSeeker.getResidence();
        String actualSurName = actualJobSeeker.getSurName();
        User actualUser = actualJobSeeker.getUser();
        assertEquals("21654", actualJobSeeker.getZipCode());
        assertEquals("42 Main St", actualHomeAddress);
        assertEquals("42", actualHouseNumber);
        assertEquals("6625550144", actualPhoneNumber);
        assertEquals("Doe", actualSurName);
        assertEquals("Jane", actualFirstName);
        assertEquals("JobSeeker(cvs=[], user=User(jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=JobSeeker(cvs=[],"
                        + " user=User(jobSeeker=null, employer=null, id=null, email=null, password=null, role=null), id=1,"
                        + " firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe@example.org, phoneNumber=6625550144,"
                        + " residence=Residence, zipCode=21654, homeAddress=42 Main St, houseNumber=42), employer=Employer(jobInfos=[],"
                        + " user=User(jobSeeker=null, employer=null, id=null, email=null, password=null, role=null), id=1,"
                        + " company=Company, industry=Industry, officeAdress=Office Adress, officeAdressNumber=42, officeZipcode=Office"
                        + " Zipcode, officeCityLocation=Office City Location, kvk=Kvk, mission=Mission, vision=Vision,"
                        + " numberOfEmployees=42), id=1, email=jane.doe@example.org, password=iloveyou, role=USER), id=1,"
                        + " firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe@example.org, phoneNumber=6625550144,"
                        + " residence=Residence, zipCode=21654, homeAddress=42 Main St, houseNumber=42), employer=Employer(jobInfos=[],"
                        + " user=User(jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=null, employer=null, id=null, email=null,"
                        + " password=null, role=null), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe"
                        + "@example.org, phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42 Main St,"
                        + " houseNumber=42), employer=Employer(jobInfos=[], user=User(jobSeeker=null, employer=null, id=null,"
                        + " email=null, password=null, role=null), id=1, company=Company, industry=Industry, officeAdress=Office"
                        + " Adress, officeAdressNumber=42, officeZipcode=Office Zipcode, officeCityLocation=Office City Location,"
                        + " kvk=Kvk, mission=Mission, vision=Vision, numberOfEmployees=42), id=1, email=jane.doe@example.org,"
                        + " password=iloveyou, role=USER), id=1, company=Company, industry=Industry, officeAdress=Office Adress,"
                        + " officeAdressNumber=42, officeZipcode=Office Zipcode, officeCityLocation=Office City Location, kvk=Kvk,"
                        + " mission=Mission, vision=Vision, numberOfEmployees=42), id=1, email=jane.doe@example.org, password=iloveyou,"
                        + " role=USER), id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe@example.org,"
                        + " phoneNumber=6625550144, residence=Residence, zipCode=21654, homeAddress=42 Main St, houseNumber=42)",
                actualToStringResult);
        assertEquals("Residence", actualResidence);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
        assertEquals(user3, actualUser);
        assertEquals(cvs, actualCvs);
        assertSame(user6, actualUser);
        assertSame(cvs2, actualCvs);
        assertSame(dateOfBirth, actualDateOfBirth);
    }

    @Test
    void testEquals() {
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
        employer2.setUser(user);
        employer2.setVision("Vision");

        Employer employer3 = new Employer();
        employer3.setCompany("Company");
        employer3.setId(1L);
        employer3.setIndustry("Industry");
        employer3.setJobInfos(new ArrayList<>());
        employer3.setKvk("Kvk");
        employer3.setMission("Mission");
        employer3.setNumberOfEmployees("42");
        employer3.setOfficeAdress("Office Adress");
        employer3.setOfficeAdressNumber("42");
        employer3.setOfficeCityLocation("Office City Location");
        employer3.setOfficeZipcode("Office Zipcode");
        employer3.setUser(new User());
        employer3.setVision("Vision");

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
        jobSeeker2.setUser(new User());
        jobSeeker2.setZipCode("21654");

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(employer3);
        user2.setId(1L);
        user2.setJobSeeker(jobSeeker2);
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

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
        jobSeeker3.setUser(user2);
        jobSeeker3.setZipCode("21654");

        User user3 = new User();
        user3.setEmail("jane.doe@example.org");
        user3.setEmployer(employer2);
        user3.setId(1L);
        user3.setJobSeeker(jobSeeker3);
        user3.setPassword("iloveyou");
        user3.setRole(Role.USER);

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
        jobSeeker4.setUser(user3);
        jobSeeker4.setZipCode("21654");
        assertNotEquals(jobSeeker4, null);
    }


    @Test
    void testEquals2() {
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
        employer2.setUser(user);
        employer2.setVision("Vision");

        Employer employer3 = new Employer();
        employer3.setCompany("Company");
        employer3.setId(1L);
        employer3.setIndustry("Industry");
        employer3.setJobInfos(new ArrayList<>());
        employer3.setKvk("Kvk");
        employer3.setMission("Mission");
        employer3.setNumberOfEmployees("42");
        employer3.setOfficeAdress("Office Adress");
        employer3.setOfficeAdressNumber("42");
        employer3.setOfficeCityLocation("Office City Location");
        employer3.setOfficeZipcode("Office Zipcode");
        employer3.setUser(new User());
        employer3.setVision("Vision");

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
        jobSeeker2.setUser(new User());
        jobSeeker2.setZipCode("21654");

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(employer3);
        user2.setId(1L);
        user2.setJobSeeker(jobSeeker2);
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

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
        jobSeeker3.setUser(user2);
        jobSeeker3.setZipCode("21654");

        User user3 = new User();
        user3.setEmail("jane.doe@example.org");
        user3.setEmployer(employer2);
        user3.setId(1L);
        user3.setJobSeeker(jobSeeker3);
        user3.setPassword("iloveyou");
        user3.setRole(Role.USER);

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
        jobSeeker4.setUser(user3);
        jobSeeker4.setZipCode("21654");
        assertNotEquals(jobSeeker4, "Different type to JobSeeker");
    }


    @Test
    void testEquals3() {
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
        employer2.setUser(user);
        employer2.setVision("Vision");

        Employer employer3 = new Employer();
        employer3.setCompany("Company");
        employer3.setId(1L);
        employer3.setIndustry("Industry");
        employer3.setJobInfos(new ArrayList<>());
        employer3.setKvk("Kvk");
        employer3.setMission("Mission");
        employer3.setNumberOfEmployees("42");
        employer3.setOfficeAdress("Office Adress");
        employer3.setOfficeAdressNumber("42");
        employer3.setOfficeCityLocation("Office City Location");
        employer3.setOfficeZipcode("Office Zipcode");
        employer3.setUser(new User());
        employer3.setVision("Vision");

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
        jobSeeker2.setUser(new User());
        jobSeeker2.setZipCode("21654");

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(employer3);
        user2.setId(1L);
        user2.setJobSeeker(jobSeeker2);
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

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
        jobSeeker3.setUser(user2);
        jobSeeker3.setZipCode("21654");

        User user3 = new User();
        user3.setEmail("jane.doe@example.org");
        user3.setEmployer(employer2);
        user3.setId(1L);
        user3.setJobSeeker(jobSeeker3);
        user3.setPassword("iloveyou");
        user3.setRole(Role.USER);

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
        jobSeeker4.setUser(user3);
        jobSeeker4.setZipCode("21654");
        assertEquals(jobSeeker4, jobSeeker4);
        int expectedHashCodeResult = jobSeeker4.hashCode();
        assertEquals(expectedHashCodeResult, jobSeeker4.hashCode());
    }


    @Test
    void testEquals4() {
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
        employer2.setUser(user);
        employer2.setVision("Vision");

        Employer employer3 = new Employer();
        employer3.setCompany("Company");
        employer3.setId(1L);
        employer3.setIndustry("Industry");
        employer3.setJobInfos(new ArrayList<>());
        employer3.setKvk("Kvk");
        employer3.setMission("Mission");
        employer3.setNumberOfEmployees("42");
        employer3.setOfficeAdress("Office Adress");
        employer3.setOfficeAdressNumber("42");
        employer3.setOfficeCityLocation("Office City Location");
        employer3.setOfficeZipcode("Office Zipcode");
        employer3.setUser(new User());
        employer3.setVision("Vision");

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
        jobSeeker2.setUser(new User());
        jobSeeker2.setZipCode("21654");

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(employer3);
        user2.setId(1L);
        user2.setJobSeeker(jobSeeker2);
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

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
        jobSeeker3.setUser(user2);
        jobSeeker3.setZipCode("21654");

        User user3 = new User();
        user3.setEmail("jane.doe@example.org");
        user3.setEmployer(employer2);
        user3.setId(1L);
        user3.setJobSeeker(jobSeeker3);
        user3.setPassword("iloveyou");
        user3.setRole(Role.USER);

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
        jobSeeker4.setUser(user3);
        jobSeeker4.setZipCode("21654");

        Employer employer4 = new Employer();
        employer4.setCompany("Company");
        employer4.setId(1L);
        employer4.setIndustry("Industry");
        employer4.setJobInfos(new ArrayList<>());
        employer4.setKvk("Kvk");
        employer4.setMission("Mission");
        employer4.setNumberOfEmployees("42");
        employer4.setOfficeAdress("Office Adress");
        employer4.setOfficeAdressNumber("42");
        employer4.setOfficeCityLocation("Office City Location");
        employer4.setOfficeZipcode("Office Zipcode");
        employer4.setUser(new User());
        employer4.setVision("Vision");

        JobSeeker jobSeeker5 = new JobSeeker();
        jobSeeker5.setCvs(new ArrayList<>());
        jobSeeker5.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker5.setEmail("jane.doe@example.org");
        jobSeeker5.setFirstName("Jane");
        jobSeeker5.setHomeAddress("42 Main St");
        jobSeeker5.setHouseNumber("42");
        jobSeeker5.setId(1L);
        jobSeeker5.setPhoneNumber("6625550144");
        jobSeeker5.setResidence("Residence");
        jobSeeker5.setSurName("Doe");
        jobSeeker5.setUser(new User());
        jobSeeker5.setZipCode("21654");

        User user4 = new User();
        user4.setEmail("jane.doe@example.org");
        user4.setEmployer(employer4);
        user4.setId(1L);
        user4.setJobSeeker(jobSeeker5);
        user4.setPassword("iloveyou");
        user4.setRole(Role.USER);

        Employer employer5 = new Employer();
        employer5.setCompany("Company");
        employer5.setId(1L);
        employer5.setIndustry("Industry");
        employer5.setJobInfos(new ArrayList<>());
        employer5.setKvk("Kvk");
        employer5.setMission("Mission");
        employer5.setNumberOfEmployees("42");
        employer5.setOfficeAdress("Office Adress");
        employer5.setOfficeAdressNumber("42");
        employer5.setOfficeCityLocation("Office City Location");
        employer5.setOfficeZipcode("Office Zipcode");
        employer5.setUser(user4);
        employer5.setVision("Vision");

        Employer employer6 = new Employer();
        employer6.setCompany("Company");
        employer6.setId(1L);
        employer6.setIndustry("Industry");
        employer6.setJobInfos(new ArrayList<>());
        employer6.setKvk("Kvk");
        employer6.setMission("Mission");
        employer6.setNumberOfEmployees("42");
        employer6.setOfficeAdress("Office Adress");
        employer6.setOfficeAdressNumber("42");
        employer6.setOfficeCityLocation("Office City Location");
        employer6.setOfficeZipcode("Office Zipcode");
        employer6.setUser(new User());
        employer6.setVision("Vision");

        JobSeeker jobSeeker6 = new JobSeeker();
        jobSeeker6.setCvs(new ArrayList<>());
        jobSeeker6.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker6.setEmail("jane.doe@example.org");
        jobSeeker6.setFirstName("Jane");
        jobSeeker6.setHomeAddress("42 Main St");
        jobSeeker6.setHouseNumber("42");
        jobSeeker6.setId(1L);
        jobSeeker6.setPhoneNumber("6625550144");
        jobSeeker6.setResidence("Residence");
        jobSeeker6.setSurName("Doe");
        jobSeeker6.setUser(new User());
        jobSeeker6.setZipCode("21654");

        User user5 = new User();
        user5.setEmail("jane.doe@example.org");
        user5.setEmployer(employer6);
        user5.setId(1L);
        user5.setJobSeeker(jobSeeker6);
        user5.setPassword("iloveyou");
        user5.setRole(Role.USER);

        JobSeeker jobSeeker7 = new JobSeeker();
        jobSeeker7.setCvs(new ArrayList<>());
        jobSeeker7.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker7.setEmail("jane.doe@example.org");
        jobSeeker7.setFirstName("Jane");
        jobSeeker7.setHomeAddress("42 Main St");
        jobSeeker7.setHouseNumber("42");
        jobSeeker7.setId(1L);
        jobSeeker7.setPhoneNumber("6625550144");
        jobSeeker7.setResidence("Residence");
        jobSeeker7.setSurName("Doe");
        jobSeeker7.setUser(user5);
        jobSeeker7.setZipCode("21654");

        User user6 = new User();
        user6.setEmail("jane.doe@example.org");
        user6.setEmployer(employer5);
        user6.setId(1L);
        user6.setJobSeeker(jobSeeker7);
        user6.setPassword("iloveyou");
        user6.setRole(Role.USER);

        JobSeeker jobSeeker8 = new JobSeeker();
        jobSeeker8.setCvs(new ArrayList<>());
        jobSeeker8.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker8.setEmail("jane.doe@example.org");
        jobSeeker8.setFirstName("Jane");
        jobSeeker8.setHomeAddress("42 Main St");
        jobSeeker8.setHouseNumber("42");
        jobSeeker8.setId(1L);
        jobSeeker8.setPhoneNumber("6625550144");
        jobSeeker8.setResidence("Residence");
        jobSeeker8.setSurName("Doe");
        jobSeeker8.setUser(user6);
        jobSeeker8.setZipCode("21654");
        assertEquals(jobSeeker4, jobSeeker8);
        int expectedHashCodeResult = jobSeeker4.hashCode();
        assertEquals(expectedHashCodeResult, jobSeeker8.hashCode());
    }
}
