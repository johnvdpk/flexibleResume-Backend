package com.example.flexibleresume.repositorys;

import com.example.flexibleresume.models.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {

    List<PersonalInfo> findByCvId(Long cvId);
}
