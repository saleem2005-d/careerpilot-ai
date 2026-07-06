import { useEffect, useState } from "react";
import {
  generateCoverLetter,
  type CoverLetterResponse,
} from "../api/resumeApi";

function CoverLetterGenerator() {
  const [resumeText, setResumeText] = useState("");
  const [jobDescription, setJobDescription] = useState("");
  const [result, setResult] = useState<CoverLetterResponse | null>(null);
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

      const response = await generateCoverLetter({
        resumeText,
        jobDescription,
      });

      setResult(response);
    } catch (error) {
      console.error(error);
      alert("Failed to generate cover letter.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="upload-container">
      <div className="upload-card">
        <h1>AI Cover Letter Generator</h1>

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
          {loading ? "Generating..." : "Generate Cover Letter"}
        </button>

        {result && (
          <>
            <hr />

            <h2>Generated Cover Letter</h2>

            <textarea
              rows={20}
              value={result.coverLetter}
              readOnly
              style={{
                width: "100%",
                padding: "12px",
                borderRadius: "8px",
              }}
            />
          </>
        )}
      </div>
    </div>
  );
}

export default CoverLetterGenerator;