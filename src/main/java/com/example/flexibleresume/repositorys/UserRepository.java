package com.example.flexibleresume.repositorys;


import com.example.flexibleresume.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
