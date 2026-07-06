package com.careerpilot.backend.dto;

import java.util.ArrayList;
import java.util.List;

public class ResumeScore {

    private int overallScore;

    private int skillsScore;

    private int educationScore;

    private int projectsScore;

    private int certificationsScore;

    private int experienceScore;

    private List<String> strengths = new ArrayList<>();

    private List<String> missingSkills = new ArrayList<>();

    private List<String> suggestions = new ArrayList<>();

    public ResumeScore() {
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    public int getSkillsScore() {
        return skillsScore;
    }

    public void setSkillsScore(int skillsScore) {
        this.skillsScore = skillsScore;
    }

    public int getEducationScore() {
        return educationScore;
    }

    public void setEducationScore(int educationScore) {
        this.educationScore = educationScore;
    }

    public int getProjectsScore() {
        return projectsScore;
    }

    public void setProjectsScore(int projectsScore) {
        this.projectsScore = projectsScore;
    }

    public int getCertificationsScore() {
        return certificationsScore;
    }

    public void setCertificationsScore(int certificationsScore) {
        this.certificationsScore = certificationsScore;
    }

    public int getExperienceScore() {
        return experienceScore;
    }

    public void setExperienceScore(int experienceScore) {
        this.experienceScore = experienceScore;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }
}