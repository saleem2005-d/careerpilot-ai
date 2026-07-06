package com.careerpilot.backend.controller;

import com.careerpilot.backend.dto.CareerRoadmapRequest;
import com.careerpilot.backend.dto.CareerRoadmapResponse;
import com.careerpilot.backend.service.CareerRoadmapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/career-roadmap")
@CrossOrigin(origins = "*")
public class CareerRoadmapController {

    @Autowired
    private CareerRoadmapService careerRoadmapService;

    @PostMapping("/generate")
    public CareerRoadmapResponse generateRoadmap(
            @Valid @RequestBody CareerRoadmapRequest request) {

        return careerRoadmapService.generateRoadmap(request);
    }
}