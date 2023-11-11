package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.StudyInfoDto;
import com.example.flexibleresume.dtos.StudyInfoInputDto;
import com.example.flexibleresume.models.StudyInfo;
import com.example.flexibleresume.services.StudyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/werkzoekende/studieinfo")
public class StudyInfoController {

    private final StudyInfoService studyInfoService;

    @GetMapping("/all")
    public ResponseEntity<List<StudyInfoDto>> getAllStudyInfos() {
        List<StudyInfoDto> studyInfos = studyInfoService.getAllStudyInfos();
        return ResponseEntity.ok().body(studyInfos);
    }

    @PostMapping("/{cvId}")
    public ResponseEntity<StudyInfoDto> createStudyInfo(@PathVariable Long cvId,
                                                        @RequestBody StudyInfoInputDto studyInfoInputDto) {
        StudyInfoDto studyInfoDto = studyInfoService.createStudyInfo(studyInfoInputDto, cvId);
        return ResponseEntity.status(HttpStatus.CREATED).body(studyInfoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyInfoDto> updateStudyInfo(@PathVariable Long id,
                                                        @RequestBody StudyInfoInputDto studyInfoInputDto) {
        StudyInfoDto updatedStudyInfo = studyInfoService.updateStudyInfo(id, studyInfoInputDto);
        return ResponseEntity.ok(updatedStudyInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyInfo(@PathVariable Long id) {
        studyInfoService.deleteStudyInfo(id);
        return ResponseEntity.noContent().build();
    }
}
