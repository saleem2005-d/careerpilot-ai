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

export interface ResumeTailorRequest {
  resumeText: string;
  jobDescription: string;
}

export interface ResumeTailorResponse {
  tailoredResume: string;
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

export const matchResume = async (
  request: JobMatchRequest
): Promise<JobMatchResponse> => {

  const response = await API.post<JobMatchResponse>(
    "/job/match",
    request
  );

  return response.data;
};

export const tailorResume = async (
  request: ResumeTailorRequest
): Promise<ResumeTailorResponse> => {

  const response = await API.post<ResumeTailorResponse>(
    "/resume/tailor",
    request
  );

  return response.data;
};
export interface InterviewRequest {
  resumeText: string;
  jobDescription: string;
}

export interface InterviewResponse {
  technicalQuestions: string[];
  behavioralQuestions: string[];
  hrQuestions: string[];
}

export const generateInterviewQuestions = async (
  request: InterviewRequest
): Promise<InterviewResponse> => {

  const response = await API.post<InterviewResponse>(
    "/interview/generate",
    request
  );

  return response.data;
};
export interface CoverLetterRequest {
  resumeText: string;
  jobDescription: string;
}

export interface CoverLetterResponse {
  coverLetter: string;
}

export const generateCoverLetter = async (
  request: CoverLetterRequest
): Promise<CoverLetterResponse> => {

  const response = await API.post<CoverLetterResponse>(
    "/cover-letter/generate",
    request
  );

  return response.data;
};