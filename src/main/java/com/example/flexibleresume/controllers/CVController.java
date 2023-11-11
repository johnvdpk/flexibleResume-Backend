package com.example.flexibleresume.controllers;


import com.example.flexibleresume.dtos.CVDto;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.services.CVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/werkzoekende/cv") // website is in het Nederlands
public class CVController {

    final private CVService cVService;


    @GetMapping
    public ResponseEntity<List<CV>> getAllCVs(@RequestParam (value = "id", required = false)Optional<Long> id) {
        List<CV> CVs = cVService.getAllCVs(id);

        return ResponseEntity.ok().body(CVs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CVDto> getCVById(@PathVariable Long id) {
        CVDto cVDto = cVService.getCVById(id);

        return ResponseEntity.ok(cVDto);
    }



}