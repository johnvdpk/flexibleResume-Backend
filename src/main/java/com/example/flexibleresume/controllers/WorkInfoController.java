package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.WorkInfoDto;
import com.example.flexibleresume.dtos.WorkInfoInputDto;
import com.example.flexibleresume.exceptions.ErrorResponse;
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
@RequestMapping("/jobseeker/workinfo")
public class WorkInfoController {


    private final WorkInfoService workInfoService;


    @GetMapping
    public ResponseEntity<List<WorkInfo>>getAllWorkinfos(@RequestParam(value = "id", required = false) Optional<Long> id) {
        List<WorkInfo> workInfo = workInfoService.getAllWorkInfos(id);
        if(workInfo == null) {
            workInfo = List.of();
        }

        return ResponseEntity.ok().body(workInfo);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<WorkInfoDto>> getWorkInfoById(@PathVariable Long id) {
        List<WorkInfoDto> workInfoDtos = workInfoService.getWorkInfoById(id);
        if( workInfoDtos == null) {
            ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het ophalen van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok().body(workInfoDtos);
    }

    @GetMapping("/{cvId}")
    public ResponseEntity<List<WorkInfoDto>> getWorkInfoByCvId(@PathVariable Long cvId) {
        List<WorkInfoDto> workInfoDtos = workInfoService.getWorkInfoByCvId(cvId);
        if(workInfoDtos == null) {
            ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het ophalen van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok().body(workInfoDtos);
    }

    @PostMapping("/{cvId}")
    public ResponseEntity<WorkInfoDto> createWorkInfo (@PathVariable Long cvId,
                                                       @RequestBody WorkInfoInputDto workInfoInputDto) {

        WorkInfoDto workInfoDto = workInfoService.createWorkInfo(workInfoInputDto, cvId);
        if(workInfoDto == null) {

            ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het posten van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(workInfoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkInfoDto> updateWorkInfo(@PathVariable Long id, @RequestBody WorkInfoInputDto workInfoInputDto) {
        WorkInfoDto updatedWorkInfo = workInfoService.updateWorkInfo(id, workInfoInputDto);
        if(updatedWorkInfo == null) {
            ErrorResponse error = new ErrorResponse("Er is een fout opgetreden bij het updaten van de gegevens.", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(updatedWorkInfo);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkInfo(@PathVariable Long id) {
        workInfoService.deleteWorkInfo(id);
        return ResponseEntity.noContent().build();
    }
}