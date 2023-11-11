package com.example.flexibleresume.services;

import com.example.flexibleresume.dtos.PersonalInfoDto;
import com.example.flexibleresume.dtos.PersonalInfoInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.models.PersonalInfo;
import com.example.flexibleresume.repositorys.CVRepository;
import com.example.flexibleresume.repositorys.PersonalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepos;
    private final CVRepository cVRepos;

    public PersonalInfoDto personalInfoToDto(PersonalInfo personalInfo) {
        PersonalInfoDto personalInfoDto = new PersonalInfoDto();
        personalInfoDto.setHobby(personalInfo.getHobby());
        personalInfoDto.setPeriodOfHobby(personalInfo.getPeriodOfHobby());
        personalInfoDto.setHobbyInfo(personalInfo.getHobbyInfo());
        return personalInfoDto;
    }

    public PersonalInfo inputDtoToPersonalInfo(PersonalInfoInputDto personalInfoInputDto) {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setHobby(personalInfoInputDto.getHobby());
        personalInfo.setPeriodOfHobby(personalInfoInputDto.getPeriodOfHobby());
        personalInfo.setHobbyInfo(personalInfoInputDto.getHobbyInfo());
        return personalInfo;
    }

    public List<PersonalInfoDto> getAllPersonalInfos() {
        return personalInfoRepos.findAll().stream()
                .map(this::personalInfoToDto)
                .collect(Collectors.toList());
    }

    public PersonalInfoDto createPersonalInfo(PersonalInfoInputDto personalInfoInputDto, Long cvId) {
        CV cv = cVRepos.findById(cvId)
                .orElseThrow(() -> new RecordNotFoundException("CV niet gevonden met id: " + cvId));

        PersonalInfo personalInfo = inputDtoToPersonalInfo(personalInfoInputDto);
        personalInfo.setCv(cv);
        personalInfo = personalInfoRepos.save(personalInfo);
        return personalInfoToDto(personalInfo);
    }

    public PersonalInfoDto updatePersonalInfo(Long id, PersonalInfoInputDto personalInfoInputDto) {
        PersonalInfo existingPersonalInfo = personalInfoRepos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Geen PersonalInfo gevonden met dit ID"));

        existingPersonalInfo.setHobby(personalInfoInputDto.getHobby());
        existingPersonalInfo.setPeriodOfHobby(personalInfoInputDto.getPeriodOfHobby());
        existingPersonalInfo.setHobbyInfo(personalInfoInputDto.getHobbyInfo());
        existingPersonalInfo = personalInfoRepos.save(existingPersonalInfo);

        return personalInfoToDto(existingPersonalInfo);
    }

    public void deletePersonalInfo(Long id) {
        personalInfoRepos.deleteById(id);
    }
}
