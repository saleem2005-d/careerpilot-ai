package com.careerpilot.backend.analysis;

import com.careerpilot.backend.dto.ResumeAnalysis;
import com.careerpilot.backend.dto.ResumeScore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeScoreService {

    public ResumeScore calculateScore(ResumeAnalysis analysis) {

        ResumeScore score = new ResumeScore();

        int overall = 0;

        // Skills
        int skillsScore = Math.min(analysis.getSkills().size() * 5, 30);
        overall += skillsScore;
        score.setSkillsScore(skillsScore);

        // Education
        int educationScore = 0;
        if (!"-".equals(analysis.getEducation())) {
            educationScore = 15;
        }
        overall += educationScore;
        score.setEducationScore(educationScore);

        // Projects
        int projectsScore = analysis.getProjects().isEmpty() ? 0 : 20;
        overall += projectsScore;
        score.setProjectsScore(projectsScore);

        // Certifications
        int certificationScore = analysis.getCertifications().isEmpty() ? 0 : 15;
        overall += certificationScore;
        score.setCertificationsScore(certificationScore);

        // Experience
        int experienceScore = 0;

        if ("Experience Found".equals(analysis.getExperience())) {
            experienceScore = 20;
        } else if ("Internship".equals(analysis.getExperience())) {
            experienceScore = 15;
        } else {
            experienceScore = 5;
        }

        overall += experienceScore;
        score.setExperienceScore(experienceScore);

        if (overall > 100) {
            overall = 100;
        }

        score.setOverallScore(overall);

        List<String> strengths = new ArrayList<>();

        if (skillsScore >= 20)
            strengths.add("Good technical skills");

        if (projectsScore > 0)
            strengths.add("Projects included");

        if (certificationScore > 0)
            strengths.add("Certifications included");

        if (experienceScore >= 15)
            strengths.add("Experience section available");

        score.setStrengths(strengths);

        List<String> missingSkills = new ArrayList<>();

        String[] recommended = {
                "Java",
                "Spring Boot",
                "React",
                "SQL",
                "Git",
                "Docker",
                "AWS"
        };

        for (String skill : recommended) {
            if (!analysis.getSkills().contains(skill)) {
                missingSkills.add(skill);
            }
        }

        score.setMissingSkills(missingSkills);

        List<String> suggestions = new ArrayList<>();

        if (skillsScore < 20)
            suggestions.add("Add more technical skills.");

        if (projectsScore == 0)
            suggestions.add("Add at least 2 projects.");

        if (certificationScore == 0)
            suggestions.add("Include certifications.");

        if ("Fresher".equals(analysis.getExperience()))
            suggestions.add("Mention internships or practical experience.");

        suggestions.add("Keep resume within one page.");
        suggestions.add("Use ATS-friendly formatting.");

        score.setSuggestions(suggestions);

        return score;
    }
}