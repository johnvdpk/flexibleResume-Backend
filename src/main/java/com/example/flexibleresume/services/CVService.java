package com.example.flexibleresume.services;


import com.example.flexibleresume.dtos.CVDto;
import com.example.flexibleresume.dtos.CVInputDto;
import com.example.flexibleresume.dtos.CVDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.CVRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CVService {

    final private CVRepository cVRepos;



    public CVDto CVtoDto(CV cv) {
        CVDto cvDto = new CVDto();

        cvDto.setAboutme(cv.getAboutme());

        return cvDto;
    }

    public  CV inputDtotoCV (CVInputDto cvInputDto) {
        CV cv = new CV();

        cv.setAboutme(cvInputDto.getAboutme());

        return cv;
    }


    public List<CV> getAllCVs(Optional<Long> id) {
        if (id.isPresent()) {
            Optional<CV> cVOptional = cVRepos.findById(id.get());
            return List.of(cVOptional.get());
        }
        return cVRepos.findAll();


    }

    public CVDto getCVById(Long id) {
        Optional<CV> optionalCVId = cVRepos.findById(id);
        CVDto cVDto = new CVDto();

        if (optionalCVId.isPresent()) {
            CV CVEntity = optionalCVId.get();
            cVDto = CVtoDto(CVEntity);
        }


        return cVDto;
    }



}
