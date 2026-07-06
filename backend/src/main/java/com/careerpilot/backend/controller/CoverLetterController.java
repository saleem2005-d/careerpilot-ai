package com.careerpilot.backend.controller;

import com.careerpilot.backend.dto.CoverLetterRequest;
import com.careerpilot.backend.dto.CoverLetterResponse;
import com.careerpilot.backend.service.CoverLetterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cover-letter")
@CrossOrigin(origins = "*")
public class CoverLetterController {

    @Autowired
    private CoverLetterService coverLetterService;

    @PostMapping("/generate")
    public CoverLetterResponse generateCoverLetter(
            @Valid @RequestBody CoverLetterRequest request) {

        return coverLetterService.generateCoverLetter(request);
    }
}