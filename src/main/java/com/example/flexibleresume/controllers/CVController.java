package com.example.flexibleresume.controllers;


import com.example.flexibleresume.dtos.CVDto;
import com.example.flexibleresume.dtos.CVInputDto;
import com.example.flexibleresume.file.FileUploadResponse;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.services.CVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.MediaType;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/jobseeker/cv")
public class CVController {

    final private CVService cVService;


    @GetMapping
    public ResponseEntity<List<CV>> getAllCVs(@RequestParam (value = "id", required = false) Optional<Long> id) {
        List<CV> CVs = cVService.getAllCVs(id);
        if (CVs == null) {
            CVs = Collections.emptyList();
        }
        return ResponseEntity.ok().body(CVs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCVById(@PathVariable Long id) {
        CVDto cVDto = cVService.getCVById(id);
        if (cVDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CV met ID " + id + " is niet gevonden.");
        }

        return ResponseEntity.ok(cVDto);
    }

    @PutMapping("/cv/{cvId}")
    public ResponseEntity<CVDto> updateCV(@PathVariable Long cvId, @RequestBody CVInputDto cvInputDto) {
        CVDto updatedCV = cVService.updateCV(cvId, cvInputDto);
        if(updatedCV == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedCV);
    }


    @PostMapping("/upload")
    public FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("cvId") Long cvId) throws IOException {
        CV cv = cVService.uploadFileDocument(file, cvId);
        String url = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/jobseeker/cv/download/")
                .path(Objects.requireNonNull(file.getOriginalFilename()))
                .toUriString();

        String contentType = file.getContentType();

        return new FileUploadResponse(cv.getFileName(), url, contentType);
    }

    @GetMapping("/download/{fileName}")
    ResponseEntity<byte[]> downLoadSingleFile(@PathVariable String fileName, HttpServletRequest request) {
        CV document = cVService.singleFileDownload(fileName, request);

        String mimeType = request.getServletContext().getMimeType(document.getFileName());
        if (mimeType == null) {
            mimeType = "application/octet-stream"; // Standaard MIME-type voor onbekende bestandstypes
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + document.getFileName())
                .body(document.getDocFile());
    }


}

