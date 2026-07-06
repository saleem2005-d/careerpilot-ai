package com.careerpilot.backend.controller;

import com.careerpilot.backend.dto.InterviewRequest;
import com.careerpilot.backend.dto.InterviewResponse;
import com.careerpilot.backend.service.InterviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interview")
@CrossOrigin(origins = "*")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/generate")
    public InterviewResponse generateInterviewQuestions(
            @Valid @RequestBody InterviewRequest request) {

        return interviewService.generateQuestions(request);
    }
}