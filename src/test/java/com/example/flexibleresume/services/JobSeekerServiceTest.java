package com.example.flexibleresume.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.models.Employer;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.repositorys.JobSeekerRepository;
import com.example.flexibleresume.repositorys.UserRepository;
import com.example.flexibleresume.user.Role;
import com.example.flexibleresume.user.User;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JobSeekerService.class})
@ExtendWith(SpringExtension.class)
class JobSeekerServiceTest {
  @MockBean
  private CVRepository cVRepository;

  @MockBean
  private JobSeekerRepository jobSeekerRepository;

  @Autowired
  private JobSeekerService jobSeekerService;

  @MockBean
  private UserRepository userRepository;

  /**
   * Method under test: {@link JobSeekerService#jobSeekerToDto(JobSeeker)}
   */
  @Test
  void testJobSeekerToDto() {
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
    JobSeekerDto actualJobSeekerToDtoResult = jobSeekerService.jobSeekerToDto(jobSeeker2);
    assertEquals("1970-01-01", actualJobSeekerToDtoResult.getDateOfBirth().toString());
    assertEquals("21654", actualJobSeekerToDtoResult.getZipCode());
    assertEquals("42 Main St", actualJobSeekerToDtoResult.getHomeAddress());
    assertEquals("42", actualJobSeekerToDtoResult.getHouseNumber());
    assertEquals("6625550144", actualJobSeekerToDtoResult.getPhoneNumber());
    assertEquals("Doe", actualJobSeekerToDtoResult.getSurName());
    assertEquals("Jane", actualJobSeekerToDtoResult.getFirstName());
    assertEquals("Residence", actualJobSeekerToDtoResult.getResidence());
    assertEquals("jane.doe@example.org", actualJobSeekerToDtoResult.getEmail());
  }

  /**
   * Method under test: {@link JobSeekerService#jobSeekerToDto(JobSeeker)}
   */
  @Test
  void testJobSeekerToDto2() {
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
    JobSeeker jobSeeker2 = mock(JobSeeker.class);
    when(jobSeeker2.getEmail()).thenReturn("jane.doe@example.org");
    when(jobSeeker2.getFirstName()).thenReturn("Jane");
    when(jobSeeker2.getHomeAddress()).thenReturn("42 Main St");
    when(jobSeeker2.getHouseNumber()).thenReturn("42");
    when(jobSeeker2.getPhoneNumber()).thenReturn("6625550144");
    when(jobSeeker2.getResidence()).thenReturn("Residence");
    when(jobSeeker2.getSurName()).thenReturn("Doe");
    when(jobSeeker2.getZipCode()).thenReturn("21654");
    when(jobSeeker2.getDateOfBirth()).thenReturn(LocalDate.of(1970, 1, 1));
    doNothing().when(jobSeeker2).setCvs(Mockito.<List<CV>>any());
    doNothing().when(jobSeeker2).setDateOfBirth(Mockito.<LocalDate>any());
    doNothing().when(jobSeeker2).setEmail(Mockito.<String>any());
    doNothing().when(jobSeeker2).setFirstName(Mockito.<String>any());
    doNothing().when(jobSeeker2).setHomeAddress(Mockito.<String>any());
    doNothing().when(jobSeeker2).setHouseNumber(Mockito.<String>any());
    doNothing().when(jobSeeker2).setId(Mockito.<Long>any());
    doNothing().when(jobSeeker2).setPhoneNumber(Mockito.<String>any());
    doNothing().when(jobSeeker2).setResidence(Mockito.<String>any());
    doNothing().when(jobSeeker2).setSurName(Mockito.<String>any());
    doNothing().when(jobSeeker2).setUser(Mockito.<User>any());
    doNothing().when(jobSeeker2).setZipCode(Mockito.<String>any());
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
    JobSeekerDto actualJobSeekerToDtoResult = jobSeekerService.jobSeekerToDto(jobSeeker2);
    verify(jobSeeker2).getDateOfBirth();
    verify(jobSeeker2).getEmail();
    verify(jobSeeker2).getFirstName();
    verify(jobSeeker2).getHomeAddress();
    verify(jobSeeker2).getHouseNumber();
    verify(jobSeeker2).getPhoneNumber();
    verify(jobSeeker2).getResidence();
    verify(jobSeeker2).getSurName();
    verify(jobSeeker2).getZipCode();
    verify(jobSeeker2).setCvs(Mockito.<List<CV>>any());
    verify(jobSeeker2).setDateOfBirth(Mockito.<LocalDate>any());
    verify(jobSeeker2).setEmail(Mockito.<String>any());
    verify(jobSeeker2).setFirstName(Mockito.<String>any());
    verify(jobSeeker2).setHomeAddress(Mockito.<String>any());
    verify(jobSeeker2).setHouseNumber(Mockito.<String>any());
    verify(jobSeeker2).setId(Mockito.<Long>any());
    verify(jobSeeker2).setPhoneNumber(Mockito.<String>any());
    verify(jobSeeker2).setResidence(Mockito.<String>any());
    verify(jobSeeker2).setSurName(Mockito.<String>any());
    verify(jobSeeker2).setUser(Mockito.<User>any());
    verify(jobSeeker2).setZipCode(Mockito.<String>any());
    assertEquals("1970-01-01", actualJobSeekerToDtoResult.getDateOfBirth().toString());
    assertEquals("21654", actualJobSeekerToDtoResult.getZipCode());
    assertEquals("42 Main St", actualJobSeekerToDtoResult.getHomeAddress());
    assertEquals("42", actualJobSeekerToDtoResult.getHouseNumber());
    assertEquals("6625550144", actualJobSeekerToDtoResult.getPhoneNumber());
    assertEquals("Doe", actualJobSeekerToDtoResult.getSurName());
    assertEquals("Jane", actualJobSeekerToDtoResult.getFirstName());
    assertEquals("Residence", actualJobSeekerToDtoResult.getResidence());
    assertEquals("jane.doe@example.org", actualJobSeekerToDtoResult.getEmail());
  }

  /**
   * Method under test:
   * {@link JobSeekerService#inputDtoToJobSeeker(JobSeekerInputDto)}
   */
  @Test
  void testInputDtoToJobSeeker() {
    JobSeeker actualInputDtoToJobSeekerResult = jobSeekerService.inputDtoToJobSeeker(new JobSeekerInputDto());
    assertNull(actualInputDtoToJobSeekerResult.getEmail());
    assertNull(actualInputDtoToJobSeekerResult.getFirstName());
    assertNull(actualInputDtoToJobSeekerResult.getHomeAddress());
    assertNull(actualInputDtoToJobSeekerResult.getHouseNumber());
    assertNull(actualInputDtoToJobSeekerResult.getPhoneNumber());
    assertNull(actualInputDtoToJobSeekerResult.getResidence());
    assertNull(actualInputDtoToJobSeekerResult.getSurName());
    assertNull(actualInputDtoToJobSeekerResult.getZipCode());
    assertNull(actualInputDtoToJobSeekerResult.getDateOfBirth());
    assertTrue(actualInputDtoToJobSeekerResult.getCvs().isEmpty());
  }

  /**
   * Method under test:
   * {@link JobSeekerService#inputDtoToJobSeeker(JobSeekerInputDto)}
   */
  @Test
  void testInputDtoToJobSeeker2() {
    JobSeekerInputDto jobSeekerInputDto = mock(JobSeekerInputDto.class);
    when(jobSeekerInputDto.getEmail()).thenReturn("jane.doe@example.org");
    when(jobSeekerInputDto.getFirstName()).thenReturn("Jane");
    when(jobSeekerInputDto.getHomeAddress()).thenReturn("42 Main St");
    when(jobSeekerInputDto.getHouseNumber()).thenReturn("42");
    when(jobSeekerInputDto.getPhoneNumber()).thenReturn("6625550144");
    when(jobSeekerInputDto.getResidence()).thenReturn("Residence");
    when(jobSeekerInputDto.getSurName()).thenReturn("Doe");
    when(jobSeekerInputDto.getZipCode()).thenReturn("21654");
    when(jobSeekerInputDto.getDateOfBirth()).thenReturn(LocalDate.of(1970, 1, 1));
    JobSeeker actualInputDtoToJobSeekerResult = jobSeekerService.inputDtoToJobSeeker(jobSeekerInputDto);
    verify(jobSeekerInputDto).getDateOfBirth();
    verify(jobSeekerInputDto).getEmail();
    verify(jobSeekerInputDto).getFirstName();
    verify(jobSeekerInputDto).getHomeAddress();
    verify(jobSeekerInputDto).getHouseNumber();
    verify(jobSeekerInputDto).getPhoneNumber();
    verify(jobSeekerInputDto).getResidence();
    verify(jobSeekerInputDto).getSurName();
    verify(jobSeekerInputDto).getZipCode();
    assertEquals("1970-01-01", actualInputDtoToJobSeekerResult.getDateOfBirth().toString());
    assertEquals("21654", actualInputDtoToJobSeekerResult.getZipCode());
    assertEquals("42 Main St", actualInputDtoToJobSeekerResult.getHomeAddress());
    assertEquals("42", actualInputDtoToJobSeekerResult.getHouseNumber());
    assertEquals("6625550144", actualInputDtoToJobSeekerResult.getPhoneNumber());
    assertEquals("Doe", actualInputDtoToJobSeekerResult.getSurName());
    assertEquals("Jane", actualInputDtoToJobSeekerResult.getFirstName());
    assertEquals("Residence", actualInputDtoToJobSeekerResult.getResidence());
    assertEquals("jane.doe@example.org", actualInputDtoToJobSeekerResult.getEmail());
    assertTrue(actualInputDtoToJobSeekerResult.getCvs().isEmpty());
  }

  /**
   * Method under test: {@link JobSeekerService#addCVToJobSeeker(Long, CV)}
   */
  @Test
  void testAddCVToJobSeeker() throws UnsupportedEncodingException {
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
    Optional<JobSeeker> ofResult = Optional.of(jobSeeker2);
    when(jobSeekerRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

    User user4 = new User();
    user4.setEmail("jane.doe@example.org");
    user4.setEmployer(new Employer());
    user4.setId(1L);
    user4.setJobSeeker(new JobSeeker());
    user4.setPassword("iloveyou");
    user4.setRole(Role.USER);

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
    employer2.setUser(user4);
    employer2.setVision("Vision");

    User user5 = new User();
    user5.setEmail("jane.doe@example.org");
    user5.setEmployer(new Employer());
    user5.setId(1L);
    user5.setJobSeeker(new JobSeeker());
    user5.setPassword("iloveyou");
    user5.setRole(Role.USER);

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
    jobSeeker3.setUser(user5);
    jobSeeker3.setZipCode("21654");

    User user6 = new User();
    user6.setEmail("jane.doe@example.org");
    user6.setEmployer(employer2);
    user6.setId(1L);
    user6.setJobSeeker(jobSeeker3);
    user6.setPassword("iloveyou");
    user6.setRole(Role.USER);

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
    jobSeeker4.setUser(user6);
    jobSeeker4.setZipCode("21654");

    CV cv = new CV();
    cv.setAboutMe("About Me");
    cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
    cv.setFileName("foo.txt");
    cv.setId(1L);
    cv.setJobSeeker(jobSeeker4);
    cv.setPersonalInfos(new ArrayList<>());
    cv.setStudyInfos(new ArrayList<>());
    cv.setWorkInfos(new ArrayList<>());
    when(cVRepository.save(Mockito.<CV>any())).thenReturn(cv);

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

    User user7 = new User();
    user7.setEmail("jane.doe@example.org");
    user7.setEmployer(employer3);
    user7.setId(1L);
    user7.setJobSeeker(jobSeeker5);
    user7.setPassword("iloveyou");
    user7.setRole(Role.USER);

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
    jobSeeker6.setUser(user7);
    jobSeeker6.setZipCode("21654");

    CV cv2 = new CV();
    cv2.setAboutMe("About Me");
    cv2.setDocFile("AXAXAXAX".getBytes("UTF-8"));
    cv2.setFileName("foo.txt");
    cv2.setId(1L);
    cv2.setJobSeeker(jobSeeker6);
    cv2.setPersonalInfos(new ArrayList<>());
    cv2.setStudyInfos(new ArrayList<>());
    cv2.setWorkInfos(new ArrayList<>());
    CV actualAddCVToJobSeekerResult = jobSeekerService.addCVToJobSeeker(1L, cv2);
    verify(jobSeekerRepository).findById(Mockito.<Long>any());
    verify(cVRepository).save(Mockito.<CV>any());
    assertSame(cv, actualAddCVToJobSeekerResult);
    assertSame(jobSeeker2, cv2.getJobSeeker());
  }

  /**
   * Method under test: {@link JobSeekerService#addCVToJobSeeker(Long, CV)}
   */
  @Test
  void testAddCVToJobSeeker2() throws UnsupportedEncodingException {
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
    Optional<JobSeeker> ofResult = Optional.of(jobSeeker2);
    when(jobSeekerRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
    when(cVRepository.save(Mockito.<CV>any())).thenThrow(new RecordNotFoundException("An error occurred"));

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

    CV cv = new CV();
    cv.setAboutMe("About Me");
    cv.setDocFile("AXAXAXAX".getBytes("UTF-8"));
    cv.setFileName("foo.txt");
    cv.setId(1L);
    cv.setJobSeeker(jobSeeker4);
    cv.setPersonalInfos(new ArrayList<>());
    cv.setStudyInfos(new ArrayList<>());
    cv.setWorkInfos(new ArrayList<>());
    assertThrows(RecordNotFoundException.class, () -> jobSeekerService.addCVToJobSeeker(1L, cv));
    verify(jobSeekerRepository).findById(Mockito.<Long>any());
    verify(cVRepository).save(Mockito.<CV>any());
  }

  /**
   * Method under test: {@link JobSeekerService#getAllJobSeekers()}
   */
  @Test
  void testGetAllJobSeekers() {
    when(jobSeekerRepository.findAll()).thenReturn(new ArrayList<>());
    List<JobSeekerDto> actualAllJobSeekers = jobSeekerService.getAllJobSeekers();
    verify(jobSeekerRepository).findAll();
    assertTrue(actualAllJobSeekers.isEmpty());
  }

  /**
   * Method under test: {@link JobSeekerService#getAllJobSeekers()}
   */
  @Test
  void testGetAllJobSeekers2() {
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

    ArrayList<JobSeeker> jobSeekerList = new ArrayList<>();
    jobSeekerList.add(jobSeeker2);
    when(jobSeekerRepository.findAll()).thenReturn(jobSeekerList);
    List<JobSeekerDto> actualAllJobSeekers = jobSeekerService.getAllJobSeekers();
    verify(jobSeekerRepository).findAll();
    assertEquals(1, actualAllJobSeekers.size());
  }

  /**
   * Method under test: {@link JobSeekerService#getAllJobSeekers()}
   */
  @Test
  void testGetAllJobSeekers3() {
    when(jobSeekerRepository.findAll()).thenThrow(new RecordNotFoundException("An error occurred"));
    assertThrows(RecordNotFoundException.class, () -> jobSeekerService.getAllJobSeekers());
    verify(jobSeekerRepository).findAll();
  }

  /**
   * Method under test: {@link JobSeekerService#getAllJobSeekersBySurName(String)}
   */
  @Test
  void testGetAllJobSeekersBySurName() {
    when(jobSeekerRepository.findAllJobSeekersBySurName(Mockito.<String>any())).thenReturn(new ArrayList<>());
    List<JobSeekerDto> actualAllJobSeekersBySurName = jobSeekerService.getAllJobSeekersBySurName("Doe");
    verify(jobSeekerRepository).findAllJobSeekersBySurName(Mockito.<String>any());
    assertTrue(actualAllJobSeekersBySurName.isEmpty());
  }

  /**
   * Method under test: {@link JobSeekerService#getAllJobSeekersBySurName(String)}
   */
  @Test
  void testGetAllJobSeekersBySurName2() {
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

    ArrayList<JobSeeker> jobSeekerList = new ArrayList<>();
    jobSeekerList.add(jobSeeker2);
    when(jobSeekerRepository.findAllJobSeekersBySurName(Mockito.<String>any())).thenReturn(jobSeekerList);
    List<JobSeekerDto> actualAllJobSeekersBySurName = jobSeekerService.getAllJobSeekersBySurName("Doe");
    verify(jobSeekerRepository).findAllJobSeekersBySurName(Mockito.<String>any());
    assertEquals(1, actualAllJobSeekersBySurName.size());
  }

  /**
   * Method under test: {@link JobSeekerService#getAllJobSeekersBySurName(String)}
   */
  @Test
  void testGetAllJobSeekersBySurName3() {
    when(jobSeekerRepository.findAllJobSeekersBySurName(Mockito.<String>any()))
            .thenThrow(new RecordNotFoundException("An error occurred"));
    assertThrows(RecordNotFoundException.class, () -> jobSeekerService.getAllJobSeekersBySurName("Doe"));
    verify(jobSeekerRepository).findAllJobSeekersBySurName(Mockito.<String>any());
  }

  /**
   * Method under test: {@link JobSeekerService#getJobSeekerByFirstName(String)}
   */
  @Test
  void testGetJobSeekerByFirstName() {
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
    Optional<JobSeeker> ofResult = Optional.of(jobSeeker2);
    when(jobSeekerRepository.findByFirstName(Mockito.<String>any())).thenReturn(ofResult);
    JobSeekerDto actualJobSeekerByFirstName = jobSeekerService.getJobSeekerByFirstName("Jane");
    verify(jobSeekerRepository).findByFirstName(Mockito.<String>any());
    assertEquals("1970-01-01", actualJobSeekerByFirstName.getDateOfBirth().toString());
    assertEquals("21654", actualJobSeekerByFirstName.getZipCode());
    assertEquals("42 Main St", actualJobSeekerByFirstName.getHomeAddress());
    assertEquals("42", actualJobSeekerByFirstName.getHouseNumber());
    assertEquals("6625550144", actualJobSeekerByFirstName.getPhoneNumber());
    assertEquals("Doe", actualJobSeekerByFirstName.getSurName());
    assertEquals("Jane", actualJobSeekerByFirstName.getFirstName());
    assertEquals("Residence", actualJobSeekerByFirstName.getResidence());
    assertEquals("jane.doe@example.org", actualJobSeekerByFirstName.getEmail());
  }

  /**
   * Method under test: {@link JobSeekerService#getJobSeekerBySurName(String)}
   */
  @Test
  void testGetJobSeekerBySurName() {
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
    Optional<JobSeeker> ofResult = Optional.of(jobSeeker2);
    when(jobSeekerRepository.findBySurName(Mockito.<String>any())).thenReturn(ofResult);
    JobSeekerDto actualJobSeekerBySurName = jobSeekerService.getJobSeekerBySurName("Doe");
    verify(jobSeekerRepository).findBySurName(Mockito.<String>any());
    assertEquals("1970-01-01", actualJobSeekerBySurName.getDateOfBirth().toString());
    assertEquals("21654", actualJobSeekerBySurName.getZipCode());
    assertEquals("42 Main St", actualJobSeekerBySurName.getHomeAddress());
    assertEquals("42", actualJobSeekerBySurName.getHouseNumber());
    assertEquals("6625550144", actualJobSeekerBySurName.getPhoneNumber());
    assertEquals("Doe", actualJobSeekerBySurName.getSurName());
    assertEquals("Jane", actualJobSeekerBySurName.getFirstName());
    assertEquals("Residence", actualJobSeekerBySurName.getResidence());
    assertEquals("jane.doe@example.org", actualJobSeekerBySurName.getEmail());
  }

  /**
   * Method under test: {@link JobSeekerService#getJobSeekerByEmail(String)}
   */
  @Test
  void testGetJobSeekerByEmail() {
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
    JobSeekerDto actualJobSeekerByEmail = jobSeekerService.getJobSeekerByEmail("jane.doe@example.org");
    verify(userRepository).findByEmail(Mockito.<String>any());
    assertEquals("1970-01-01", actualJobSeekerByEmail.getDateOfBirth().toString());
    assertEquals("21654", actualJobSeekerByEmail.getZipCode());
    assertEquals("42 Main St", actualJobSeekerByEmail.getHomeAddress());
    assertEquals("42", actualJobSeekerByEmail.getHouseNumber());
    assertEquals("6625550144", actualJobSeekerByEmail.getPhoneNumber());
    assertEquals("Doe", actualJobSeekerByEmail.getSurName());
    assertEquals("Jane", actualJobSeekerByEmail.getFirstName());
    assertEquals("Residence", actualJobSeekerByEmail.getResidence());
    assertEquals("jane.doe@example.org", actualJobSeekerByEmail.getEmail());
  }

  /**
   * Method under test: {@link JobSeekerService#addJobSeeker(JobSeekerInputDto)}
   */
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
    when(jobSeekerRepository.save(Mockito.<JobSeeker>any())).thenReturn(jobSeeker4);
    JobSeekerDto actualAddJobSeekerResult = jobSeekerService.addJobSeeker(new JobSeekerInputDto());
    verify(jobSeekerRepository).save(Mockito.<JobSeeker>any());
    assertNull(actualAddJobSeekerResult.getEmail());
    assertNull(actualAddJobSeekerResult.getFirstName());
    assertNull(actualAddJobSeekerResult.getHomeAddress());
    assertNull(actualAddJobSeekerResult.getHouseNumber());
    assertNull(actualAddJobSeekerResult.getPhoneNumber());
    assertNull(actualAddJobSeekerResult.getResidence());
    assertNull(actualAddJobSeekerResult.getSurName());
    assertNull(actualAddJobSeekerResult.getZipCode());
    assertNull(actualAddJobSeekerResult.getDateOfBirth());
  }

  /**
   * Method under test:
   * {@link JobSeekerService#updateJobSeeker(String, JobSeekerInputDto)}
   */
  @Test
  void testUpdateJobSeeker() {
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
    when(jobSeekerRepository.save(Mockito.<JobSeeker>any())).thenReturn(jobSeeker4);

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
    employer4.setUser(new User());
    employer4.setVision("Vision");

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

    User user4 = new User();
    user4.setEmail("jane.doe@example.org");
    user4.setEmployer(employer4);
    user4.setId(1L);
    user4.setJobSeeker(jobSeeker5);
    user4.setPassword("iloveyou");
    user4.setRole(Role.USER);

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
    employer5.setUser(user4);
    employer5.setVision("Vision");

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
    employer6.setUser(new User());
    employer6.setVision("Vision");

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
    jobSeeker6.setUser(new User());
    jobSeeker6.setZipCode("21654");

    User user5 = new User();
    user5.setEmail("jane.doe@example.org");
    user5.setEmployer(employer6);
    user5.setId(1L);
    user5.setJobSeeker(jobSeeker6);
    user5.setPassword("iloveyou");
    user5.setRole(Role.USER);

    JobSeeker jobSeeker7 = new JobSeeker();
    jobSeeker7.setCvs(new ArrayList<>());
    jobSeeker7.setDateOfBirth(LocalDate.of(1970, 1, 1));
    jobSeeker7.setEmail("jane.doe@example.org");
    jobSeeker7.setFirstName("Jane");
    jobSeeker7.setHomeAddress("42 Main St");
    jobSeeker7.setHouseNumber("42");
    jobSeeker7.setId(1L);
    jobSeeker7.setPhoneNumber("6625550144");
    jobSeeker7.setResidence("Residence");
    jobSeeker7.setSurName("Doe");
    jobSeeker7.setUser(user5);
    jobSeeker7.setZipCode("21654");

    User user6 = new User();
    user6.setEmail("jane.doe@example.org");
    user6.setEmployer(employer5);
    user6.setId(1L);
    user6.setJobSeeker(jobSeeker7);
    user6.setPassword("iloveyou");
    user6.setRole(Role.USER);
    Optional<User> ofResult = Optional.of(user6);
    when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
    JobSeekerDto actualUpdateJobSeekerResult = jobSeekerService.updateJobSeeker("jane.doe@example.org",
            new JobSeekerInputDto());
    verify(userRepository).findByEmail(Mockito.<String>any());
    verify(jobSeekerRepository).save(Mockito.<JobSeeker>any());
    assertEquals("1970-01-01", actualUpdateJobSeekerResult.getDateOfBirth().toString());
    assertEquals("21654", actualUpdateJobSeekerResult.getZipCode());
    assertEquals("42 Main St", actualUpdateJobSeekerResult.getHomeAddress());
    assertEquals("42", actualUpdateJobSeekerResult.getHouseNumber());
    assertEquals("6625550144", actualUpdateJobSeekerResult.getPhoneNumber());
    assertEquals("Doe", actualUpdateJobSeekerResult.getSurName());
    assertEquals("Jane", actualUpdateJobSeekerResult.getFirstName());
    assertEquals("Residence", actualUpdateJobSeekerResult.getResidence());
    assertEquals("jane.doe@example.org", actualUpdateJobSeekerResult.getEmail());
  }

  /**
   * Method under test:
   * {@link JobSeekerService#updateJobSeeker(String, JobSeekerInputDto)}
   */
  @Test
  void testUpdateJobSeeker2() {
    when(jobSeekerRepository.save(Mockito.<JobSeeker>any()))
            .thenThrow(new RecordNotFoundException("An error occurred"));

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
    assertThrows(RecordNotFoundException.class,
            () -> jobSeekerService.updateJobSeeker("jane.doe@example.org", new JobSeekerInputDto()));
    verify(userRepository).findByEmail(Mockito.<String>any());
    verify(jobSeekerRepository).save(Mockito.<JobSeeker>any());
  }

  /**
   * Method under test: {@link JobSeekerService#deleteJobSeeker(Long)}
   */
  @Test
  void testDeleteJobSeeker() {
    doNothing().when(jobSeekerRepository).deleteById(Mockito.<Long>any());
    jobSeekerService.deleteJobSeeker(1L);
    verify(jobSeekerRepository).deleteById(Mockito.<Long>any());
  }

  /**
   * Method under test: {@link JobSeekerService#deleteJobSeeker(Long)}
   */
  @Test
  void testDeleteJobSeeker2() {
    doThrow(new RecordNotFoundException("An error occurred")).when(jobSeekerRepository).deleteById(Mockito.<Long>any());
    assertThrows(RecordNotFoundException.class, () -> jobSeekerService.deleteJobSeeker(1L));
    verify(jobSeekerRepository).deleteById(Mockito.<Long>any());
  }
}
