package com.example.flexibleresume.controllers;


import com.example.flexibleresume.dtos.CVDto;
import com.example.flexibleresume.dtos.CVInputDto;
import com.example.flexibleresume.file.FileUploadResponse;
import com.example.flexibleresume.models.CV;
import com.example.flexibleresume.services.CVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.MediaType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
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

    @PutMapping("/cv/{cvId}")
    public ResponseEntity<CVDto> updateCV(@PathVariable Long cvId, @RequestBody CVInputDto cvInputDto) {
        CVDto updatedCV = cVService.updateCV(cvId, cvInputDto);
        return ResponseEntity.ok(updatedCV);
    }

    @PostMapping("/upload")
    public FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {


        CV cv = cVService.uploadFileDocument(file);
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/werkzoekende/cv/download/").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString();

        String contentType = file.getContentType();

        return new FileUploadResponse(cv.getFileName(), url, contentType );
    }

    @GetMapping("/download/{fileName}")
    ResponseEntity<byte[]> downLoadSingleFile(@PathVariable String fileName, HttpServletRequest request) {

        CV document = cVService.singleFileDownload(fileName, request);


        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + document.getFileName()).body(document.getDocFile());
    }


//    @GetMapping("/download/{fileName}")
//    ResponseEntity<byte[]> downLoadSingleFile(@PathVariable String fileName, HttpServletRequest request) {
//        CV cv = cVService.singleFileDownload(fileName);
//        String mimeType = request.getServletContext().getMimeType(cv.getFileName());
//        mimeType = mimeType != null ? mimeType : "application/octet-stream";
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(mimeType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + cv.getFileName())
//                .body(cv.getDocFile());
//    }

}

