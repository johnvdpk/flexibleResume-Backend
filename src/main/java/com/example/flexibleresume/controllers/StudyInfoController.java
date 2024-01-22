package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.StudyInfoDto;
import com.example.flexibleresume.dtos.StudyInfoInputDto;
import com.example.flexibleresume.exceptions.ErrorResponse;
import com.example.flexibleresume.services.StudyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/jobseeker/studyinfo")
public class StudyInfoController {

    private final StudyInfoService studyInfoService;

    @GetMapping
    public ResponseEntity<List<StudyInfoDto>> getAllStudyInfos() {
        List<StudyInfoDto> studyInfos = studyInfoService.getAllStudyInfos();
        if(studyInfos == null) {
            ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het ophalen van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok().body(studyInfos);
    }

    @GetMapping("/{cvId}")
    public ResponseEntity<List<StudyInfoDto>> getStudyInfoByCvId(@PathVariable Long cvId) {
        List<StudyInfoDto> studyInfoDtos = studyInfoService.getStudyInfoByCvId(cvId);
        if(studyInfoDtos == null) {
           ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het ophalen van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok().body(studyInfoDtos);
    }
    @PostMapping("/{cvId}")
    public ResponseEntity<StudyInfoDto> createStudyInfo(@PathVariable Long cvId,
                                                        @RequestBody StudyInfoInputDto studyInfoInputDto) {
        StudyInfoDto studyInfoDto = studyInfoService.createStudyInfo(studyInfoInputDto, cvId);
        if(studyInfoDto == null) {
            ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij posten van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(studyInfoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyInfoDto> updateStudyInfo(@PathVariable Long id,
                                                        @RequestBody StudyInfoInputDto studyInfoInputDto) {
        StudyInfoDto updatedStudyInfo = studyInfoService.updateStudyInfo(id, studyInfoInputDto);
        if(updatedStudyInfo == null) {
            ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het updaten van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(updatedStudyInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyInfo(@PathVariable Long id) {
        studyInfoService.deleteStudyInfo(id);
        return ResponseEntity.noContent().build();
    }
}
