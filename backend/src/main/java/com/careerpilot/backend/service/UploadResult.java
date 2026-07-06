package com.careerpilot.backend.service;

import com.careerpilot.backend.dto.ResumeAnalysis;
import com.careerpilot.backend.entity.Resume;

public class UploadResult {

    private Resume resume;
    private ResumeAnalysis analysis;

    public UploadResult(Resume resume, ResumeAnalysis analysis) {
        this.resume = resume;
        this.analysis = analysis;
    }

    public Resume getResume() {
        return resume;
    }

    public ResumeAnalysis getAnalysis() {
        return analysis;
    }
}