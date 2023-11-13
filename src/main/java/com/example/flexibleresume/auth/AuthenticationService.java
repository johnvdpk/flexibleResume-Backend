package com.example.flexibleresume.auth;

import com.example.flexibleresume.config.JwtService;
import com.example.flexibleresume.models.*;
import com.example.flexibleresume.repositorys.*;
import com.example.flexibleresume.user.Role;
import com.example.flexibleresume.user.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepos;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final JobSeekerRepository jobSeekerRepos;
    private final CVRepository cVRepos;
    private final PersonalInfoRepository personalInfoRepos;
    private final StudyInfoRepository studyInfoRepos;
    private final WorkInfoRepository workRepos;
    private final EmployerRepository employerRepos;
    private final EmployerJobInfoRepository employerJobInfoRepos;

    public AuthenticationResponse register(RegisterRequest request) {

        Optional<User> existingUser = userRepos.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Een gebruiker met dit e-mailadres bestaat al");
        }


        //maakt de user aan
        var user = User.builder()
              .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole()))
                .build();
        userRepos.save(user);


        // Maakt een nieuwe JobSeeker voor deze User
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setUser(user); // Koppel de User aan de JobSeeker
        jobSeekerRepos.save(jobSeeker);

        user.setJobSeeker(jobSeeker);
        user = userRepos.save(user);

        // Maakt en CV aan voor de Jobseeker
        CV cv = new CV();
        cv.setJobSeeker(jobSeeker);
        cVRepos.save(cv);

        // Maakt een PersonalInfo aan voor het CV
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setCv(cv);
        personalInfoRepos.save(personalInfo);

        // Maakt een StudyInfo aan voor het CV
        StudyInfo studyInfo = new StudyInfo();
        studyInfo.setCv(cv);
        studyInfoRepos.save(studyInfo);

        // Maakt een WorkInfo aan voor het CV
        WorkInfo workInfo = new WorkInfo();
        workInfo.setCv(cv);
        workRepos.save(workInfo);



        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .cvId(cv.getId())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )


        );
        var user = userRepos.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        // Vind de JobSeeker en het bijbehorende eerste CV
        JobSeeker jobSeeker = user.getJobSeeker();
        Long cvId = null;
        if (jobSeeker != null && !jobSeeker.getCvs().isEmpty()) {
            cvId = jobSeeker.getCvs().get(0).getId(); // Neem het eerste CV
        }

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .cvId(cvId)
                .build();
    }

    public void deleteUserByEmail(String email) {

        User userToDelete = userRepos.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Gebruiker met e-mailadres " + email + " niet gevonden"));

            userRepos.delete(userToDelete);

    }

}
