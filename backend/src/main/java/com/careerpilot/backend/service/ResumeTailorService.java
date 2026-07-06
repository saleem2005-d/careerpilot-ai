package com.careerpilot.backend.service;

import com.careerpilot.backend.dto.ResumeTailorRequest;
import com.careerpilot.backend.dto.ResumeTailorResponse;
import org.springframework.stereotype.Service;

@Service
public class ResumeTailorService {

    public ResumeTailorResponse tailorResume(ResumeTailorRequest request) {

        String resume = request.getResumeText();
        String job = request.getJobDescription();

        StringBuilder builder = new StringBuilder();

        builder.append("=========== ATS OPTIMIZED RESUME ===========\n\n");

        builder.append(resume);

        builder.append("\n\n");

        builder.append("=========== AI SUGGESTIONS ===========\n");

        if (!resume.toLowerCase().contains("java")
                && job.toLowerCase().contains("java")) {

            builder.append("• Add Java experience.\n");
        }

        if (!resume.toLowerCase().contains("spring")
                && job.toLowerCase().contains("spring")) {

            builder.append("• Mention Spring Boot projects.\n");
        }

        if (!resume.toLowerCase().contains("react")
                && job.toLowerCase().contains("react")) {

            builder.append("• Add React skills.\n");
        }

        if (!resume.toLowerCase().contains("sql")
                && job.toLowerCase().contains("sql")) {

            builder.append("• Include SQL database experience.\n");
        }

        if (!resume.toLowerCase().contains("docker")
                && job.toLowerCase().contains("docker")) {

            builder.append("• Learn Docker and mention it.\n");
        }

        if (!resume.toLowerCase().contains("aws")
                && job.toLowerCase().contains("aws")) {

            builder.append("• Add AWS cloud knowledge.\n");
        }

        builder.append("\n=========== JOB DESCRIPTION ===========\n\n");
        builder.append(job);

        return new ResumeTailorResponse(builder.toString());
    }
}