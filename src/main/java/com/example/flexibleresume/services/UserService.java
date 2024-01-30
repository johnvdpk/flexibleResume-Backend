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


    public UserDto createUser(UserInputDto userInputDto) {

        User user = new User();
        user.setEmail(userInputDto.getEmail());
        user.setPassword(passwordEncoder.encode(userInputDto.getPassword()));
        user.setRole(userInputDto.getRole());


        User savedUser = userRepos.save(user);


        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setEmail(savedUser.getEmail());


        return userDto;
    }
}