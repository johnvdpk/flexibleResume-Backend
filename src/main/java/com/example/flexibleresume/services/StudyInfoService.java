package com.example.flexibleresume.services;

import com.example.flexibleresume.dtos.StudyInfoDto;
import com.example.flexibleresume.dtos.StudyInfoInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.models.StudyInfo;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.repositorys.StudyInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudyInfoService {

    private final StudyInfoRepository studyInfoRepos;
    private final CVRepository cVRepos;

    public StudyInfoDto studyInfoToDto(StudyInfo studyInfo) {
        StudyInfoDto studyInfoDto = new StudyInfoDto();

        studyInfoDto.setId(studyInfo.getId());
        studyInfoDto.setEducationalInstitute(studyInfo.getEducationalInstitute());
        studyInfoDto.setEducation(studyInfo.getEducation());
        studyInfoDto.setPeriodOfStudy(studyInfo.getPeriodOfStudy());
        studyInfoDto.setStudyInfo(studyInfo.getStudyInfo());

        if (studyInfo.getCv() != null) {
            studyInfoDto.setCvId(studyInfo.getCv().getId());
        }

        return studyInfoDto;
    }

    public StudyInfo inputDtoToStudyInfo(StudyInfoInputDto studyInfoInputDto) {
        StudyInfo studyInfo = new StudyInfo();

        studyInfo.setEducationalInstitute(studyInfoInputDto.getEducationalInstitute());
        studyInfo.setEducation(studyInfoInputDto.getEducation());
        studyInfo.setPeriodOfStudy(studyInfoInputDto.getPeriodOfStudy());
        studyInfo.setStudyInfo(studyInfoInputDto.getStudyInfo());
        return studyInfo;
    }

    public List<StudyInfoDto> getAllStudyInfos() {
        return studyInfoRepos.findAll().stream()
                .map(this::studyInfoToDto)
                .collect(Collectors.toList());
    }

    public List<StudyInfoDto> getStudyInfoByCvId(Long cvId) {
        List<StudyInfo> studyInfos = studyInfoRepos.findByCvId(cvId);
        if (studyInfos.isEmpty()) {
            throw new RecordNotFoundException("Geen StudyInfo gevonden voor CV ID: " + cvId);
        }
        return studyInfos.stream().map(this::studyInfoToDto).collect(Collectors.toList());
    }

    public StudyInfoDto createStudyInfo(StudyInfoInputDto studyInfoInputDto, Long cvId) {
        CV cv = cVRepos.findById(cvId)
                .orElseThrow(() -> new RecordNotFoundException("CV niet gevonden met id: " + cvId));

        StudyInfo studyInfo = inputDtoToStudyInfo(studyInfoInputDto);
        studyInfo.setCv(cv);
        studyInfo = studyInfoRepos.save(studyInfo);
        return studyInfoToDto(studyInfo);
    }

    public StudyInfoDto updateStudyInfo(Long id, StudyInfoInputDto studyInfoInputDto) {
        StudyInfo existingStudyInfo = studyInfoRepos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Geen StudyInfo gevonden met dit ID"));

        existingStudyInfo.setEducationalInstitute(studyInfoInputDto.getEducationalInstitute());
        existingStudyInfo.setEducation(studyInfoInputDto.getEducation());
        existingStudyInfo.setPeriodOfStudy(studyInfoInputDto.getPeriodOfStudy());
        existingStudyInfo.setStudyInfo(studyInfoInputDto.getStudyInfo());
        existingStudyInfo = studyInfoRepos.save(existingStudyInfo);

        return studyInfoToDto(existingStudyInfo);
    }

    public void deleteStudyInfo(Long id) {
        studyInfoRepos.deleteById(id);
    }
}
