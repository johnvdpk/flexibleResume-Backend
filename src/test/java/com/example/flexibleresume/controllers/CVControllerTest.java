package com.example.flexibleresume.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.flexibleresume.dtos.CVInputDto;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.models.Employer;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.repositorys.JobSeekerRepository;
import com.example.flexibleresume.services.CVService;
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

@ContextConfiguration(classes = {CVController.class, CVService.class})
@ExtendWith(SpringExtension.class)
class CVControllerTest {
    @Autowired
    private CVController cVController;

    @MockBean
    private CVRepository cVRepository;

    @MockBean
    private JobSeekerRepository jobSeekerRepository;


    @Test
    void testDownLoadSingleFile() throws Exception {
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
        when(cVRepository.findByFileName(Mockito.<String>any())).thenReturn(cv);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/cv/download/{fileName}",
                "foo.txt");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cVController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain"))
                .andExpect(MockMvcResultMatchers.content().string("AXAXAXAX"));
    }


    @Test
    void testDownLoadSingleFile2() throws Exception {
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
        cv.setFileName("Content-Disposition");
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());
        when(cVRepository.findByFileName(Mockito.<String>any())).thenReturn(cv);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/cv/download/{fileName}",
                "foo.txt");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cVController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/octet-stream"))
                .andExpect(MockMvcResultMatchers.content().string("AXAXAXAX"));
    }


    @Test
    void testDownLoadSingleFile3() throws Exception {
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
        cv.setFileName(null);
        cv.setId(1L);
        cv.setJobSeeker(jobSeeker2);
        cv.setPersonalInfos(new ArrayList<>());
        cv.setStudyInfos(new ArrayList<>());
        cv.setWorkInfos(new ArrayList<>());
        when(cVRepository.findByFileName(Mockito.<String>any())).thenReturn(cv);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/cv/download/{fileName}",
                "foo.txt");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cVController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/octet-stream"))
                .andExpect(MockMvcResultMatchers.content().string("AXAXAXAX"));
    }


    @Test
    void testGetAllCVs() throws Exception {
        // Arrange
        when(cVRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/cv");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cVController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetAllCVs2() throws Exception {
        // Arrange
        when(cVRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/cv");
        requestBuilder.accept("https://example.org/example");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cVController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(406));
    }


    @Test
    void testGetCVById() throws Exception {
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
        Optional<CV> ofResult = Optional.of(cv);
        when(cVRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/cv/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cVController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"fileName\":null,\"url\":null,\"contentType\":null,\"aboutMe\":\"About Me\",\"workInfos\":null,\"personalInfos\""
                                        + ":null,\"studyInfos\":null}"));
    }

    @Test
    void testUpdateCV() throws Exception {
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
        Optional<CV> ofResult = Optional.of(cv);

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEmployer(new Employer());
        user2.setId(1L);
        user2.setJobSeeker(new JobSeeker());
        user2.setPassword("iloveyou");
        user2.setRole(Role.USER);

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
        employer2.setUser(user2);
        employer2.setVision("Vision");

        User user3 = new User();
        user3.setEmail("jane.doe@example.org");
        user3.setEmployer(new Employer());
        user3.setId(1L);
        user3.setJobSeeker(new JobSeeker());
        user3.setPassword("iloveyou");
        user3.setRole(Role.USER);

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
        jobSeeker3.setUser(user3);
        jobSeeker3.setZipCode("21654");

        User user4 = new User();
        user4.setEmail("jane.doe@example.org");
        user4.setEmployer(employer2);
        user4.setId(1L);
        user4.setJobSeeker(jobSeeker3);
        user4.setPassword("iloveyou");
        user4.setRole(Role.USER);

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
        jobSeeker4.setUser(user4);
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
        when(cVRepository.save(Mockito.<CV>any())).thenReturn(cv2);
        when(cVRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        CVInputDto cvInputDto = new CVInputDto();
        cvInputDto.setAboutMe("About Me");
        cvInputDto.setContentType("text/plain");
        cvInputDto.setFileName("foo.txt");
        cvInputDto.setPersonalInfos(new ArrayList<>());
        cvInputDto.setStudyInfos(new ArrayList<>());
        cvInputDto.setUrl("https://example.org/example");
        cvInputDto.setWorkInfos(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(cvInputDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/jobseeker/cv/cv/{cvId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cVController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"fileName\":null,\"url\":null,\"contentType\":null,\"aboutMe\":\"About Me\",\"workInfos\":null,\"personalInfos\""
                                        + ":null,\"studyInfos\":null}"));
    }
}
