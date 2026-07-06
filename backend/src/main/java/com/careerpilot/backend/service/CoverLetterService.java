package com.careerpilot.backend.service;

import com.careerpilot.backend.dto.CoverLetterRequest;
import com.careerpilot.backend.dto.CoverLetterResponse;
import org.springframework.stereotype.Service;

@Service
public class CoverLetterService {

    public CoverLetterResponse generateCoverLetter(CoverLetterRequest request) {

        String resume = request.getResumeText();
        String job = request.getJobDescription();

        StringBuilder builder = new StringBuilder();

        builder.append("Dear Hiring Manager,\n\n");

        builder.append("I am excited to apply for the position described below.\n\n");

        builder.append("Based on my background and experience, I believe I can make valuable contributions to your team.\n\n");

        if (resume.toLowerCase().contains("java")) {
            builder.append("- Strong knowledge of Java development.\n");
        }

        if (resume.toLowerCase().contains("spring")) {
            builder.append("- Experience with Spring Boot and REST APIs.\n");
        }

        if (resume.toLowerCase().contains("react")) {
            builder.append("- Experience building modern React applications.\n");
        }

        if (resume.toLowerCase().contains("sql")) {
            builder.append("- Knowledge of SQL databases and backend development.\n");
        }

        if (resume.toLowerCase().contains("docker")) {
            builder.append("- Familiar with Docker and containerization.\n");
        }

        if (resume.toLowerCase().contains("aws")) {
            builder.append("- Basic knowledge of AWS cloud services.\n");
        }

        builder.append("\nI am passionate about learning new technologies, solving challenging problems, and building high-quality software. I am confident that my skills and enthusiasm would make me a valuable addition to your organization.\n\n");

        builder.append("Thank you for considering my application. I look forward to the opportunity to discuss how I can contribute to your team.\n\n");

        builder.append("Sincerely,\n");
        builder.append("Your Name");

        builder.append("\n\n-----------------------------\n");
        builder.append("Job Description Reference:\n\n");
        builder.append(job);

        return new CoverLetterResponse(builder.toString());
    }
}