package com.example.flexibleresume.repositorys;

import com.example.flexibleresume.models.WorkInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkInfoRepository extends JpaRepository<WorkInfo, Long> {
}
