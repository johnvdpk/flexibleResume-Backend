package com.example.flexibleresume.repositorys;

import com.example.flexibleresume.models.WorkInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkInfoRepository extends JpaRepository<WorkInfo, Long> {

    List<WorkInfo> findByCvId(Long cvId);
}


