import { useEffect, useState } from "react";
import { matchResume } from "../api/resumeApi";
import type { JobMatchResponse } from "../api/resumeApi";
function JobMatcher() {
  const [resumeText, setResumeText] = useState("");
  const [jobDescription, setJobDescription] = useState("");
  const [result, setResult] = useState<JobMatchResponse | null>(null);
  const [loading, setLoading] = useState(false);
  
  useEffect(() => {
  const savedResume = localStorage.getItem("resumeText");

  if (savedResume) {
    setResumeText(savedResume);
  }
}, []);

  async function handleMatch() {
    if (!resumeText || !jobDescription) {
      alert("Please fill both fields.");
      return;
    }

    try {
      setLoading(true);

      const response = await matchResume({
        resumeText,
        jobDescription,
      });

      setResult(response);
    } catch (error) {
      console.error(error);
      alert("Matching failed.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="upload-container">
      <div className="upload-card">
        <h1>AI Job Matcher</h1>

        <textarea
          rows={12}
          placeholder="Paste Resume Text..."
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
          onClick={handleMatch}
          disabled={loading}
        >
          {loading ? "Matching..." : "Match Resume"}
        </button>

        {result && (
          <>
            <hr />

            <h2>Match Score</h2>

            <h1 style={{ color: "#22c55e" }}>
              {result.matchScore}%
            </h1>

            <hr />

            <h2>Matched Skills</h2>

            <ul>
              {result.matchedSkills.map((skill, index) => (
                <li key={index}>{skill}</li>
              ))}
            </ul>

            <hr />

            <h2>Missing Skills</h2>

            <ul>
              {result.missingSkills.map((skill, index) => (
                <li key={index}>{skill}</li>
              ))}
            </ul>

            <hr />

            <h2>Suggestions</h2>

            <ul>
              {result.suggestions.map((item, index) => (
                <li key={index}>{item}</li>
              ))}
            </ul>
          </>
        )}
      </div>
    </div>
  );
}

export default JobMatcher;