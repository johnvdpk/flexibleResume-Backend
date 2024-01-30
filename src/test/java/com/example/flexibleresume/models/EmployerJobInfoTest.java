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

import org.junit.jupiter.api.Test;

class EmployerJobInfoTest {

    @Test
    void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new EmployerJobInfo()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
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

        EmployerJobInfo employerJobInfo = new EmployerJobInfo();
        employerJobInfo.setEducation("Education");
        employerJobInfo.setEmployer(employer2);
        employerJobInfo.setExtras("Extras");
        employerJobInfo.setId(1L);
        employerJobInfo.setJobDescription("Job Description");
        employerJobInfo.setJobOffer("Job Offer");
        employerJobInfo.setJobRequirements("Job Requirements");
        employerJobInfo.setSalaryIndication("Salary Indication");
        employerJobInfo.setSkill("Skill");
        employerJobInfo.setYearsOfExperience("Years Of Experience");

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
        employer4.setUser(user2);
        employer4.setVision("Vision");

        EmployerJobInfo employerJobInfo2 = new EmployerJobInfo();
        employerJobInfo2.setEducation("Education");
        employerJobInfo2.setEmployer(employer4);
        employerJobInfo2.setExtras("Extras");
        employerJobInfo2.setId(1L);
        employerJobInfo2.setJobDescription("Job Description");
        employerJobInfo2.setJobOffer("Job Offer");
        employerJobInfo2.setJobRequirements("Job Requirements");
        employerJobInfo2.setSalaryIndication("Salary Indication");
        employerJobInfo2.setSkill("Skill");
        employerJobInfo2.setYearsOfExperience("Years Of Experience");

        // Act and Assert
        assertTrue(employerJobInfo.canEqual(employerJobInfo2));
    }

    @Test
    void testConstructor() {
        // Arrange and Act
        EmployerJobInfo actualEmployerJobInfo = new EmployerJobInfo();
        actualEmployerJobInfo.setEducation("Education");
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
        actualEmployerJobInfo.setEmployer(employer2);
        actualEmployerJobInfo.setExtras("Extras");
        actualEmployerJobInfo.setId(1L);
        actualEmployerJobInfo.setJobDescription("Job Description");
        actualEmployerJobInfo.setJobOffer("Job Offer");
        actualEmployerJobInfo.setJobRequirements("Job Requirements");
        actualEmployerJobInfo.setSalaryIndication("Salary Indication");
        actualEmployerJobInfo.setSkill("Skill");
        actualEmployerJobInfo.setYearsOfExperience("Years Of Experience");
        String actualToStringResult = actualEmployerJobInfo.toString();
        String actualEducation = actualEmployerJobInfo.getEducation();
        Employer actualEmployer = actualEmployerJobInfo.getEmployer();
        String actualExtras = actualEmployerJobInfo.getExtras();
        Long actualId = actualEmployerJobInfo.getId();
        String actualJobDescription = actualEmployerJobInfo.getJobDescription();
        String actualJobOffer = actualEmployerJobInfo.getJobOffer();
        String actualJobRequirements = actualEmployerJobInfo.getJobRequirements();
        String actualSalaryIndication = actualEmployerJobInfo.getSalaryIndication();
        String actualSkill = actualEmployerJobInfo.getSkill();

        // Assert that nothing has changed
        assertEquals("Education", actualEducation);
        assertEquals("EmployerJobInfo(id=1, employer=Employer(jobInfos=[], user=User(jobSeeker=JobSeeker(cvs=[], user=User"
                + "(jobSeeker=JobSeeker(cvs=[], user=null, id=null, firstName=null, surName=null, dateOfBirth=null,"
                + " email=null, phoneNumber=null, residence=null, zipCode=null, homeAddress=null, houseNumber=null),"
                + " employer=Employer(jobInfos=[], user=null, id=null, company=null, industry=null, officeAdress=null,"
                + " officeAdressNumber=null, officeZipcode=null, officeCityLocation=null, kvk=null, mission=null,"
                + " vision=null, numberOfEmployees=null), id=1, email=jane.doe@example.org, password=iloveyou, role=USER),"
                + " id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe@example.org, phoneNumber"
                + "=6625550144, residence=Residence, zipCode=21654, homeAddress=42 Main St, houseNumber=42), employer"
                + "=Employer(jobInfos=[], user=User(jobSeeker=JobSeeker(cvs=[], user=null, id=null, firstName=null,"
                + " surName=null, dateOfBirth=null, email=null, phoneNumber=null, residence=null, zipCode=null,"
                + " homeAddress=null, houseNumber=null), employer=Employer(jobInfos=[], user=null, id=null, company=null,"
                + " industry=null, officeAdress=null, officeAdressNumber=null, officeZipcode=null, officeCityLocation=null,"
                + " kvk=null, mission=null, vision=null, numberOfEmployees=null), id=1, email=jane.doe@example.org,"
                + " password=iloveyou, role=USER), id=1, company=Company, industry=Industry, officeAdress=Office Adress,"
                + " officeAdressNumber=42, officeZipcode=Office Zipcode, officeCityLocation=Office City Location, kvk=Kvk,"
                + " mission=Mission, vision=Vision, numberOfEmployees=42), id=1, email=jane.doe@example.org, password=iloveyou,"
                + " role=USER), id=1, company=Company, industry=Industry, officeAdress=Office Adress, officeAdressNumber=42,"
                + " officeZipcode=Office Zipcode, officeCityLocation=Office City Location, kvk=Kvk, mission=Mission,"
                + " vision=Vision, numberOfEmployees=42), jobDescription=Job Description, jobRequirements=Job Requirements,"
                + " skill=Skill, education=Education, yearsOfExperience=Years Of Experience, jobOffer=Job Offer,"
                + " salaryIndication=Salary Indication, extras=Extras)", actualToStringResult);
        assertEquals("Extras", actualExtras);
        assertEquals("Job Description", actualJobDescription);
        assertEquals("Job Offer", actualJobOffer);
        assertEquals("Job Requirements", actualJobRequirements);
        assertEquals("Salary Indication", actualSalaryIndication);
        assertEquals("Skill", actualSkill);
        assertEquals("Years Of Experience", actualEmployerJobInfo.getYearsOfExperience());
        assertEquals(1L, actualId.longValue());
        assertSame(employer2, actualEmployer);
    }

    @Test
    void testConstructor2() {
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

        // Act
        EmployerJobInfo actualEmployerJobInfo = new EmployerJobInfo(1L, employer2, "Job Description", "Job Requirements",
                "Skill", "Education", "Years Of Experience", "Job Offer", "Salary Indication", "Extras");
        actualEmployerJobInfo.setEducation("Education");
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
        actualEmployerJobInfo.setEmployer(employer4);
        actualEmployerJobInfo.setExtras("Extras");
        actualEmployerJobInfo.setId(1L);
        actualEmployerJobInfo.setJobDescription("Job Description");
        actualEmployerJobInfo.setJobOffer("Job Offer");
        actualEmployerJobInfo.setJobRequirements("Job Requirements");
        actualEmployerJobInfo.setSalaryIndication("Salary Indication");
        actualEmployerJobInfo.setSkill("Skill");
        actualEmployerJobInfo.setYearsOfExperience("Years Of Experience");
        String actualToStringResult = actualEmployerJobInfo.toString();
        String actualEducation = actualEmployerJobInfo.getEducation();
        Employer actualEmployer = actualEmployerJobInfo.getEmployer();
        String actualExtras = actualEmployerJobInfo.getExtras();
        Long actualId = actualEmployerJobInfo.getId();
        String actualJobDescription = actualEmployerJobInfo.getJobDescription();
        String actualJobOffer = actualEmployerJobInfo.getJobOffer();
        String actualJobRequirements = actualEmployerJobInfo.getJobRequirements();
        String actualSalaryIndication = actualEmployerJobInfo.getSalaryIndication();
        String actualSkill = actualEmployerJobInfo.getSkill();

        // Assert that nothing has changed
        assertEquals("Education", actualEducation);
        assertEquals("EmployerJobInfo(id=1, employer=Employer(jobInfos=[], user=User(jobSeeker=JobSeeker(cvs=[], user=User"
                + "(jobSeeker=JobSeeker(cvs=[], user=null, id=null, firstName=null, surName=null, dateOfBirth=null,"
                + " email=null, phoneNumber=null, residence=null, zipCode=null, homeAddress=null, houseNumber=null),"
                + " employer=Employer(jobInfos=[], user=null, id=null, company=null, industry=null, officeAdress=null,"
                + " officeAdressNumber=null, officeZipcode=null, officeCityLocation=null, kvk=null, mission=null,"
                + " vision=null, numberOfEmployees=null), id=1, email=jane.doe@example.org, password=iloveyou, role=USER),"
                + " id=1, firstName=Jane, surName=Doe, dateOfBirth=1970-01-01, email=jane.doe@example.org, phoneNumber"
                + "=6625550144, residence=Residence, zipCode=21654, homeAddress=42 Main St, houseNumber=42), employer"
                + "=Employer(jobInfos=[], user=User(jobSeeker=JobSeeker(cvs=[], user=null, id=null, firstName=null,"
                + " surName=null, dateOfBirth=null, email=null, phoneNumber=null, residence=null, zipCode=null,"
                + " homeAddress=null, houseNumber=null), employer=Employer(jobInfos=[], user=null, id=null, company=null,"
                + " industry=null, officeAdress=null, officeAdressNumber=null, officeZipcode=null, officeCityLocation=null,"
                + " kvk=null, mission=null, vision=null, numberOfEmployees=null), id=1, email=jane.doe@example.org,"
                + " password=iloveyou, role=USER), id=1, company=Company, industry=Industry, officeAdress=Office Adress,"
                + " officeAdressNumber=42, officeZipcode=Office Zipcode, officeCityLocation=Office City Location, kvk=Kvk,"
                + " mission=Mission, vision=Vision, numberOfEmployees=42), id=1, email=jane.doe@example.org, password=iloveyou,"
                + " role=USER), id=1, company=Company, industry=Industry, officeAdress=Office Adress, officeAdressNumber=42,"
                + " officeZipcode=Office Zipcode, officeCityLocation=Office City Location, kvk=Kvk, mission=Mission,"
                + " vision=Vision, numberOfEmployees=42), jobDescription=Job Description, jobRequirements=Job Requirements,"
                + " skill=Skill, education=Education, yearsOfExperience=Years Of Experience, jobOffer=Job Offer,"
                + " salaryIndication=Salary Indication, extras=Extras)", actualToStringResult);
        assertEquals("Extras", actualExtras);
        assertEquals("Job Description", actualJobDescription);
        assertEquals("Job Offer", actualJobOffer);
        assertEquals("Job Requirements", actualJobRequirements);
        assertEquals("Salary Indication", actualSalaryIndication);
        assertEquals("Skill", actualSkill);
        assertEquals("Years Of Experience", actualEmployerJobInfo.getYearsOfExperience());
        assertEquals(1L, actualId.longValue());
        assertEquals(employer2, actualEmployer);
        assertSame(employer4, actualEmployer);
    }

    @Test
    void testEquals() {
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

        EmployerJobInfo employerJobInfo = new EmployerJobInfo();
        employerJobInfo.setEducation("Education");
        employerJobInfo.setEmployer(employer2);
        employerJobInfo.setExtras("Extras");
        employerJobInfo.setId(1L);
        employerJobInfo.setJobDescription("Job Description");
        employerJobInfo.setJobOffer("Job Offer");
        employerJobInfo.setJobRequirements("Job Requirements");
        employerJobInfo.setSalaryIndication("Salary Indication");
        employerJobInfo.setSkill("Skill");
        employerJobInfo.setYearsOfExperience("Years Of Experience");

        // Act and Assert
        assertNotEquals(employerJobInfo, null);
    }

    @Test
    void testEquals2() {
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

        EmployerJobInfo employerJobInfo = new EmployerJobInfo();
        employerJobInfo.setEducation("Education");
        employerJobInfo.setEmployer(employer2);
        employerJobInfo.setExtras("Extras");
        employerJobInfo.setId(1L);
        employerJobInfo.setJobDescription("Job Description");
        employerJobInfo.setJobOffer("Job Offer");
        employerJobInfo.setJobRequirements("Job Requirements");
        employerJobInfo.setSalaryIndication("Salary Indication");
        employerJobInfo.setSkill("Skill");
        employerJobInfo.setYearsOfExperience("Years Of Experience");

        // Act and Assert
        assertNotEquals(employerJobInfo, "Different type to EmployerJobInfo");
    }

    @Test
    void testEquals3() {
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

        EmployerJobInfo employerJobInfo = new EmployerJobInfo();
        employerJobInfo.setEducation("Education");
        employerJobInfo.setEmployer(employer2);
        employerJobInfo.setExtras("Extras");
        employerJobInfo.setId(1L);
        employerJobInfo.setJobDescription("Job Description");
        employerJobInfo.setJobOffer("Job Offer");
        employerJobInfo.setJobRequirements("Job Requirements");
        employerJobInfo.setSalaryIndication("Salary Indication");
        employerJobInfo.setSkill("Skill");
        employerJobInfo.setYearsOfExperience("Years Of Experience");

        // Act and Assert
        assertEquals(employerJobInfo, employerJobInfo);
        int expectedHashCodeResult = employerJobInfo.hashCode();
        assertEquals(expectedHashCodeResult, employerJobInfo.hashCode());
    }

    @Test
    void testEquals4() {
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

        EmployerJobInfo employerJobInfo = new EmployerJobInfo();
        employerJobInfo.setEducation("Education");
        employerJobInfo.setEmployer(employer2);
        employerJobInfo.setExtras("Extras");
        employerJobInfo.setId(1L);
        employerJobInfo.setJobDescription("Job Description");
        employerJobInfo.setJobOffer("Job Offer");
        employerJobInfo.setJobRequirements("Job Requirements");
        employerJobInfo.setSalaryIndication("Salary Indication");
        employerJobInfo.setSkill("Skill");
        employerJobInfo.setYearsOfExperience("Years Of Experience");

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

        EmployerJobInfo employerJobInfo2 = new EmployerJobInfo();
        employerJobInfo2.setEducation("Education");
        employerJobInfo2.setEmployer(employer4);
        employerJobInfo2.setExtras("Extras");
        employerJobInfo2.setId(1L);
        employerJobInfo2.setJobDescription("Job Description");
        employerJobInfo2.setJobOffer("Job Offer");
        employerJobInfo2.setJobRequirements("Job Requirements");
        employerJobInfo2.setSalaryIndication("Salary Indication");
        employerJobInfo2.setSkill("Skill");
        employerJobInfo2.setYearsOfExperience("Years Of Experience");

        // Act and Assert
        assertEquals(employerJobInfo, employerJobInfo2);
        int expectedHashCodeResult = employerJobInfo.hashCode();
        assertEquals(expectedHashCodeResult, employerJobInfo2.hashCode());
    }

    @Test
    void testEquals5() {
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

        EmployerJobInfo employerJobInfo = new EmployerJobInfo();
        employerJobInfo.setEducation("jane.doe@example.org");
        employerJobInfo.setEmployer(employer2);
        employerJobInfo.setExtras("Extras");
        employerJobInfo.setId(1L);
        employerJobInfo.setJobDescription("Job Description");
        employerJobInfo.setJobOffer("Job Offer");
        employerJobInfo.setJobRequirements("Job Requirements");
        employerJobInfo.setSalaryIndication("Salary Indication");
        employerJobInfo.setSkill("Skill");
        employerJobInfo.setYearsOfExperience("Years Of Experience");

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

        EmployerJobInfo employerJobInfo2 = new EmployerJobInfo();
        employerJobInfo2.setEducation("Education");
        employerJobInfo2.setEmployer(employer4);
        employerJobInfo2.setExtras("Extras");
        employerJobInfo2.setId(1L);
        employerJobInfo2.setJobDescription("Job Description");
        employerJobInfo2.setJobOffer("Job Offer");
        employerJobInfo2.setJobRequirements("Job Requirements");
        employerJobInfo2.setSalaryIndication("Salary Indication");
        employerJobInfo2.setSkill("Skill");
        employerJobInfo2.setYearsOfExperience("Years Of Experience");

        // Act and Assert
        assertNotEquals(employerJobInfo, employerJobInfo2);
    }

    @Test
    void testEquals6() {
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

        EmployerJobInfo employerJobInfo = new EmployerJobInfo();
        employerJobInfo.setEducation(null);
        employerJobInfo.setEmployer(employer2);
        employerJobInfo.setExtras("Extras");
        employerJobInfo.setId(1L);
        employerJobInfo.setJobDescription("Job Description");
        employerJobInfo.setJobOffer("Job Offer");
        employerJobInfo.setJobRequirements("Job Requirements");
        employerJobInfo.setSalaryIndication("Salary Indication");
        employerJobInfo.setSkill("Skill");
        employerJobInfo.setYearsOfExperience("Years Of Experience");

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

        EmployerJobInfo employerJobInfo2 = new EmployerJobInfo();
        employerJobInfo2.setEducation("Education");
        employerJobInfo2.setEmployer(employer4);
        employerJobInfo2.setExtras("Extras");
        employerJobInfo2.setId(1L);
        employerJobInfo2.setJobDescription("Job Description");
        employerJobInfo2.setJobOffer("Job Offer");
        employerJobInfo2.setJobRequirements("Job Requirements");
        employerJobInfo2.setSalaryIndication("Salary Indication");
        employerJobInfo2.setSkill("Skill");
        employerJobInfo2.setYearsOfExperience("Years Of Experience");

        // Act and Assert
        assertNotEquals(employerJobInfo, employerJobInfo2);
    }

    @Test
    void testEquals7() {
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
        employer2.setCompany("jane.doe@example.org");
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

        EmployerJobInfo employerJobInfo = new EmployerJobInfo();
        employerJobInfo.setEducation("Education");
        employerJobInfo.setEmployer(employer2);
        employerJobInfo.setExtras("Extras");
        employerJobInfo.setId(1L);
        employerJobInfo.setJobDescription("Job Description");
        employerJobInfo.setJobOffer("Job Offer");
        employerJobInfo.setJobRequirements("Job Requirements");
        employerJobInfo.setSalaryIndication("Salary Indication");
        employerJobInfo.setSkill("Skill");
        employerJobInfo.setYearsOfExperience("Years Of Experience");

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

        EmployerJobInfo employerJobInfo2 = new EmployerJobInfo();
        employerJobInfo2.setEducation("Education");
        employerJobInfo2.setEmployer(employer4);
        employerJobInfo2.setExtras("Extras");
        employerJobInfo2.setId(1L);
        employerJobInfo2.setJobDescription("Job Description");
        employerJobInfo2.setJobOffer("Job Offer");
        employerJobInfo2.setJobRequirements("Job Requirements");
        employerJobInfo2.setSalaryIndication("Salary Indication");
        employerJobInfo2.setSkill("Skill");
        employerJobInfo2.setYearsOfExperience("Years Of Experience");

        // Act and Assert
        assertNotEquals(employerJobInfo, employerJobInfo2);
    }
}
