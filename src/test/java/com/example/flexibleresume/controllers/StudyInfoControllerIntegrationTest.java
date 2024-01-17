package com.example.flexibleresume.controllers;

import com.example.flexibleresume.FlexibleResumeApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = FlexibleResumeApplication.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class StudyInfoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @Test
    public void testGetAllStudyInfos() throws Exception {
        mockMvc.perform(get("/jobseeker/studyinfo/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateStudyInfo() throws Exception {
        mockMvc.perform(get("/jobseeker/studyinfo/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateStudyInfo() throws Exception {
        mockMvc.perform(get("/jobseeker/studyinfo/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteStudyInfo() throws Exception {
        mockMvc.perform(get("/jobseeker/studyinfo/1"))
                .andExpect(status().isOk());
    }
}
