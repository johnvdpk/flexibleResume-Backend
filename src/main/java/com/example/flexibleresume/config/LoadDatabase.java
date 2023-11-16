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

            JobSeeker jobSeeker = new JobSeeker();

            // Maak en sla een User op
            User user = User.builder()
                    .email("johndoe@email.com")
                    .password(passwordEncoder.encode("1234"))
                    .role(Role.USER)
                    .jobSeeker(jobSeeker)
                    .build();
            userRepos.save(user);


            User employerUser = User.builder()
                    .email("bedrijf@email.com")
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
            cv.setAboutMe("Ervaren en enthousiaste ontwikkelaar, deskundig in Java en het Spring Framework, met een sterke drive om innovatieve softwareoplossingen te creëren. Mijn expertise in Java, gecombineerd met diepgaande kennis van het Spring Framework, stelt mij in staat om complexe projecten met precisie en efficiëntie te leiden.");
            cv.setJobSeeker(jobSeeker); // Koppel aan JobSeeker
            CV savedCV = cVRepos.save(cv);
            Long cvId = savedCV.getId();


            // Werkervaring toevoegen
            WorkInfo workInfo = new WorkInfo();
            workInfo.setCompany("Tech Solutions");
            workInfo.setJobTitle("Java Developer");
            workInfo.setPeriodOfEmployment("2017-2021");
            workInfo.setJobInfo("Ontwikkelde nieuwe features voor een e-commerce platform.");
            workInfo.setCv(cv);
            workInfoRepos.save(workInfo);


            WorkInfo workInfo2 = new WorkInfo();
            workInfo2.setCompany("Innovative Tech Inc.");
            workInfo2.setJobTitle("Senior Software Engineer");
            workInfo2.setPeriodOfEmployment("2021-Present");
            workInfo2.setJobInfo("Leidt een team van ontwikkelaars voor cutting-edge projecten.");
            workInfo2.setCv(cv);
            workInfoRepos.save(workInfo2);

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

            StudyInfo studyInfo2 = new StudyInfo();
            studyInfo2.setEducationalInstitute("Technische Universiteit Delft");
            studyInfo2.setEducation("Master's in Computer Science");
            studyInfo2.setPeriodOfStudy("2013-2015");
            studyInfo2.setStudyInfo("Gespecialiseerd in software-architectuur en cybersecurity.");
            studyInfo2.setCv(cv);
            studyInfoRepos.save(studyInfo2);

            PersonalInfo personalInfo2 = new PersonalInfo();
            personalInfo2.setHobby("Fotografie");
            personalInfo2.setPeriodOfHobby("2015-2023");
            personalInfo2.setHobbyInfo("Actief in landschaps- en portretfotografie.");
            personalInfo2.setCv(cv);
            personalInfoRepos.save(personalInfo2);


            Employer employer = new Employer();
            // Vul de velden van Employer in
            employer.setCompany("Sunrise In");
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

            JobSeeker jobSeeker2 = new JobSeeker();

            User user2 = User.builder()
                    .email("patrick@email.com")
                    .password(passwordEncoder.encode("1234"))
                    .role(Role.USER)
                    .jobSeeker(jobSeeker2)
                    .build();
            userRepos.save(user2);

           jobSeeker2.setFirstName("Patrick");
           jobSeeker2.setSurName("Doet het zelfwel");
           jobSeeker2.setDateOfBirth(LocalDate.parse("1986-05-04"));
           jobSeeker2.setEmail("patrick_vanzelf@email.com");
           jobSeeker2.setPhoneNumber("0632652145");
           jobSeeker2.setResidence("Utrecht");
           jobSeeker2.setZipCode("3423TW");
           jobSeeker2.setHomeAddress("Anderestraat");
           jobSeeker2.setHouseNumber("76b");
           jobSeeker2.setUser(user2);
           jobSeekerRepos.save(jobSeeker2);


        };
    }

}
