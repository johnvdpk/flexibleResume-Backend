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

class EmployerDiffblueTest {
    /**
     * Method under test: {@link Employer#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new Employer()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Employer#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
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
        employer2.setUser(user3);
        employer2.setVision("Vision");

        User user4 = new User();
        user4.setEmail("jane.doe@example.org");
        user4.setEmployer(new Employer());
        user4.setId(1L);
        user4.setJobSeeker(new JobSeeker());
        user4.setPassword("iloveyou");
        user4.setRole(Role.USER);

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
        employer3.setUser(user4);
        employer3.setVision("Vision");

        User user5 = new User();
        user5.setEmail("jane.doe@example.org");
        user5.setEmployer(new Employer());
        user5.setId(1L);
        user5.setJobSeeker(new JobSeeker());
        user5.setPassword("iloveyou");
        user5.setRole(Role.USER);

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
        jobSeeker2.setUser(user5);
        jobSeeker2.setZipCode("21654");

        User user6 = new User();
        user6.setEmail("jane.doe@example.org");
        user6.setEmployer(employer3);
        user6.setId(1L);
        user6.setJobSeeker(jobSeeker2);
        user6.setPassword("iloveyou");
        user6.setRole(Role.USER);

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
        employer4.setUser(user6);
        employer4.setVision("Vision");

        // Act and Assert
        assertTrue(employer2.canEqual(employer4));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Employer#Employer()}
     *   <li>{@link Employer#setCompany(String)}
     *   <li>{@link Employer#setId(Long)}
     *   <li>{@link Employer#setIndustry(String)}
     *   <li>{@link Employer#setJobInfos(List)}
     *   <li>{@link Employer#setKvk(String)}
     *   <li>{@link Employer#setMission(String)}
     *   <li>{@link Employer#setNumberOfEmployees(String)}
     *   <li>{@link Employer#setOfficeAdress(String)}
     *   <li>{@link Employer#setOfficeAdressNumber(String)}
     *   <li>{@link Employer#setOfficeCityLocation(String)}
     *   <li>{@link Employer#setOfficeZipcode(String)}
     *   <li>{@link Employer#setUser(User)}
     *   <li>{@link Employer#setVision(String)}
     *   <li>{@link Employer#toString()}
     *   <li>{@link Employer#getCompany()}
     *   <li>{@link Employer#getId()}
     *   <li>{@link Employer#getIndustry()}
     *   <li>{@link Employer#getJobInfos()}
     *   <li>{@link Employer#getKvk()}
     *   <li>{@link Employer#getMission()}
     *   <li>{@link Employer#getNumberOfEmployees()}
     *   <li>{@link Employer#getOfficeAdress()}
     *   <li>{@link Employer#getOfficeAdressNumber()}
     *   <li>{@link Employer#getOfficeCityLocation()}
     *   <li>{@link Employer#getOfficeZipcode()}
     *   <li>{@link Employer#getUser()}
     *   <li>{@link Employer#getVision()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        Employer actualEmployer = new Employer();
        actualEmployer.setCompany("Company");
        actualEmployer.setId(1L);
        actualEmployer.setIndustry("Industry");
        ArrayList<EmployerJobInfo> jobInfos = new ArrayList<>();
        actualEmployer.setJobInfos(jobInfos);
        actualEmployer.setKvk("Kvk");
        actualEmployer.setMission("Mission");
        actualEmployer.setNumberOfEmployees("42");
        actualEmployer.setOfficeAdress("Office Adress");
        actualEmployer.setOfficeAdressNumber("42");
        actualEmployer.setOfficeCityLocation("Office City Location");
        actualEmployer.setOfficeZipcode("Office Zipcode");
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
        actualEmployer.setUser(user3);
        actualEmployer.setVision("Vision");
        String actualToStringResult = actualEmployer.toString();
        String actualCompany = actualEmployer.getCompany();
        Long actualId = actualEmployer.getId();
        String actualIndustry = actualEmployer.getIndustry();
        List<EmployerJobInfo> actualJobInfos = actualEmployer.getJobInfos();
        String actualKvk = actualEmployer.getKvk();
        String actualMission = actualEmployer.getMission();
        String actualNumberOfEmployees = actualEmployer.getNumberOfEmployees();
        String actualOfficeAdress = actualEmployer.getOfficeAdress();
        String actualOfficeAdressNumber = actualEmployer.getOfficeAdressNumber();
        String actualOfficeCityLocation = actualEmployer.getOfficeCityLocation();
        String actualOfficeZipcode = actualEmployer.getOfficeZipcode();
        User actualUser = actualEmployer.getUser();

        // Assert that nothing has changed
        assertEquals("42", actualNumberOfEmployees);
        assertEquals("42", actualOfficeAdressNumber);
        assertEquals("Company", actualCompany);
        assertEquals("Employer(jobInfos=[], user=User(jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=JobSeeker(cvs=[],"
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
                + " role=USER), id=1, company=Company, industry=Industry, officeAdress=Office Adress, officeAdressNumber=42,"
                + " officeZipcode=Office Zipcode, officeCityLocation=Office City Location, kvk=Kvk, mission=Mission,"
                + " vision=Vision, numberOfEmployees=42)", actualToStringResult);
        assertEquals("Industry", actualIndustry);
        assertEquals("Kvk", actualKvk);
        assertEquals("Mission", actualMission);
        assertEquals("Office Adress", actualOfficeAdress);
        assertEquals("Office City Location", actualOfficeCityLocation);
        assertEquals("Office Zipcode", actualOfficeZipcode);
        assertEquals("Vision", actualEmployer.getVision());
        assertEquals(1L, actualId.longValue());
        assertSame(user3, actualUser);
        assertSame(jobInfos, actualJobInfos);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link Employer#Employer(List, User, Long, String, String, String, String, String, String, String, String, String, String)}
     *   <li>{@link Employer#Employer()}
     *   <li>{@link Employer#setCompany(String)}
     *   <li>{@link Employer#setId(Long)}
     *   <li>{@link Employer#setIndustry(String)}
     *   <li>{@link Employer#setJobInfos(List)}
     *   <li>{@link Employer#setKvk(String)}
     *   <li>{@link Employer#setMission(String)}
     *   <li>{@link Employer#setNumberOfEmployees(String)}
     *   <li>{@link Employer#setOfficeAdress(String)}
     *   <li>{@link Employer#setOfficeAdressNumber(String)}
     *   <li>{@link Employer#setOfficeCityLocation(String)}
     *   <li>{@link Employer#setOfficeZipcode(String)}
     *   <li>{@link Employer#setUser(User)}
     *   <li>{@link Employer#setVision(String)}
     *   <li>{@link Employer#toString()}
     *   <li>{@link Employer#getCompany()}
     *   <li>{@link Employer#getId()}
     *   <li>{@link Employer#getIndustry()}
     *   <li>{@link Employer#getJobInfos()}
     *   <li>{@link Employer#getKvk()}
     *   <li>{@link Employer#getMission()}
     *   <li>{@link Employer#getNumberOfEmployees()}
     *   <li>{@link Employer#getOfficeAdress()}
     *   <li>{@link Employer#getOfficeAdressNumber()}
     *   <li>{@link Employer#getOfficeCityLocation()}
     *   <li>{@link Employer#getOfficeZipcode()}
     *   <li>{@link Employer#getUser()}
     *   <li>{@link Employer#getVision()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        // Arrange
        ArrayList<EmployerJobInfo> jobInfos = new ArrayList<>();

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

        // Act
        Employer actualEmployer = new Employer(jobInfos, user3, 1L, "Company", "Industry", "Office Adress", "42",
                "Office Zipcode", "Office City Location", "Kvk", "Mission", "Vision", "42");
        actualEmployer.setCompany("Company");
        actualEmployer.setId(1L);
        actualEmployer.setIndustry("Industry");
        ArrayList<EmployerJobInfo> jobInfos2 = new ArrayList<>();
        actualEmployer.setJobInfos(jobInfos2);
        actualEmployer.setKvk("Kvk");
        actualEmployer.setMission("Mission");
        actualEmployer.setNumberOfEmployees("42");
        actualEmployer.setOfficeAdress("Office Adress");
        actualEmployer.setOfficeAdressNumber("42");
        actualEmployer.setOfficeCityLocation("Office City Location");
        actualEmployer.setOfficeZipcode("Office Zipcode");
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
        actualEmployer.setUser(user6);
        actualEmployer.setVision("Vision");
        String actualToStringResult = actualEmployer.toString();
        String actualCompany = actualEmployer.getCompany();
        Long actualId = actualEmployer.getId();
        String actualIndustry = actualEmployer.getIndustry();
        List<EmployerJobInfo> actualJobInfos = actualEmployer.getJobInfos();
        String actualKvk = actualEmployer.getKvk();
        String actualMission = actualEmployer.getMission();
        String actualNumberOfEmployees = actualEmployer.getNumberOfEmployees();
        String actualOfficeAdress = actualEmployer.getOfficeAdress();
        String actualOfficeAdressNumber = actualEmployer.getOfficeAdressNumber();
        String actualOfficeCityLocation = actualEmployer.getOfficeCityLocation();
        String actualOfficeZipcode = actualEmployer.getOfficeZipcode();
        User actualUser = actualEmployer.getUser();

        // Assert that nothing has changed
        assertEquals("42", actualNumberOfEmployees);
        assertEquals("42", actualOfficeAdressNumber);
        assertEquals("Company", actualCompany);
        assertEquals("Employer(jobInfos=[], user=User(jobSeeker=JobSeeker(cvs=[], user=User(jobSeeker=JobSeeker(cvs=[],"
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
                + " role=USER), id=1, company=Company, industry=Industry, officeAdress=Office Adress, officeAdressNumber=42,"
                + " officeZipcode=Office Zipcode, officeCityLocation=Office City Location, kvk=Kvk, mission=Mission,"
                + " vision=Vision, numberOfEmployees=42)", actualToStringResult);
        assertEquals("Industry", actualIndustry);
        assertEquals("Kvk", actualKvk);
        assertEquals("Mission", actualMission);
        assertEquals("Office Adress", actualOfficeAdress);
        assertEquals("Office City Location", actualOfficeCityLocation);
        assertEquals("Office Zipcode", actualOfficeZipcode);
        assertEquals("Vision", actualEmployer.getVision());
        assertEquals(1L, actualId.longValue());
        assertEquals(user3, actualUser);
        assertEquals(jobInfos, actualJobInfos);
        assertSame(user6, actualUser);
        assertSame(jobInfos2, actualJobInfos);
    }

    /**
     * Method under test: {@link Employer#equals(Object)}
     */
    @Test
    void testEquals() {
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
        employer4.setUser(user3);
        employer4.setVision("Vision");

        // Act and Assert
        assertNotEquals(employer4, null);
    }

    /**
     * Method under test: {@link Employer#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        employer4.setUser(user3);
        employer4.setVision("Vision");

        // Act and Assert
        assertNotEquals(employer4, "Different type to Employer");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Employer#equals(Object)}
     *   <li>{@link Employer#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        employer4.setUser(user3);
        employer4.setVision("Vision");

        // Act and Assert
        assertEquals(employer4, employer4);
        int expectedHashCodeResult = employer4.hashCode();
        assertEquals(expectedHashCodeResult, employer4.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Employer#equals(Object)}
     *   <li>{@link Employer#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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
        employer4.setUser(user3);
        employer4.setVision("Vision");

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
        employer5.setUser(new User());
        employer5.setVision("Vision");

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
        user4.setEmployer(employer5);
        user4.setId(1L);
        user4.setJobSeeker(jobSeeker4);
        user4.setPassword("iloveyou");
        user4.setRole(Role.USER);

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
        employer6.setUser(user4);
        employer6.setVision("Vision");

        Employer employer7 = new Employer();
        employer7.setCompany("Company");
        employer7.setId(1L);
        employer7.setIndustry("Industry");
        employer7.setJobInfos(new ArrayList<>());
        employer7.setKvk("Kvk");
        employer7.setMission("Mission");
        employer7.setNumberOfEmployees("42");
        employer7.setOfficeAdress("Office Adress");
        employer7.setOfficeAdressNumber("42");
        employer7.setOfficeCityLocation("Office City Location");
        employer7.setOfficeZipcode("Office Zipcode");
        employer7.setUser(new User());
        employer7.setVision("Vision");

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
        user5.setEmployer(employer7);
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
        user6.setEmployer(employer6);
        user6.setId(1L);
        user6.setJobSeeker(jobSeeker6);
        user6.setPassword("iloveyou");
        user6.setRole(Role.USER);

        Employer employer8 = new Employer();
        employer8.setCompany("Company");
        employer8.setId(1L);
        employer8.setIndustry("Industry");
        employer8.setJobInfos(new ArrayList<>());
        employer8.setKvk("Kvk");
        employer8.setMission("Mission");
        employer8.setNumberOfEmployees("42");
        employer8.setOfficeAdress("Office Adress");
        employer8.setOfficeAdressNumber("42");
        employer8.setOfficeCityLocation("Office City Location");
        employer8.setOfficeZipcode("Office Zipcode");
        employer8.setUser(user6);
        employer8.setVision("Vision");

        // Act and Assert
        assertEquals(employer4, employer8);
        int expectedHashCodeResult = employer4.hashCode();
        assertEquals(expectedHashCodeResult, employer8.hashCode());
    }
}
