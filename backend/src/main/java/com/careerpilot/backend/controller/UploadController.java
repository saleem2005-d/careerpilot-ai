package com.careerpilot.backend.controller;

import com.careerpilot.backend.dto.UploadResponse;
import com.careerpilot.backend.service.UploadResult;
import com.careerpilot.backend.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public UploadResponse uploadResume(@RequestParam("file") MultipartFile file) {

        try {

            UploadResult result = uploadService.uploadResume(file);

            System.out.println("========== RESPONSE ==========");
            System.out.println("Resume ID   : " + result.getResume().getId());
            System.out.println("File Name   : " + result.getResume().getOriginalFileName());

            if (result.getAnalysis() != null) {
                System.out.println("Name        : " + result.getAnalysis().getName());
                System.out.println("Email       : " + result.getAnalysis().getEmail());
                System.out.println("Phone       : " + result.getAnalysis().getPhone());
                System.out.println("Skills      : " + result.getAnalysis().getSkills());
            } else {
                System.out.println("Analysis is NULL");
            }

            System.out.println("==============================");

            return new UploadResponse(
                    true,
                    "Resume uploaded successfully",
                    result.getResume().getOriginalFileName(),
                    result.getResume().getId(),
                    result.getAnalysis()
            );

        } catch (Exception e) {

    e.printStackTrace();

    return new UploadResponse(
            false,
            e.toString(),
            null,
            null,
            null
    );
}
    }
}