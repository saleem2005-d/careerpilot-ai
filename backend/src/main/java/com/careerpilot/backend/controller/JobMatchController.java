package com.careerpilot.backend.controller;

import com.careerpilot.backend.dto.JobMatchRequest;
import com.careerpilot.backend.dto.JobMatchResponse;
import com.careerpilot.backend.service.JobMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job")
@CrossOrigin(origins = "*")
public class JobMatchController {

    @Autowired
    private JobMatchService jobMatchService;

    @PostMapping("/match")
    public JobMatchResponse matchResume(
            @RequestBody JobMatchRequest request
    ) {

        return jobMatchService.match(request);
    }
}