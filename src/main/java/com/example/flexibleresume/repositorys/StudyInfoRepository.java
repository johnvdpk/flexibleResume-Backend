package com.example.flexibleresume.repositorys;

import com.example.flexibleresume.models.StudyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyInfoRepository extends JpaRepository<StudyInfo, Long> {

    List<StudyInfo> findByCvId(Long cvId);
}
