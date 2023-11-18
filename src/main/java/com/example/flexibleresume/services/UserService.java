package com.example.flexibleresume.services;


import com.example.flexibleresume.dtos.UserDto;
import com.example.flexibleresume.dtos.UserInputDto;
import com.example.flexibleresume.repositorys.UserRepository;
import com.example.flexibleresume.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    private final UserRepository userRepos;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepos, PasswordEncoder passwordEncoder) {
        this.userRepos = userRepos;
        this.passwordEncoder = passwordEncoder;
    }

    //wordt niet gebruikt en is wellicht ook niet nodig omdat dit al bij AuthenticationController gebeurd
    public UserDto createUser(UserInputDto userInputDto) {
        // Aanmaken van een nieuwe User
        User user = new User();
        user.setEmail(userInputDto.getEmail());
        user.setPassword(passwordEncoder.encode(userInputDto.getPassword()));
        user.setRole(userInputDto.getRole()); // Veronderstelt dat de rol als een string wordt meegegeven

        // Sla de User op
        User savedUser = userRepos.save(user);

        // Maak een nieuwe UserDto en vul deze met gegevens van de opgeslagen User
        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setEmail(savedUser.getEmail());
       // userDto.setRole(savedUser.getRole().name()); // Aannemend dat Role een enum is

        // Return de UserDto
        return userDto;
    }
}