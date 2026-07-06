package com.careerpilot.backend.service;

import com.careerpilot.backend.dto.InterviewRequest;
import com.careerpilot.backend.dto.InterviewResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewService {

    public InterviewResponse generateQuestions(InterviewRequest request) {

        String resume = request.getResumeText().toLowerCase();
        String job = request.getJobDescription().toLowerCase();

        List<String> technical = new ArrayList<>();
        List<String> behavioral = new ArrayList<>();
        List<String> hr = new ArrayList<>();

        if (resume.contains("java") || job.contains("java")) {
            technical.add("Explain the OOP principles in Java.");
            technical.add("What is the difference between HashMap and HashTable?");
        }

        if (resume.contains("spring") || job.contains("spring")) {
            technical.add("Explain Dependency Injection in Spring Boot.");
            technical.add("What is Spring Boot Auto Configuration?");
        }

        if (resume.contains("react") || job.contains("react")) {
            technical.add("What is the Virtual DOM?");
            technical.add("Explain React Hooks.");
        }

        if (resume.contains("sql") || job.contains("sql")) {
            technical.add("Explain INNER JOIN and LEFT JOIN.");
            technical.add("How do you optimize SQL queries?");
        }

        if (technical.isEmpty()) {
            technical.add("Explain your strongest technical skill.");
            technical.add("Describe one project you are proud of.");
        }

        behavioral.add("Tell me about yourself.");
        behavioral.add("Describe a challenging project you worked on.");
        behavioral.add("Tell me about a time you solved a difficult problem.");

        hr.add("Why should we hire you?");
        hr.add("Where do you see yourself in five years?");
        hr.add("Why do you want to work at our company?");

        return new InterviewResponse(
                technical,
                behavioral,
                hr
        );
    }
}