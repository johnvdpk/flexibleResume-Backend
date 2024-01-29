package com.example.flexibleresume.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.flexibleresume.models.Employer;
import com.example.flexibleresume.models.JobSeeker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class UserTest {

    @Test
    void testGetAuthorities() {
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

        // Act
        Collection<? extends GrantedAuthority> actualAuthorities = user3.getAuthorities();

        // Assert
        assertEquals(1, actualAuthorities.size());
        assertEquals("USER", ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }


    @Test
    void testGetPassword() {
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
        jobSeeker3.setUser(user6);
        jobSeeker3.setZipCode("21654");

        User user7 = new User();
        user7.setEmail("jane.doe@example.org");
        user7.setEmployer(employer2);
        user7.setId(1L);
        user7.setJobSeeker(jobSeeker3);
        user7.setPassword("iloveyou");
        user7.setRole(Role.USER);

        // Act
        String actualPassword = user7.getPassword();
        String actualUsername = user7.getUsername();
        boolean actualIsAccountNonExpiredResult = user7.isAccountNonExpired();
        boolean actualIsAccountNonLockedResult = user7.isAccountNonLocked();
        boolean actualIsCredentialsNonExpiredResult = user7.isCredentialsNonExpired();

        // Assert
        assertEquals("iloveyou", actualPassword);
        assertEquals("jane.doe@example.org", actualUsername);
        assertTrue(actualIsAccountNonExpiredResult);
        assertTrue(actualIsAccountNonLockedResult);
        assertTrue(actualIsCredentialsNonExpiredResult);
        assertTrue(user7.isEnabled());
    }
}
