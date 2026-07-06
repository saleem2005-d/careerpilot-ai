import { useEffect, useState } from "react";
import { tailorResume } from "../api/resumeApi";
import type { ResumeTailorResponse } from "../api/resumeApi";

function ResumeTailor() {
  const [resumeText, setResumeText] = useState("");
  const [jobDescription, setJobDescription] = useState("");
  const [result, setResult] = useState<ResumeTailorResponse | null>(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const savedResume = localStorage.getItem("resumeText");

    if (savedResume) {
      setResumeText(savedResume);
    }
  }, []);

  async function handleTailor() {
    if (!resumeText || !jobDescription) {
      alert("Please fill both fields.");
      return;
    }

    try {
      setLoading(true);

      const response = await tailorResume({
        resumeText,
        jobDescription,
      });

      setResult(response);
    } catch (error) {
      console.error(error);
      alert("Resume tailoring failed.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="upload-container">
      <div className="upload-card">
        <h1>AI Resume Tailoring</h1>

        <textarea
          rows={12}
          placeholder="Resume Text"
          value={resumeText}
          onChange={(e) => setResumeText(e.target.value)}
          style={{ width: "100%", marginBottom: 20 }}
        />

        <textarea
          rows={12}
          placeholder="Paste Job Description..."
          value={jobDescription}
          onChange={(e) => setJobDescription(e.target.value)}
          style={{ width: "100%", marginBottom: 20 }}
        />

        <button
          className="upload-button"
          onClick={handleTailor}
          disabled={loading}
        >
          {loading ? "Tailoring..." : "Tailor Resume"}
        </button>

        {result && (
          <>
            <hr />

            <h2>ATS Optimized Resume</h2>

            <textarea
              rows={20}
              value={result.tailoredResume}
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

export default ResumeTailor;