import { useEffect, useState } from "react";
import {
  generateInterviewQuestions,
  type InterviewResponse,
} from "../api/resumeApi";

function InterviewGenerator() {
  const [resumeText, setResumeText] = useState("");
  const [jobDescription, setJobDescription] = useState("");
  const [result, setResult] = useState<InterviewResponse | null>(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const savedResume = localStorage.getItem("resumeText");

    if (savedResume) {
      setResumeText(savedResume);
    }
  }, []);

  async function handleGenerate() {
    if (!resumeText || !jobDescription) {
      alert("Please fill both fields.");
      return;
    }

    try {
      setLoading(true);

      const response = await generateInterviewQuestions({
        resumeText,
        jobDescription,
      });

      setResult(response);
    } catch (error) {
      console.error(error);
      alert("Failed to generate interview questions.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="upload-container">
      <div className="upload-card">
        <h1>AI Interview Generator</h1>

        <textarea
          rows={12}
          placeholder="Resume Text"
          value={resumeText}
          onChange={(e) => setResumeText(e.target.value)}
          style={{
            width: "100%",
            marginBottom: "20px",
          }}
        />

        <textarea
          rows={12}
          placeholder="Job Description"
          value={jobDescription}
          onChange={(e) => setJobDescription(e.target.value)}
          style={{
            width: "100%",
            marginBottom: "20px",
          }}
        />

        <button
          className="upload-button"
          onClick={handleGenerate}
          disabled={loading}
        >
          {loading
            ? "Generating..."
            : "Generate Interview Questions"}
        </button>

        {result && (
          <>
            <hr />

            <h2>Technical Questions</h2>

            <ul>
              {result.technicalQuestions.map((question, index) => (
                <li key={index}>{question}</li>
              ))}
            </ul>

            <hr />

            <h2>Behavioral Questions</h2>

            <ul>
              {result.behavioralQuestions.map((question, index) => (
                <li key={index}>{question}</li>
              ))}
            </ul>

            <hr />

            <h2>HR Questions</h2>

            <ul>
              {result.hrQuestions.map((question, index) => (
                <li key={index}>{question}</li>
              ))}
            </ul>
          </>
        )}
      </div>
    </div>
  );
}

export default InterviewGenerator;