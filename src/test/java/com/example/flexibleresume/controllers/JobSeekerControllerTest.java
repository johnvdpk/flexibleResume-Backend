package com.example.flexibleresume.controllers;

import com.example.flexibleresume.config.JwtService;
import com.example.flexibleresume.config.SecurityConfigTest;
import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.services.JobSeekerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;



import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(JobSeekerController.class)
@Import(SecurityConfigTest.class)
public class JobSeekerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobSeekerService jobSeekerService;

    @MockBean
    private JwtService jwtService;
    @Test
    public void getAllJobSeekersTest() throws Exception {
        List<JobSeeker> jobSeekers = List.of(new JobSeeker(/* init velden */));
        when(jobSeekerService.getAllJobSeekers(Optional.empty())).thenReturn(jobSeekers);

        mockMvc.perform(get("/werkzoekende/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }


    @Test
    public void getJobSeekerByFirstNameTest() throws Exception {
        JobSeekerDto jobSeekerDto = new JobSeekerDto();
        jobSeekerDto.setFirstName("John");
        // Stel hier andere benodigde velden in, indien van toepassing

        String firstName = "John";
        when(jobSeekerService.getJobSeekerByFirstName(firstName)).thenReturn(jobSeekerDto);

        mockMvc.perform(get("/werkzoekende/voornaam/" + firstName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(firstName)));
    }

    @Test
    public void getJobSeekerBySurNameTest() throws Exception {
        JobSeekerDto jobSeekerDto = new JobSeekerDto();
        jobSeekerDto.setSurName("Doe");

        String surName = "Doe";
        when(jobSeekerService.getJobSeekerBySurName(surName)).thenReturn(jobSeekerDto);

        mockMvc.perform(get("/werkzoekende/achternaam/" + surName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.surName", is(surName)));
    }

    @Test
    public void addJobSeekerTest() throws Exception {
        JobSeekerInputDto inputDto = new JobSeekerInputDto();

        JobSeekerDto jobSeekerDto = new JobSeekerDto();
        jobSeekerDto.setFirstName("John");

        when(jobSeekerService.addJobSeeker(ArgumentMatchers.any(JobSeekerInputDto.class))).thenReturn(jobSeekerDto);

        mockMvc.perform(post("/werkzoekende")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is("John")));
    }

    // Hulpmethode om object naar JSON string te converteren
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void getJobSeekerByEmailTest() throws Exception {
        JobSeekerDto jobSeekerDto = new JobSeekerDto();

        String email = "john@example.com";
        jobSeekerDto.setEmail(email);
        when(jobSeekerService.getJobSeekerByEmail(email)).thenReturn(jobSeekerDto);

        mockMvc.perform(get("/werkzoekende/email/" + email))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(email)));
    }

    @Test
    public void deleteJobSeekerTest() throws Exception {
        Long id = 1L;
        doNothing().when(jobSeekerService).deleteJobSeeker(id);

        mockMvc.perform(delete("/werkzoekende/" + id))
                .andExpect(status().isNoContent());
    }

}
