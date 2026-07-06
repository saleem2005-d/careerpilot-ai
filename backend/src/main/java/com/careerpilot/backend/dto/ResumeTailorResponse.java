package com.careerpilot.backend.dto;

public class ResumeTailorResponse {

    private String tailoredResume;

    public ResumeTailorResponse() {
    }

    public ResumeTailorResponse(String tailoredResume) {
        this.tailoredResume = tailoredResume;
    }

    public String getTailoredResume() {
        return tailoredResume;
    }

    public void setTailoredResume(String tailoredResume) {
        this.tailoredResume = tailoredResume;
    }
}