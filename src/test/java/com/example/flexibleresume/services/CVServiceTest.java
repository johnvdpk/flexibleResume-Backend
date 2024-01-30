package com.example.flexibleresume.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.flexibleresume.dtos.CVDto;
import com.example.flexibleresume.dtos.CVInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.models.Employer;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.models.WorkInfo;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.repositorys.JobSeekerRepository;
import com.example.flexibleresume.user.Role;
import com.example.flexibleresume.user.User;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CVServiceTest {
    @MockBean
    private CVRepository cVRepository;

    @MockBean
    private JobSeekerRepository jobSeekerRepository;

    @Autowired
    private CVService cVService;

    @MockBean
    private SqlDataSourceScriptDatabaseInitializer sqlDataSourceScriptDatabaseInitializer;

    @Test
    void testCVtoDto() throws UnsupportedEncodingException {
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

        // Act and Assert
        assertEquals("About Me", cVService.CVtoDto(cv).getAboutMe());
    }

    @Test
    void testInputDtotoCV() {
        // Arrange and Act
        CV actualInputDtotoCVResult = cVService.inputDtotoCV(new CVInputDto());

        // Assert
        assertNull(actualInputDtotoCVResult.getAboutMe());
        List<WorkInfo> workInfos = actualInputDtotoCVResult.getWorkInfos();
        assertTrue(workInfos.isEmpty());
        assertEquals(workInfos, actualInputDtotoCVResult.getPersonalInfos());
        assertEquals(workInfos, actualInputDtotoCVResult.getStudyInfos());
    }


    @Test
    void testInputDtotoCV2() {
        // Arrange
        CVInputDto cvInputDto = new CVInputDto();
        cvInputDto.setAboutMe("About Me");

        // Act
        CV actualInputDtotoCVResult = cVService.inputDtotoCV(cvInputDto);

        // Assert
        assertEquals("About Me", actualInputDtotoCVResult.getAboutMe());
        List<WorkInfo> workInfos = actualInputDtotoCVResult.getWorkInfos();
        assertTrue(workInfos.isEmpty());
        assertEquals(workInfos, actualInputDtotoCVResult.getPersonalInfos());
        assertEquals(workInfos, actualInputDtotoCVResult.getStudyInfos());
    }


    @Test
    void testUpdateCV() throws UnsupportedEncodingException {
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

        // Act
        CVDto actualUpdateCVResult = cVService.updateCV(1L, new CVInputDto());

        // Assert
        verify(cVRepository).findById(Mockito.<Long>any());
        verify(cVRepository).save(Mockito.<CV>any());
        assertEquals("About Me", actualUpdateCVResult.getAboutMe());
    }

    @Test
    void testUpdateCV2() throws UnsupportedEncodingException {
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
        when(cVRepository.save(Mockito.<CV>any())).thenThrow(new RecordNotFoundException("An error occurred"));
        when(cVRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(RecordNotFoundException.class, () -> cVService.updateCV(1L, new CVInputDto()));
        verify(cVRepository).findById(Mockito.<Long>any());
        verify(cVRepository).save(Mockito.<CV>any());
    }


    @Test
    void testGetAllCVs() throws UnsupportedEncodingException {
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
        Optional<Long> id = Optional.<Long>of(1L);

        // Act
        List<CV> actualAllCVs = cVService.getAllCVs(id);

        // Assert
        verify(cVRepository).findById(Mockito.<Long>any());
        assertEquals(1, actualAllCVs.size());
    }


    @Test
    void testGetCVById() throws UnsupportedEncodingException {
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

        // Act
        CVDto actualCVById = cVService.getCVById(1L);

        // Assert
        verify(cVRepository).findById(Mockito.<Long>any());
        assertEquals("About Me", actualCVById.getAboutMe());
    }


    @Test
    void testUploadFileDocument() throws IOException {
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

        // Act
        CV actualUploadFileDocumentResult = cVService
                .uploadFileDocument(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), 1L);

        // Assert
        verify(cVRepository).findById(Mockito.<Long>any());
        verify(cVRepository).save(Mockito.<CV>any());
        assertSame(cv2, actualUploadFileDocumentResult);
    }


    @Test
    void testUploadFileDocument2() throws IOException {
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
        when(cVRepository.save(Mockito.<CV>any())).thenThrow(new RecordNotFoundException("An error occurred"));
        when(cVRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(RecordNotFoundException.class, () -> cVService
                .uploadFileDocument(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), 1L));
        verify(cVRepository).findById(Mockito.<Long>any());
        verify(cVRepository).save(Mockito.<CV>any());
    }


    @Test
    void testSingleFileDownload() throws UnsupportedEncodingException {
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

        // Act
        CV actualSingleFileDownloadResult = cVService.singleFileDownload("foo.txt", new MockHttpServletRequest());

        // Assert
        verify(cVRepository).findByFileName(Mockito.<String>any());
        assertSame(cv, actualSingleFileDownloadResult);
    }
}
