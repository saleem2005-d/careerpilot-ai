package com.careerpilot.backend.dto;

import java.util.ArrayList;
import java.util.List;

public class ResumeAnalysis {

    private String name;

    private String email;

    private String phone;

    private String education;

    private String experience;

    private String extractedText;

    private List<String> skills = new ArrayList<>();

    private List<String> projects = new ArrayList<>();

    private List<String> certifications = new ArrayList<>();

    // Resume Score
    private ResumeScore score;

    public ResumeAnalysis() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExtractedText() {
        return extractedText;
    }

    public void setExtractedText(String extractedText) {
        this.extractedText = extractedText;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public ResumeScore getScore() {
        return score;
    }

    public void setScore(ResumeScore score) {
        this.score = score;
    }
}