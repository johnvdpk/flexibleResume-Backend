package com.example.flexibleresume.repositorys;

import com.example.flexibleresume.models.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
}
