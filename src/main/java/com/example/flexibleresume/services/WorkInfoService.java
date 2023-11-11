package com.example.flexibleresume.services;

import com.example.flexibleresume.dtos.WorkInfoDto;
import com.example.flexibleresume.dtos.WorkInfoInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.CV;

import com.example.flexibleresume.models.WorkInfo;
import com.example.flexibleresume.repositorys.CVRepository;

import com.example.flexibleresume.repositorys.WorkInfoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkInfoService {

    private final WorkInfoRepository workInfoRepos;
    private final CVRepository cVRepos;


    public WorkInfoDto workInfoToDto(WorkInfo workInfo) {
        var workInfoDto = new WorkInfoDto();

        workInfoDto.setCompany(workInfo.getCompany());
        workInfoDto.setJobTitle(workInfo.getJobTitle());
        workInfoDto.setPeriodOfEmployment(workInfo.getPeriodOfEmployment());
        workInfoDto.setJobInfo(workInfo.getJobInfo());

        if (workInfo.getCv() != null) {
            workInfoDto.setCvId(workInfo.getCv().getId());
        }

        return workInfoDto;

    }

    public WorkInfo inputDtoToWorkInfo(WorkInfoInputDto workInfoInputDto) {
        var workInfo = new WorkInfo();


        workInfo.setCompany(workInfoInputDto.getCompany());
        workInfo.setJobTitle(workInfoInputDto.getJobTitle());
        workInfo.setPeriodOfEmployment(workInfoInputDto.getPeriodOfEmployment());
        workInfo.setJobInfo(workInfoInputDto.getJobInfo());

        return workInfo;

    }


    public List<WorkInfo> getAllWorkInfos(Optional<Long> id) {
        if (id.isPresent()) {
            Optional<WorkInfo> workInfoOptional = workInfoRepos.findById(id.get());
            return List.of(workInfoOptional.get());
        }
        return workInfoRepos.findAll();

    }


    public WorkInfoDto createWorkInfo(WorkInfoInputDto workInfoInputDto, Long cvId) {

        CV cv = cVRepos.findById(cvId)
                .orElseThrow(() -> new RecordNotFoundException("CV niet gevonden met id: " + cvId));

        WorkInfo workInfo = inputDtoToWorkInfo(workInfoInputDto);

        workInfo.setCv(cv); // Koppel het CV-object aan WorkInfo
        workInfo = workInfoRepos.save(workInfo); // Sla de WorkInfo op


        return workInfoToDto(workInfo);
    }



    public List<WorkInfoDto> getWorkInfoById(Long id) {
        List<WorkInfo> workInfos = workInfoRepos.findByCvId(id);
        if (workInfos.isEmpty()) {
            throw new RecordNotFoundException("Geen WorkInfo gevonden");
        }

        return workInfos.stream()
                .map(this::workInfoToDto)
                .collect(Collectors.toList());
    }

    public WorkInfoDto updateWorkInfo(Long id, WorkInfoInputDto workInfoInputDto) {
        WorkInfo existingWorkInfo = workInfoRepos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Geen WorkInfo gevonden met dit ID"));

        existingWorkInfo.setCompany(workInfoInputDto.getCompany());
        existingWorkInfo.setJobTitle(workInfoInputDto.getJobTitle());
        existingWorkInfo.setPeriodOfEmployment(workInfoInputDto.getPeriodOfEmployment());
        existingWorkInfo.setJobInfo(workInfoInputDto.getJobInfo());

        existingWorkInfo = workInfoRepos.save(existingWorkInfo);

        return workInfoToDto(existingWorkInfo);
    }




    public void deleteWorkInfo(Long id) {
        workInfoRepos.deleteById(id);
    }



    }



