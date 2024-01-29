package com.example.flexibleresume.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.flexibleresume.dtos.PersonalInfoInputDto;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.models.Employer;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.models.PersonalInfo;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.repositorys.PersonalInfoRepository;
import com.example.flexibleresume.services.PersonalInfoService;
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

@ContextConfiguration(classes = {PersonalInfoController.class, PersonalInfoService.class})
@ExtendWith(SpringExtension.class)
class PersonalInfoControllerTest {
    @MockBean
    private CVRepository cVRepository;

    @Autowired
    private PersonalInfoController personalInfoController;

    @MockBean
    private PersonalInfoRepository personalInfoRepository;

    @Test
    void testCreatePersonalInfo() throws Exception {
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

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setCv(cv);
        personalInfo.setHobby("Hobby");
        personalInfo.setHobbyInfo("Hobby Info");
        personalInfo.setId(1L);
        personalInfo.setPeriodOfHobby("Period Of Hobby");
        when(personalInfoRepository.save(Mockito.<PersonalInfo>any())).thenReturn(personalInfo);

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
        Optional<CV> ofResult = Optional.of(cv2);
        when(cVRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        PersonalInfoInputDto personalInfoInputDto = new PersonalInfoInputDto();
        personalInfoInputDto.setCvId(1L);
        personalInfoInputDto.setHobby("Hobby");
        personalInfoInputDto.setHobbyInfo("Hobby Info");
        personalInfoInputDto.setId(1L);
        personalInfoInputDto.setPeriodOfHobby("Period Of Hobby");
        String content = (new ObjectMapper()).writeValueAsString(personalInfoInputDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/jobseeker/personalinfo/{cvId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(personalInfoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"cvId\":1,\"id\":1,\"hobby\":\"Hobby\",\"periodOfHobby\":\"Period Of Hobby\",\"hobbyInfo\":\"Hobby Info\"}"));
    }


    @Test
    void testDeletePersonalInfo() throws Exception {
        // Arrange
        doNothing().when(personalInfoRepository).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/jobseeker/personalinfo/{id}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(personalInfoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }


    @Test
    void testDeletePersonalInfo2() throws Exception {
        // Arrange
        doNothing().when(personalInfoRepository).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/jobseeker/personalinfo/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(personalInfoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }


    @Test
    void testGetAllPersonalInfos() throws Exception {
        // Arrange
        when(personalInfoRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/personalinfo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(personalInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetAllPersonalInfos2() throws Exception {
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

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setCv(cv);
        personalInfo.setHobby("Hobby");
        personalInfo.setHobbyInfo("Hobby Info");
        personalInfo.setId(1L);
        personalInfo.setPeriodOfHobby("Period Of Hobby");

        ArrayList<PersonalInfo> personalInfoList = new ArrayList<>();
        personalInfoList.add(personalInfo);
        when(personalInfoRepository.findAll()).thenReturn(personalInfoList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/personalinfo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(personalInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"cvId\":1,\"id\":1,\"hobby\":\"Hobby\",\"periodOfHobby\":\"Period Of Hobby\",\"hobbyInfo\":\"Hobby Info\"}]"));
    }


    @Test
    void testGetAllPersonalInfos3() throws Exception {
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

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setCv(cv);
        personalInfo.setHobby("Hobby");
        personalInfo.setHobbyInfo("Hobby Info");
        personalInfo.setId(1L);
        personalInfo.setPeriodOfHobby("Period Of Hobby");

        User user2 = new User();
        user2.setEmail("john.smith@example.org");
        user2.setEmployer(new Employer());
        user2.setId(2L);
        user2.setJobSeeker(new JobSeeker());
        user2.setPassword("Password");
        user2.setRole(Role.ADMIN);

        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("john.smith@example.org");
        jobSeeker2.setFirstName("John");
        jobSeeker2.setHomeAddress("17 High St");
        jobSeeker2.setHouseNumber("House Number");
        jobSeeker2.setId(2L);
        jobSeeker2.setPhoneNumber("8605550118");
        jobSeeker2.setResidence("com.example.flexibleresume.models.JobSeeker");
        jobSeeker2.setSurName("Sur Name");
        jobSeeker2.setUser(user2);
        jobSeeker2.setZipCode("OX1 1PT");

        CV cv2 = new CV();
        cv2.setAboutMe("com.example.flexibleresume.models.CV");
        cv2.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv2.setFileName("File Name");
        cv2.setId(2L);
        cv2.setJobSeeker(jobSeeker2);
        cv2.setPersonalInfos(new ArrayList<>());
        cv2.setStudyInfos(new ArrayList<>());
        cv2.setWorkInfos(new ArrayList<>());

        PersonalInfo personalInfo2 = new PersonalInfo();
        personalInfo2.setCv(cv2);
        personalInfo2.setHobby("com.example.flexibleresume.models.PersonalInfo");
        personalInfo2.setHobbyInfo("com.example.flexibleresume.models.PersonalInfo");
        personalInfo2.setId(2L);
        personalInfo2.setPeriodOfHobby("com.example.flexibleresume.models.PersonalInfo");

        ArrayList<PersonalInfo> personalInfoList = new ArrayList<>();
        personalInfoList.add(personalInfo2);
        personalInfoList.add(personalInfo);
        when(personalInfoRepository.findAll()).thenReturn(personalInfoList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/personalinfo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(personalInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"cvId\":2,\"id\":2,\"hobby\":\"com.example.flexibleresume.models.PersonalInfo\",\"periodOfHobby\":\"com.example"
                                        + ".flexibleresume.models.PersonalInfo\",\"hobbyInfo\":\"com.example.flexibleresume.models.PersonalInfo\"},{"
                                        + "\"cvId\":1,\"id\":1,\"hobby\":\"Hobby\",\"periodOfHobby\":\"Period Of Hobby\",\"hobbyInfo\":\"Hobby Info\"}]"));
    }


    @Test
    void testGetPersonalInfoByCvId() throws Exception {
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
        cv.setDocFile(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setCv(cv);
        personalInfo.setHobby("Hobby");
        personalInfo.setHobbyInfo("Hobby Info");
        personalInfo.setId(1L);
        personalInfo.setPeriodOfHobby("Period Of Hobby");

        ArrayList<PersonalInfo> personalInfoList = new ArrayList<>();
        personalInfoList.add(personalInfo);
        when(personalInfoRepository.findByCvId(Mockito.<Long>any())).thenReturn(personalInfoList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/personalinfo/{cvId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(personalInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"cvId\":1,\"id\":1,\"hobby\":\"Hobby\",\"periodOfHobby\":\"Period Of Hobby\",\"hobbyInfo\":\"Hobby Info\"}]"));
    }


    @Test
    void testGetPersonalInfoByCvId2() throws Exception {
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
        cv.setDocFile(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        cv.setFileName("foo.txt");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setCv(cv);
        personalInfo.setHobby("Hobby");
        personalInfo.setHobbyInfo("Hobby Info");
        personalInfo.setId(1L);
        personalInfo.setPeriodOfHobby("Period Of Hobby");

        User user2 = new User();
        user2.setEmail("john.smith@example.org");
        user2.setEmployer(new Employer());
        user2.setId(2L);
        user2.setJobSeeker(new JobSeeker());
        user2.setPassword("Password");
        user2.setRole(Role.ADMIN);

        JobSeeker jobSeeker2 = new JobSeeker();
        jobSeeker2.setCvs(new ArrayList<>());
        jobSeeker2.setDateOfBirth(LocalDate.of(1970, 1, 1));
        jobSeeker2.setEmail("john.smith@example.org");
        jobSeeker2.setFirstName("John");
        jobSeeker2.setHomeAddress("17 High St");
        jobSeeker2.setHouseNumber("House Number");
        jobSeeker2.setId(2L);
        jobSeeker2.setPhoneNumber("8605550118");
        jobSeeker2.setResidence("com.example.flexibleresume.models.JobSeeker");
        jobSeeker2.setSurName("Sur Name");
        jobSeeker2.setUser(user2);
        jobSeeker2.setZipCode("OX1 1PT");

        CV cv2 = new CV();
        cv2.setAboutMe("com.example.flexibleresume.models.CV");
        cv2.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv2.setFileName("File Name");
        cv2.setId(2L);
        cv2.setJobSeeker(jobSeeker2);
        cv2.setPersonalInfos(new ArrayList<>());
        cv2.setStudyInfos(new ArrayList<>());
        cv2.setWorkInfos(new ArrayList<>());

        PersonalInfo personalInfo2 = new PersonalInfo();
        personalInfo2.setCv(cv2);
        personalInfo2.setHobby("com.example.flexibleresume.models.PersonalInfo");
        personalInfo2.setHobbyInfo("com.example.flexibleresume.models.PersonalInfo");
        personalInfo2.setId(2L);
        personalInfo2.setPeriodOfHobby("com.example.flexibleresume.models.PersonalInfo");

        ArrayList<PersonalInfo> personalInfoList = new ArrayList<>();
        personalInfoList.add(personalInfo2);
        personalInfoList.add(personalInfo);
        when(personalInfoRepository.findByCvId(Mockito.<Long>any())).thenReturn(personalInfoList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/personalinfo/{cvId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(personalInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"cvId\":2,\"id\":2,\"hobby\":\"com.example.flexibleresume.models.PersonalInfo\",\"periodOfHobby\":\"com.example"
                                        + ".flexibleresume.models.PersonalInfo\",\"hobbyInfo\":\"com.example.flexibleresume.models.PersonalInfo\"},{"
                                        + "\"cvId\":1,\"id\":1,\"hobby\":\"Hobby\",\"periodOfHobby\":\"Period Of Hobby\",\"hobbyInfo\":\"Hobby Info\"}]"));
    }


    @Test
    void testUpdatePersonalInfo() throws Exception {
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

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setCv(cv);
        personalInfo.setHobby("Hobby");
        personalInfo.setHobbyInfo("Hobby Info");
        personalInfo.setId(1L);
        personalInfo.setPeriodOfHobby("Period Of Hobby");
        Optional<PersonalInfo> ofResult = Optional.of(personalInfo);

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
        user2.setEmployer(employer);
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

        CV cv2 = new CV();
        cv2.setAboutMe("About Me");
        cv2.setDocFile("AXAXAXAX".getBytes("UTF-8"));
        cv2.setFileName("foo.txt");
        cv2.setId(1L);
        cv2.setJobSeeker(jobSeeker3);
        cv2.setPersonalInfos(new ArrayList<>());
        cv2.setStudyInfos(new ArrayList<>());
        cv2.setWorkInfos(new ArrayList<>());

        PersonalInfo personalInfo2 = new PersonalInfo();
        personalInfo2.setCv(cv2);
        personalInfo2.setHobby("Hobby");
        personalInfo2.setHobbyInfo("Hobby Info");
        personalInfo2.setId(1L);
        personalInfo2.setPeriodOfHobby("Period Of Hobby");
        when(personalInfoRepository.save(Mockito.<PersonalInfo>any())).thenReturn(personalInfo2);
        when(personalInfoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        PersonalInfoInputDto personalInfoInputDto = new PersonalInfoInputDto();
        personalInfoInputDto.setCvId(1L);
        personalInfoInputDto.setHobby("Hobby");
        personalInfoInputDto.setHobbyInfo("Hobby Info");
        personalInfoInputDto.setId(1L);
        personalInfoInputDto.setPeriodOfHobby("Period Of Hobby");
        String content = (new ObjectMapper()).writeValueAsString(personalInfoInputDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/jobseeker/personalinfo/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(personalInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"cvId\":1,\"id\":1,\"hobby\":\"Hobby\",\"periodOfHobby\":\"Period Of Hobby\",\"hobbyInfo\":\"Hobby Info\"}"));
    }
}
