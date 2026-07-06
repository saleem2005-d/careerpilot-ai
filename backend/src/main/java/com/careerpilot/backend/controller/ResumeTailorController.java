package com.careerpilot.backend.controller;

import com.careerpilot.backend.dto.ResumeTailorRequest;
import com.careerpilot.backend.dto.ResumeTailorResponse;
import com.careerpilot.backend.service.ResumeTailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "*")
public class ResumeTailorController {

    @Autowired
    private ResumeTailorService resumeTailorService;

    @PostMapping("/tailor")
    public ResumeTailorResponse tailorResume(
            @RequestBody ResumeTailorRequest request) {

        return resumeTailorService.tailorResume(request);
    }
}