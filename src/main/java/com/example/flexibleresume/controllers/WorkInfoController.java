package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.dtos.JobSeekerInputDto;
import com.example.flexibleresume.dtos.WorkInfoDto;
import com.example.flexibleresume.dtos.WorkInfoInputDto;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.models.WorkInfo;
import com.example.flexibleresume.services.WorkInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/werkzoekende/werkinfo")
public class WorkInfoController {


    private final WorkInfoService workInfoService;


    @GetMapping("/all")
    public ResponseEntity<List<WorkInfo>>getAllWorkinfos(@RequestParam(value = "id", required = false) Optional<Long> id) {
        List<WorkInfo> workInfo = workInfoService.getAllWorkInfos(id);

        return ResponseEntity.ok().body(workInfo);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<WorkInfoDto>> getWorkInfoById(@PathVariable Long id) {
        List<WorkInfoDto> workInfoDtos = workInfoService.getWorkInfoById(id);

        return ResponseEntity.ok().body(workInfoDtos);
    }

    @GetMapping("/{cvId}")
    public ResponseEntity<List<WorkInfoDto>> getWorkInfoByCvId(@PathVariable Long cvId) {
        List<WorkInfoDto> workInfoDtos = workInfoService.getWorkInfoByCvId(cvId);
        return ResponseEntity.ok().body(workInfoDtos);
    }

    @PostMapping("/{cvId}")
    public ResponseEntity<WorkInfoDto> createWorkInfo (@PathVariable Long cvId,
                                                       @RequestBody WorkInfoInputDto workInfoInputDto) {

        WorkInfoDto workInfoDto = workInfoService.createWorkInfo(workInfoInputDto, cvId);
        return ResponseEntity.status(HttpStatus.CREATED).body(workInfoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkInfoDto> updateWorkInfo(@PathVariable Long id, @RequestBody WorkInfoInputDto workInfoInputDto) {
        WorkInfoDto updatedWorkInfo = workInfoService.updateWorkInfo(id, workInfoInputDto);
        return ResponseEntity.ok(updatedWorkInfo);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkInfo(@PathVariable Long id) {
        workInfoService.deleteWorkInfo(id);
        return ResponseEntity.noContent().build();
    }
}