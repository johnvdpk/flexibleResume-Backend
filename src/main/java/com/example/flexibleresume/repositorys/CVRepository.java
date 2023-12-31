package com.example.flexibleresume.repositorys;

import com.example.flexibleresume.models.CV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepository extends JpaRepository<CV, Long> {

    CV findByFileName(String fileName);


}
