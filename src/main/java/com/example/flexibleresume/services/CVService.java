package com.example.flexibleresume.services;


import com.example.flexibleresume.dtos.CVDto;
import com.example.flexibleresume.dtos.CVInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.repositorys.JobSeekerRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CVService {

    final private CVRepository cVRepos;
    final private JobSeekerRepository jobSeekerRepos;



    public CVDto CVtoDto(CV cv) {
        CVDto cvDto = new CVDto();

        cvDto.setAboutMe(cv.getAboutMe());

        return cvDto;
    }

    public  CV inputDtotoCV (CVInputDto cvInputDto) {
        CV cv = new CV();

        cv.setAboutMe(cvInputDto.getAboutMe());

        return cv;
    }


    public CVDto updateCV(Long cvId, CVInputDto cvInputDto) {
        // Zoek het CV-object op basis van het cvId
        CV cv = cVRepos.findById(cvId)
                .orElseThrow(() -> new RecordNotFoundException("CV niet gevonden met id: " + cvId));

        // Update de velden van het CV-object met de waarden uit cvInputDto
        if (cvInputDto.getAboutMe() != null) {
            cv.setAboutMe(cvInputDto.getAboutMe());
        }

        // Voeg hier eventueel meer veldupdates toe indien nodig

        // Sla het bijgewerkte CV-object op
        CV updatedCV = cVRepos.save(cv);

        // Converteer het bijgewerkte CV-object naar een CVDto en retourneer het
        return CVtoDto(updatedCV);
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

    @Transactional
    public CV uploadFileDocument(MultipartFile file, Long cvId) throws IOException {
        String name = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        CV cv = cVRepos.findById(cvId)
                .orElseThrow(() -> new RecordNotFoundException("CV niet gevonden met id: " + cvId));

        cv.setFileName(name);
        cv.setDocFile(file.getBytes());

        return cVRepos.save(cv);
    }

    @Transactional
    public CV singleFileDownload(String fileName, HttpServletRequest request){
        return cVRepos.findByFileName(fileName);
    }



}
