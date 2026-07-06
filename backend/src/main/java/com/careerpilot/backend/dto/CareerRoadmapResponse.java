package com.careerpilot.backend.dto;

public class CareerRoadmapResponse {

    private String roadmap;

    public CareerRoadmapResponse() {
    }

    public CareerRoadmapResponse(String roadmap) {
        this.roadmap = roadmap;
    }

    public String getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(String roadmap) {
        this.roadmap = roadmap;
    }
}