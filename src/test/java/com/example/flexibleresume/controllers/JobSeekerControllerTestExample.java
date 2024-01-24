//package com.example.flexibleresume.controllers;
//
//import com.example.flexibleresume.config.JwtService;
//import com.example.flexibleresume.config.SecurityConfigTest;
//import com.example.flexibleresume.dtos.JobSeekerDto;
//import com.example.flexibleresume.dtos.JobSeekerInputDto;
//import com.example.flexibleresume.services.JobSeekerService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.Test;
//
//
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(JobSeekerController.class)
//@Import(SecurityConfigTest.class)
//public class JobSeekerControllerTestExample {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private JobSeekerService jobSeekerService;
//
//    @MockBean
//    private JwtService jwtService;
//
//
//    @Test
//    public void getJobSeekerByFirstNameTest() throws Exception {
//        JobSeekerDto jobSeekerDto = new JobSeekerDto();
//        jobSeekerDto.setFirstName("John");
//        jobSeekerDto.setSurName("Doe");
//        jobSeekerDto.setEmail("john.doe@example.com");
//        // Voeg hier andere relevante velden toe
//
//        String firstName = "John";
//        when(jobSeekerService.getJobSeekerByFirstName(firstName)).thenReturn(jobSeekerDto);
//
//        mockMvc.perform(get("/jobseeker/firstname/" + firstName))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName", is("John")))
//                .andExpect(jsonPath("$.surName", is("Doe")))
//                .andExpect(jsonPath("$.email", is("john.doe@example.com")));
//
//    }
//
//    @Test
//    public void getJobSeekerBySurNameTest() throws Exception {
//        JobSeekerDto jobSeekerDto = new JobSeekerDto();
//        jobSeekerDto.setSurName("Doe");
//        jobSeekerDto.setFirstName("John");
//        jobSeekerDto.setEmail("john.doe@example.com");
//        // Voeg hier andere relevante velden toe
//
//        String surName = "Doe";
//        when(jobSeekerService.getJobSeekerBySurName(surName)).thenReturn(jobSeekerDto);
//
//        mockMvc.perform(get("/jobseeker/surname/" + surName))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.surName", is("Doe")))
//                .andExpect(jsonPath("$.firstName", is("John")))
//                .andExpect(jsonPath("$.email", is("john.doe@example.com")));
//
//    }
//
//    @Test
//    public void addJobSeekerTest() throws Exception {
//        JobSeekerInputDto inputDto = new JobSeekerInputDto();
//
//        JobSeekerDto jobSeekerDto = new JobSeekerDto();
//        jobSeekerDto.setFirstName("John");
//
//        when(jobSeekerService.addJobSeeker(ArgumentMatchers.any(JobSeekerInputDto.class))).thenReturn(jobSeekerDto);
//
//        mockMvc.perform(post("/jobseeker")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(inputDto)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.firstName", is("John")));
//    }
//
//    private String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void addJobSeekerWithInvalidDataTest() throws Exception {
//        JobSeekerInputDto invalidInputDto = new JobSeekerInputDto();
//        // Hier stel je de velden in op een manier die als ongeldig wordt beschouwd
//
//        mockMvc.perform(post("/jobseeker")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(invalidInputDto)))
//                .andExpect(status().isBadRequest());
//    }
//
//
//
//    @Test
//    public void getJobSeekerByEmailTest() throws Exception {
//        JobSeekerDto jobSeekerDto = new JobSeekerDto();
//        jobSeekerDto.setEmail("john.doe@example.com");
//        jobSeekerDto.setFirstName("John");
//        jobSeekerDto.setSurName("Doe");
//
//
//        String email = "john.doe@example.com";
//        when(jobSeekerService.getJobSeekerByEmail(email)).thenReturn(jobSeekerDto);
//
//        mockMvc.perform(get("/jobseeker/email/" + email))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.email", is(email)))
//                .andExpect(jsonPath("$.firstName", is("John")))
//                .andExpect(jsonPath("$.surName", is("Doe")));
//
//    }
//
//    @Test
//    public void getNonExistingJobSeekerByEmailTest() throws Exception {
//        String email = "nonexistent@example.com";
//        when(jobSeekerService.getJobSeekerByEmail(email)).thenReturn(null);
//
//        mockMvc.perform(get("/jobseeker/email/" + email))
//                .andExpect(status().isNotFound());
//    }
//
//
//
//    @Test
//    public void deleteJobSeekerTest() throws Exception {
//        Long id = 1L;
//        doNothing().when(jobSeekerService).deleteJobSeeker(id);
//
//        mockMvc.perform(delete("/jobseeker/" + id))
//                .andExpect(status().isNoContent());
//    }
//
//}
