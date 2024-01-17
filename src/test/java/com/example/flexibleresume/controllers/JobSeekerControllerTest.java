package com.example.flexibleresume.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.models.Employer;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.repositorys.JobSeekerRepository;
import com.example.flexibleresume.repositorys.UserRepository;
import com.example.flexibleresume.services.JobSeekerService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {JobSeekerController.class})
@ExtendWith(SpringExtension.class)
class JobSeekerControllerTest {
  @Autowired
  private JobSeekerController jobSeekerController;

  @MockBean
  private JobSeekerService jobSeekerService;

  @Test
  void testGetAllJobSeekers() throws Exception {
    when(jobSeekerService.getAllJobSeekers()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/name");
    MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  @Test
  void testGetAllJobSeekers2() throws Exception {
    when(jobSeekerService.getAllJobSeekersBySurName(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(jobSeekerService.getAllJobSeekers()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/name")
            .param("surName", "foo");
    MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  @Test
  void testGetJobSeekerByFirstName() throws Exception {
    when(jobSeekerService.getJobSeekerByFirstName(Mockito.<String>any())).thenReturn(new JobSeekerDto());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/firstname/{firstName}",
            "Jane");
    MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"firstName\":null,\"surName\":null,\"dateOfBirth\":null,\"email\":null,\"phoneNumber\":null,\"residence\":null"
                                    + ",\"zipCode\":null,\"homeAddress\":null,\"houseNumber\":null}"));
  }

  @Test
  void testGetJobSeekerByFirstName2() throws Exception {
    when(jobSeekerService.getJobSeekerByFirstName(Mockito.<String>any())).thenReturn(null);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/firstname/{firstName}",
            "Jane");
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  void testGetJobSeekerBySurName() throws Exception {
    when(jobSeekerService.getJobSeekerBySurName(Mockito.<String>any())).thenReturn(new JobSeekerDto());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/surname/{surName}", "Doe");
    MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"firstName\":null,\"surName\":null,\"dateOfBirth\":null,\"email\":null,\"phoneNumber\":null,\"residence\":null"
                                    + ",\"zipCode\":null,\"homeAddress\":null,\"houseNumber\":null}"));
  }

  @Test
  void testGetJobSeekerBySurName2() throws Exception {
    when(jobSeekerService.getJobSeekerBySurName(Mockito.<String>any())).thenReturn(null);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/surname/{surName}", "Doe");
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  void testAddJobSeeker() {


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
    JobSeekerRepository jobSeekerRepos = mock(JobSeekerRepository.class);
    when(jobSeekerRepos.save(Mockito.<JobSeeker>any())).thenReturn(jobSeeker4);
    JobSeekerController jobSeekerController = new JobSeekerController(
            new JobSeekerService(jobSeekerRepos, mock(UserRepository.class), mock(CVRepository.class)));
    ResponseEntity<JobSeekerDto> actualAddJobSeekerResult = jobSeekerController.addJobSeeker(new JobSeekerInputDto());
    verify(jobSeekerRepos).save(Mockito.<JobSeeker>any());
    JobSeekerDto body = actualAddJobSeekerResult.getBody();
    assertNull(body.getEmail());
    assertNull(body.getFirstName());
    assertNull(body.getHomeAddress());
    assertNull(body.getHouseNumber());
    assertNull(body.getPhoneNumber());
    assertNull(body.getResidence());
    assertNull(body.getSurName());
    assertNull(body.getZipCode());
    assertNull(body.getDateOfBirth());
    assertEquals(201, actualAddJobSeekerResult.getStatusCodeValue());
    assertTrue(actualAddJobSeekerResult.hasBody());
    assertTrue(actualAddJobSeekerResult.getHeaders().isEmpty());
  }


  @Test
  void testUpdateJobSeeker() throws Exception {
    when(jobSeekerService.updateJobSeeker(Mockito.<String>any(), Mockito.<JobSeekerInputDto>any()))
            .thenReturn(new JobSeekerDto());

    JobSeekerInputDto jobSeekerInputDto = new JobSeekerInputDto();
    jobSeekerInputDto.setDateOfBirth(null);
    jobSeekerInputDto.setEmail("jane.doe@example.org");
    jobSeekerInputDto.setFirstName("Jane");
    jobSeekerInputDto.setHomeAddress("42 Main St");
    jobSeekerInputDto.setHouseNumber("42");
    jobSeekerInputDto.setPhoneNumber("6625550144");
    jobSeekerInputDto.setResidence("Residence");
    jobSeekerInputDto.setSurName("Doe");
    jobSeekerInputDto.setZipCode("21654");
    String content = (new ObjectMapper()).writeValueAsString(jobSeekerInputDto);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
            .put("/jobseeker/email/{email}", "jane.doe@example.org")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);
    MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"firstName\":null,\"surName\":null,\"dateOfBirth\":null,\"email\":null,\"phoneNumber\":null,\"residence\":null"
                                    + ",\"zipCode\":null,\"homeAddress\":null,\"houseNumber\":null}"));
  }


  @Test
  void testUpdateJobSeeker2() throws Exception {
    when(jobSeekerService.updateJobSeeker(Mockito.<String>any(), Mockito.<JobSeekerInputDto>any())).thenReturn(null);

    JobSeekerInputDto jobSeekerInputDto = new JobSeekerInputDto();
    jobSeekerInputDto.setDateOfBirth(null);
    jobSeekerInputDto.setEmail("jane.doe@example.org");
    jobSeekerInputDto.setFirstName("Jane");
    jobSeekerInputDto.setHomeAddress("42 Main St");
    jobSeekerInputDto.setHouseNumber("42");
    jobSeekerInputDto.setPhoneNumber("6625550144");
    jobSeekerInputDto.setResidence("Residence");
    jobSeekerInputDto.setSurName("Doe");
    jobSeekerInputDto.setZipCode("21654");
    String content = (new ObjectMapper()).writeValueAsString(jobSeekerInputDto);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
            .put("/jobseeker/email/{email}", "jane.doe@example.org")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
  }


  @Test
  void testGetJobSeekerByEmail() throws Exception {
    when(jobSeekerService.getJobSeekerByEmail(Mockito.<String>any())).thenReturn(new JobSeekerDto());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/email/{email}",
            "jane.doe@example.org");
    MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"firstName\":null,\"surName\":null,\"dateOfBirth\":null,\"email\":null,\"phoneNumber\":null,\"residence\":null"
                                    + ",\"zipCode\":null,\"homeAddress\":null,\"houseNumber\":null}"));
  }


  @Test
  void testGetJobSeekerByEmail2() throws Exception {
    when(jobSeekerService.getJobSeekerByEmail(Mockito.<String>any())).thenReturn(null);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobseeker/email/{email}",
            "jane.doe@example.org");
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
  }


  @Test
  void testDeleteJobSeeker() throws Exception {
    doNothing().when(jobSeekerService).deleteJobSeeker(Mockito.<Long>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/jobseeker/{id}", 1L);
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
  }


  @Test
  void testDeleteJobSeeker2() throws Exception {
    doNothing().when(jobSeekerService).deleteJobSeeker(Mockito.<Long>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/jobseeker/{id}", 1L);
    requestBuilder.contentType("https://example.org/example");
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(jobSeekerController)
            .build()
            .perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
  }
}
