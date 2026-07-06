import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api",
});

export interface ResumeScore {
  overallScore: number;
  skillsScore: number;
  educationScore: number;
  projectsScore: number;
  certificationsScore: number;
  experienceScore: number;

  strengths: string[];
  missingSkills: string[];
  suggestions: string[];
}

export interface ResumeAnalysis {
  name: string;
  email: string;
  phone: string;
  education: string;
  experience: string;
  extractedText: string;

  skills: string[];
  projects: string[];
  certifications: string[];

  score: ResumeScore;
}

export interface UploadResponse {
  success: boolean;
  message: string;
  fileName: string;
  resumeId: number;
  analysis: ResumeAnalysis;
}

export const uploadResume = async (
  file: File
): Promise<UploadResponse> => {
  const formData = new FormData();

  formData.append("file", file);

  const response = await API.post<UploadResponse>(
    "/upload",
    formData,
    {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    }
  );

  return response.data;
};

// ===============================
// Job Match Interfaces
// ===============================

export interface JobMatchRequest {
  resumeText: string;
  jobDescription: string;
}

export interface JobMatchResponse {
  matchScore: number;
  matchedSkills: string[];
  missingSkills: string[];
  suggestions: string[];
}

export const matchResume = async (
  request: JobMatchRequest
): Promise<JobMatchResponse> => {
  const response = await API.post<JobMatchResponse>(
    "/job/match",
    request
  );

  return response.data;
};