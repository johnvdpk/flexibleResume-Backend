package com.example.flexibleresume.models;

import static org.junit.jupiter.api.Assertions.*;

import com.example.flexibleresume.repositorys.JobSeekerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class JobSeekerIntegrationTest {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Test
    public void testJobSeekerCreation() {
        JobSeeker jobSeeker = createSampleJobSeeker();

        jobSeekerRepository.save(jobSeeker);

        JobSeeker found = jobSeekerRepository.findById(jobSeeker.getId()).orElse(null);
        assertNotNull(found);
        assertJobSeekerEquals(jobSeeker, found);

        jobSeekerRepository.delete(jobSeeker);
    }

    private JobSeeker createSampleJobSeeker() {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setFirstName("Jan");
        jobSeeker.setSurName("Jansen");
        jobSeeker.setDateOfBirth(LocalDate.of(1990, 1, 1));
        jobSeeker.setEmail("jan.jansen@example.com");
        jobSeeker.setPhoneNumber("0123456789");
        jobSeeker.setResidence("Amsterdam");
        jobSeeker.setZipCode("1000AA");
        jobSeeker.setHomeAddress("Hoofdstraat 1");
        jobSeeker.setHouseNumber("1A");
        return jobSeeker;
    }

    private void assertJobSeekerEquals(JobSeeker expected, JobSeeker actual) {
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getSurName(), actual.getSurName());
        assertEquals(expected.getDateOfBirth(), actual.getDateOfBirth());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(expected.getResidence(), actual.getResidence());
        assertEquals(expected.getZipCode(), actual.getZipCode());
        assertEquals(expected.getHomeAddress(), actual.getHomeAddress());
        assertEquals(expected.getHouseNumber(), actual.getHouseNumber());
    }


}
