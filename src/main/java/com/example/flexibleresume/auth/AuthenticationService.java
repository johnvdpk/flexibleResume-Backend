package com.example.flexibleresume.auth;

import com.example.flexibleresume.config.JwtService;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.JobSeekerRepository;
import com.example.flexibleresume.repositorys.UserRepository;
import com.example.flexibleresume.user.Role;
import com.example.flexibleresume.user.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepos;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final JobSeekerRepository jobSeekerRepos;

    public AuthenticationResponse register(RegisterRequest request) {

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

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
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
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
