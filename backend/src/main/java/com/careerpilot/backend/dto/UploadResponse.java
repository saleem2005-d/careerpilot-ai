package com.careerpilot.backend.dto;

public class UploadResponse {

    private boolean success;
    private String message;
    private String fileName;
    private Long resumeId;
    private ResumeAnalysis analysis;

    public UploadResponse() {
    }

    public UploadResponse(boolean success,
                          String message,
                          String fileName,
                          Long resumeId,
                          ResumeAnalysis analysis) {
        this.success = success;
        this.message = message;
        this.fileName = fileName;
        this.resumeId = resumeId;
        this.analysis = analysis;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getResumeId() {
        return resumeId;
    }

    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    public ResumeAnalysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(ResumeAnalysis analysis) {
        this.analysis = analysis;
    }
}