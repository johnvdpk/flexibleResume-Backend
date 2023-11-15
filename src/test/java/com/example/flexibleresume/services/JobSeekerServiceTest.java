package com.example.flexibleresume.services;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.JobSeekerRepository;
import com.example.flexibleresume.repositorys.UserRepository;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JobSeekerServiceTest {

    @Mock
    private JobSeekerRepository jobSeekerRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CVRepository cvRepository;

    @InjectMocks
    private JobSeekerService jobSeekerService;

    private JobSeekerInputDto jobSeekerInputDto;
    private JobSeeker jobSeeker;
    private User user;

    @BeforeEach
    void setUp() {

        user = mock(User.class);


        jobSeekerInputDto = new JobSeekerInputDto();
        jobSeekerInputDto.setFirstName("John");
        jobSeekerInputDto.setSurName("Doe");
        jobSeekerInputDto.setDateOfBirth(LocalDate.of(1980, 1, 1));
        jobSeekerInputDto.setEmail("john.doe@example.com");
        jobSeekerInputDto.setPhoneNumber("123456789");
        jobSeekerInputDto.setResidence("Springfield");
        jobSeekerInputDto.setZipCode("12345");
        jobSeekerInputDto.setHomeAddress("123 Main St");
        jobSeekerInputDto.setHouseNumber("101");


        jobSeeker = new JobSeeker();
        jobSeeker.setFirstName("John");
        jobSeeker.setSurName("Doe");
        jobSeeker.setDateOfBirth(LocalDate.of(1980, 1, 1));
        jobSeeker.setEmail("john.doe@example.com");
        jobSeeker.setPhoneNumber("123456789");
        jobSeeker.setResidence("Springfield");
        jobSeeker.setZipCode("12345");
        jobSeeker.setHomeAddress("123 Main St");
        jobSeeker.setHouseNumber("101");


        user = new User();
        user.setEmail("johndoe@email.com");
        user.setPassword("1234");

    }



    @Test
    void getAllJobSeekers() {
        Long id = 1L;
        Optional<JobSeeker> jobSeekerOptional = Optional.of(jobSeeker);
        when(jobSeekerRepository.findById(id)).thenReturn(jobSeekerOptional);

        JobSeekerDto jobSeekerDto = new JobSeekerDto(); // Maak een dummy JobSeekerDto object
        // Stel eventueel velden van jobSeekerDto in die overeenkomen met jobSeeker
        when(jobSeekerService.jobSeekerToDto(jobSeeker)).thenReturn(jobSeekerDto);

        List<JobSeekerDto> result = jobSeekerService.getAllJobSeekers(id);

        assertEquals(1, result.size());
        assertEquals(jobSeekerDto, result.get(0)); // Controleer of de resultaten JobSeekerDto objecten zijn
    }

    @Test
    void getJobSeekerByFirstName() {
        String firstName = "John";
        when(jobSeekerRepository.findByFirstName(firstName)).thenReturn(Optional.of(jobSeeker));

        JobSeekerDto result = jobSeekerService.getJobSeekerByFirstName(firstName);

        assertNotNull(result);
        assertEquals(jobSeeker.getFirstName(), result.getFirstName());
    }

//    @Test
//    void getJobSeekerByEmail() {
//        String email = "john@example.com";
//        doReturn(Optional.of(user)).when(userRepository).findByEmail(email);
//        doReturn(jobSeeker).when(user).getJobSeeker();
//
//        JobSeekerDto result = jobSeekerService.getJobSeekerByEmail(email);
//
//        assertNotNull(result);
//        assertEquals(jobSeeker.getEmail(), result.getEmail());
//    }
//
//    @Test
//    void updateJobSeeker() {
//        String email = "john@example.com";
//        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
//        when(user.getJobSeeker()).thenReturn(jobSeeker);
//        when(jobSeekerRepository.save(any(JobSeeker.class))).thenReturn(jobSeeker);
//
//        JobSeekerDto result = jobSeekerService.updateJobSeeker(email, jobSeekerInputDto);
//
//        assertNotNull(result);
//        // Voeg verificaties toe voor de bijgewerkte velden
//    }



    @Test
    void addJobSeekerTest() {
        // Arrange
        when(jobSeekerRepository.save(any(JobSeeker.class))).thenReturn(jobSeeker);

        // Act
        JobSeekerDto result = jobSeekerService.addJobSeeker(jobSeekerInputDto);

        // Assert
        assertNotNull(result);
        assertEquals(jobSeeker.getFirstName(), result.getFirstName());

    }

    @Test
    void updateJobSeekerTest() {
        // Arrange
        String email = "nonexistent@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RecordNotFoundException.class, () -> jobSeekerService.updateJobSeeker(email, jobSeekerInputDto));
    }

    @Test
    void deleteJobSeeker() {
        Long id = 1L;
        doNothing().when(jobSeekerRepository).deleteById(id);

        jobSeekerService.deleteJobSeeker(id);

        verify(jobSeekerRepository, times(1)).deleteById(id);
    }



}
