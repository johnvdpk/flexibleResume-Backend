package com.example.flexibleresume.controllers;

import com.example.flexibleresume.dtos.PersonalInfoDto;
import com.example.flexibleresume.dtos.PersonalInfoInputDto;
import com.example.flexibleresume.services.PersonalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/jobseeker/personalinfo")
public class PersonalInfoController {

    private final PersonalInfoService personalInfoService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonalInfoDto>> getAllPersonalInfos() {
        List<PersonalInfoDto> personalInfoDtos = personalInfoService.getAllPersonalInfos();

        if(personalInfoDtos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(personalInfoDtos);
    }

    @GetMapping("/{cvId}")
    public ResponseEntity<List<PersonalInfoDto>> getPersonalInfoByCvId(@PathVariable Long cvId) {
        List<PersonalInfoDto> personalInfoDtos = personalInfoService.getPersonalInfoByCvId(cvId);
        if (personalInfoDtos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(personalInfoDtos);
    }


    @PostMapping("/{cvId}")
    public ResponseEntity<PersonalInfoDto> createPersonalInfo(@PathVariable Long cvId,
                                                              @RequestBody PersonalInfoInputDto personalInfoInputDto) {
        PersonalInfoDto personalInfoDto = personalInfoService.createPersonalInfo(personalInfoInputDto, cvId);
        if(personalInfoDto == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(personalInfoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalInfoDto> updatePersonalInfo(@PathVariable Long id,
                                                              @RequestBody PersonalInfoInputDto personalInfoInputDto) {
        PersonalInfoDto updatedPersonalInfo = personalInfoService.updatePersonalInfo(id, personalInfoInputDto);
        if(updatedPersonalInfo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPersonalInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalInfo(@PathVariable Long id) {
        personalInfoService.deletePersonalInfo(id);

        return ResponseEntity.noContent().build();
    }
}