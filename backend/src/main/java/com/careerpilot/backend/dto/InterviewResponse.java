package com.careerpilot.backend.dto;

import java.util.List;

public class InterviewResponse {

    private List<String> technicalQuestions;
    private List<String> behavioralQuestions;
    private List<String> hrQuestions;

    public InterviewResponse() {
    }

    public InterviewResponse(
            List<String> technicalQuestions,
            List<String> behavioralQuestions,
            List<String> hrQuestions) {

        this.technicalQuestions = technicalQuestions;
        this.behavioralQuestions = behavioralQuestions;
        this.hrQuestions = hrQuestions;
    }

    public List<String> getTechnicalQuestions() {
        return technicalQuestions;
    }

    public void setTechnicalQuestions(List<String> technicalQuestions) {
        this.technicalQuestions = technicalQuestions;
    }

    public List<String> getBehavioralQuestions() {
        return behavioralQuestions;
    }

    public void setBehavioralQuestions(List<String> behavioralQuestions) {
        this.behavioralQuestions = behavioralQuestions;
    }

    public List<String> getHrQuestions() {
        return hrQuestions;
    }

    public void setHrQuestions(List<String> hrQuestions) {
        this.hrQuestions = hrQuestions;
    }
}