package com.example.flexibleresume.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.flexibleresume.dtos.EmployerInputDto;
import com.example.flexibleresume.models.Employer;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.EmployerRepository;
import com.example.flexibleresume.repositorys.UserRepository;
import com.example.flexibleresume.services.EmployerService;
import com.example.flexibleresume.user.Role;
import com.example.flexibleresume.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployerController.class, EmployerService.class})
@ExtendWith(SpringExtension.class)
class EmployerControllerTest {
    @Autowired
    private EmployerController employerController;

    @MockBean
    private EmployerRepository employerRepository;

    @MockBean
    private UserRepository userRepository;


    @Test
    void testAddEmployer() throws Exception {
        // Arrange
        EmployerInputDto employerInputDto = new EmployerInputDto();
        employerInputDto.setCompany("Company");
        employerInputDto.setIndustry("Industry");
        employerInputDto.setKvk("Kvk");
        employerInputDto.setMission("Mission");
        employerInputDto.setNumberOfEmployees("42");
        employerInputDto.setOfficeAdress("Office Adress");
        employerInputDto.setOfficeAdressNumber("42");
        employerInputDto.setOfficeCityLocation("Office City Location");
        employerInputDto.setOfficeZipcode("Office Zipcode");
        employerInputDto.setVision("Vision");
        String content = (new ObjectMapper()).writeValueAsString(employerInputDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(employerController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }


    @Test
    void testDeleteEmployer() throws Exception {
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
        Optional<Employer> ofResult = Optional.of(employer2);
        when(employerRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        doNothing().when(employerRepository).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/employer/{id}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(employerController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    void testGetEmployerById() throws Exception {
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
        Optional<Employer> ofResult = Optional.of(employer2);
        when(employerRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employer/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(employerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"company\":\"Company\",\"industry\":\"Industry\",\"officeAdress\":\"Office Adress\",\"officeAdressNumber\":\"42\","
                                        + "\"officeZipcode\":\"Office Zipcode\",\"officeCityLocation\":\"Office City Location\",\"kvk\":\"Kvk\",\"mission\":"
                                        + "\"Mission\",\"vision\":\"Vision\",\"numberOfEmployees\":\"42\"}"));
    }


    @Test
    void testGetJobSeekerByEmail() throws Exception {
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
        Optional<User> ofResult = Optional.of(user3);
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employer/email/{email}",
                "jane.doe@example.org");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(employerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"company\":\"Company\",\"industry\":\"Industry\",\"officeAdress\":\"Office Adress\",\"officeAdressNumber\":\"42\","
                                        + "\"officeZipcode\":\"Office Zipcode\",\"officeCityLocation\":\"Office City Location\",\"kvk\":\"Kvk\",\"mission\":"
                                        + "\"Mission\",\"vision\":\"Vision\",\"numberOfEmployees\":\"42\"}"));
    }


    @Test
    void testUpdateEmployer() throws Exception {
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
        when(employerRepository.save(Mockito.<Employer>any())).thenReturn(employer4);

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
        Optional<User> ofResult = Optional.of(user6);
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);

        EmployerInputDto employerInputDto = new EmployerInputDto();
        employerInputDto.setCompany("Company");
        employerInputDto.setIndustry("Industry");
        employerInputDto.setKvk("Kvk");
        employerInputDto.setMission("Mission");
        employerInputDto.setNumberOfEmployees("42");
        employerInputDto.setOfficeAdress("Office Adress");
        employerInputDto.setOfficeAdressNumber("42");
        employerInputDto.setOfficeCityLocation("Office City Location");
        employerInputDto.setOfficeZipcode("Office Zipcode");
        employerInputDto.setVision("Vision");
        String content = (new ObjectMapper()).writeValueAsString(employerInputDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/employer/email/{email}", "jane.doe@example.org")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(employerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"company\":\"Company\",\"industry\":\"Industry\",\"officeAdress\":\"Office Adress\",\"officeAdressNumber\":\"42\","
                                        + "\"officeZipcode\":\"Office Zipcode\",\"officeCityLocation\":\"Office City Location\",\"kvk\":\"Kvk\",\"mission\":"
                                        + "\"Mission\",\"vision\":\"Vision\",\"numberOfEmployees\":\"42\"}"));
    }
}
