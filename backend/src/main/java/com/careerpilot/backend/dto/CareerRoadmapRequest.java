package com.careerpilot.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class CareerRoadmapRequest {

    @NotBlank(message = "Current skills are required")
    private String currentSkills;

    @NotBlank(message = "Target role is required")
    private String targetRole;

    @NotBlank(message = "Experience level is required")
    private String experienceLevel;

    public CareerRoadmapRequest() {
    }

    public CareerRoadmapRequest(String currentSkills, String targetRole, String experienceLevel) {
        this.currentSkills = currentSkills;
        this.targetRole = targetRole;
        this.experienceLevel = experienceLevel;
    }

    public String getCurrentSkills() {
        return currentSkills;
    }

    public void setCurrentSkills(String currentSkills) {
        this.currentSkills = currentSkills;
    }

    public String getTargetRole() {
        return targetRole;
    }

    public void setTargetRole(String targetRole) {
        this.targetRole = targetRole;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}