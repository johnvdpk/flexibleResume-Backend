package com.example.flexibleresume.config;

import com.example.flexibleresume.models.*;
import com.example.flexibleresume.repositorys.*;
import com.example.flexibleresume.user.Role;
import com.example.flexibleresume.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;


@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepos,
                                   JobSeekerRepository jobSeekerRepos,
                                   CVRepository cVRepos,
                                   WorkInfoRepository workInfoRepos,
                                   PersonalInfoRepository personalInfoRepos,
                                   StudyInfoRepository studyInfoRepos,
                                   EmployerRepository employerRepos,
                                   PasswordEncoder passwordEncoder) {
        return args -> {
            // Maak en sla een User op
            User user = User.builder()
                    .email("johndoe@email.com")
                    .password(passwordEncoder.encode("1234"))
                    .role(Role.USER)
                    .build();
            userRepos.save(user);

            User employerUser = User.builder()
                    .email("employer@email.com")
                    .password(passwordEncoder.encode("1234"))
                    .role(Role.COMPANY)
                    .build();
            userRepos.save(employerUser);

            User adminUser = User.builder()
                    .email("admin@email.com")
                    .password(passwordEncoder.encode("admin"))
                    .role(Role.ADMIN)
                    .build();
            userRepos.save(adminUser);


            // Maak en sla een JobSeeker op
            JobSeeker jobSeeker = new JobSeeker();
            jobSeeker.setFirstName("John");
            jobSeeker.setSurName("Doe");
            jobSeeker.setDateOfBirth(LocalDate.parse("1986-05-04"));
            jobSeeker.setEmail("johndoe@email.com");
            jobSeeker.setPhoneNumber("0632654897");
            jobSeeker.setResidence("Amsterdam");
            jobSeeker.setZipCode("3423ET");
            jobSeeker.setHomeAddress("destraat");
            jobSeeker.setHouseNumber("54b");
            jobSeeker.setUser(user); // Koppel aan de User
            jobSeekerRepos.save(jobSeeker);

            // Maak en sla een CV op
            CV cv = new CV();
            cv.setAboutMe("Gepassioneerde developer met ervaring in Java en Spring Framework.");
            cv.setJobSeeker(jobSeeker); // Koppel aan JobSeeker
            cVRepos.save(cv);


            // Werkervaring toevoegen
            WorkInfo workInfo = new WorkInfo();
            workInfo.setCompany("Tech Solutions");
            workInfo.setJobTitle("Java Developer");
            workInfo.setPeriodOfEmployment("2017-2021");
            workInfo.setJobInfo("Ontwikkelde nieuwe features voor een e-commerce platform.");
            workInfo.setCv(cv);
            workInfoRepos.save(workInfo);

            // Persoonlijke informatie toevoegen
            PersonalInfo personalInfo = new PersonalInfo();
            personalInfo.setHobby("Schilderen");
            personalInfo.setPeriodOfHobby("2010-2023");
            personalInfo.setHobbyInfo("Landschappen en portretten schilderen.");
            personalInfo.setCv(cv);
            personalInfoRepos.save(personalInfo);

            // Studie informatie toevoegen
            StudyInfo studyInfo = new StudyInfo();
            studyInfo.setEducationalInstitute("Universiteit van Amsterdam");
            studyInfo.setEducation("Bachelor Informatica");
            studyInfo.setPeriodOfStudy("2010-2013");
            studyInfo.setStudyInfo("Softwareontwikkeling en data-analyse.");
            studyInfo.setCv(cv);
            studyInfoRepos.save(studyInfo);

            Employer employer = new Employer();
            // Vul de velden van Employer in
            employer.setCompany("TechCorp");
            employer.setIndustry("IT");
            employer.setOfficeAdress("Technostraat 5");
            employer.setOfficeAdressNumber("5A");
            employer.setOfficeZipcode("1001AB");
            employer.setOfficeCityLocation("Amsterdam");
            employer.setKvk("12345678");
            employer.setMission("Onze missie is om technologie toegankelijk te maken voor iedereen.");
            employer.setVision("Een wereld waarin technologie het dagelijks leven verbetert.");
            employer.setNumberOfEmployees("500");
            employer.setUser(employerUser); // Koppel aan de EmployerUser
            employerRepos.save(employer);

            // Update employerUser met de gekoppelde employer
            employerUser.setEmployer(employer);
            userRepos.save(employerUser);


        };
    }

}
