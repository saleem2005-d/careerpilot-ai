package com.careerpilot.backend.analysis;

import com.careerpilot.backend.dto.ResumeAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ResumeAnalysisService {

    @Autowired
    private ResumeScoreService resumeScoreService;

    public ResumeAnalysis analyze(String text) {

        ResumeAnalysis analysis = new ResumeAnalysis();

        if (text == null) {
            text = "";
        }

        analysis.setExtractedText(text);

        // ------------------------
        // Email
        // ------------------------
        Pattern emailPattern = Pattern.compile(
                "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+"
        );

        Matcher emailMatcher = emailPattern.matcher(text);

        if (emailMatcher.find()) {
            analysis.setEmail(emailMatcher.group());
        }

        // ------------------------
        // Phone
        // ------------------------
        Pattern phonePattern = Pattern.compile(
                "(\\+91[- ]?)?[6-9]\\d{9}"
        );

        Matcher phoneMatcher = phonePattern.matcher(text);

        if (phoneMatcher.find()) {
            analysis.setPhone(phoneMatcher.group());
        }

        // ------------------------
        // Name
        // ------------------------
        String[] lines = text.split("\\r?\\n");

        for (String line : lines) {

            line = line.trim();

            if (!line.isEmpty()
                    && line.length() > 3
                    && !line.contains("@")
                    && !line.matches(".*\\d.*")) {

                analysis.setName(line);
                break;
            }
        }

        // ------------------------
        // Education
        // ------------------------
        String lower = text.toLowerCase();

        if (lower.contains("b.tech")) {
            analysis.setEducation("B.Tech");
        } else if (lower.contains("btech")) {
            analysis.setEducation("B.Tech");
        } else if (lower.contains("bachelor")) {
            analysis.setEducation("Bachelor");
        } else if (lower.contains("master")) {
            analysis.setEducation("Master");
        } else {
            analysis.setEducation("-");
        }

        // ------------------------
        // Experience
        // ------------------------
        if (lower.contains("experience")) {
            analysis.setExperience("Experience Found");
        } else if (lower.contains("intern")) {
            analysis.setExperience("Internship");
        } else {
            analysis.setExperience("Fresher");
        }

        // ------------------------
        // Skills
        // ------------------------
        List<String> skills = new ArrayList<>();

        String[] skillKeywords = {
                "Java",
                "Spring Boot",
                "React",
                "ReactJS",
                "TypeScript",
                "JavaScript",
                "HTML",
                "CSS",
                "Python",
                "C",
                "C++",
                "SQL",
                "PostgreSQL",
                "MySQL",
                "Git",
                "GitHub",
                "Docker",
                "AWS",
                "REST API",
                "Hibernate",
                "Maven"
        };

        for (String skill : skillKeywords) {

            if (lower.contains(skill.toLowerCase())) {
                skills.add(skill);
            }
        }

        analysis.setSkills(skills);
                // ------------------------
        // Projects
        // ------------------------
        List<String> projects = new ArrayList<>();

        if (lower.contains("project")) {
            projects.add("Projects Section Found");
        }

        analysis.setProjects(projects);

        // ------------------------
        // Certifications
        // ------------------------
        List<String> certifications = new ArrayList<>();

        if (lower.contains("certification")) {
            certifications.add("Certification Found");
        }

        if (lower.contains("certificate")) {
            certifications.add("Certificate Found");
        }

        analysis.setCertifications(certifications);

        // ------------------------
        // Calculate Resume Score
        // ------------------------
        analysis.setScore(
                resumeScoreService.calculateScore(analysis)
        );

        // ------------------------
        // Debug Logs
        // ------------------------
        System.out.println("========== Resume Analysis ==========");
        System.out.println("Name        : " + analysis.getName());
        System.out.println("Email       : " + analysis.getEmail());
        System.out.println("Phone       : " + analysis.getPhone());
        System.out.println("Education   : " + analysis.getEducation());
        System.out.println("Experience  : " + analysis.getExperience());
        System.out.println("Skills      : " + analysis.getSkills());
        System.out.println("Projects    : " + analysis.getProjects());
        System.out.println("Certificates: " + analysis.getCertifications());

        System.out.println("Overall Score : " +
                analysis.getScore().getOverallScore());

        System.out.println("Strengths     : " +
                analysis.getScore().getStrengths());

        System.out.println("Missing Skills: " +
                analysis.getScore().getMissingSkills());

        System.out.println("Suggestions   : " +
                analysis.getScore().getSuggestions());

        System.out.println("=====================================");

        return analysis;
    }
}