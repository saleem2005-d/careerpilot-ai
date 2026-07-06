import { Link } from "react-router-dom";
import { useState } from "react";
import "./ResumeUploader.css";
import { uploadResume } from "../../api/resumeApi";
import type { UploadResponse } from "../../api/resumeApi";
import ScoreCard from "./ScoreCard";

function ResumeUploader() {
  const [file, setFile] = useState<File | null>(null);
  const [loading, setLoading] = useState(false);
  const [result, setResult] = useState<UploadResponse | null>(null);

  function handleFile(selectedFile: File) {
    const allowed = [
      "application/pdf",
      "application/msword",
      "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
    ];

    if (!allowed.includes(selectedFile.type)) {
      alert("Please upload PDF or DOC/DOCX only.");
      return;
    }

    setFile(selectedFile);
    setResult(null);
  }

  async function handleUpload() {
    if (!file) {
      alert("Choose a resume first.");
      return;
    }

    try {
      setLoading(true);

      const response = await uploadResume(file);

      console.log(response);

      setResult(response);
      
      localStorage.setItem(
  "resumeText",
  response.analysis.extractedText
);

      alert("Resume uploaded successfully.");
    } catch (err) {
      console.error(err);
      alert("Upload failed.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="upload-container">
      <div className="upload-card">
        <h1>AI Resume Analyzer</h1>
<div style={{ marginBottom: "20px" }}>
  <Link to="/job-match">
    <button className="upload-button">
      Go to AI Job Matcher
    </button>
  </Link>
</div>
        <p>
          Upload your resume and receive an ATS score, strengths, missing
          skills and improvement suggestions.
        </p>

        <br />

        <input
          type="file"
          accept=".pdf,.doc,.docx"
          onChange={(e) => {
            if (e.target.files) {
              handleFile(e.target.files[0]);
            }
          }}
        />

        <br />
        <br />

        <button
          className="upload-button"
          onClick={handleUpload}
          disabled={loading}
        >
          {loading ? "Uploading..." : "Upload Resume"}
        </button>

        {file && (
          <div className="file-box">
            <h3>Selected File</h3>

            <p>{file.name}</p>

            <small>{(file.size / 1024).toFixed(2)} KB</small>
          </div>
        )}

        {result && result.success && (
          <>
            <hr />

            <h2>Resume Analysis</h2>

            <p>
              <strong>Name:</strong> {result.analysis.name || "-"}
            </p>

            <p>
              <strong>Email:</strong> {result.analysis.email || "-"}
            </p>

            <p>
              <strong>Phone:</strong> {result.analysis.phone || "-"}
            </p>

            <p>
              <strong>Education:</strong> {result.analysis.education || "-"}
            </p>

            <p>
              <strong>Experience:</strong> {result.analysis.experience || "-"}
            </p>

            <hr />

            <h2>ATS Resume Score</h2>

            <div
              style={{
                fontSize: "52px",
                fontWeight: "bold",
                color: "#16a34a",
                textAlign: "center",
                marginBottom: "15px",
              }}
            >
              {result.analysis.score.overallScore}/100
            </div>
          
<div style={{ marginBottom: "20px" }}>
  <Link to="/resume-tailor">
    <button className="upload-button">
      Go to AI Resume Tailoring
    </button>
  </Link>
</div>
<div style={{ marginBottom: "20px" }}>
  <Link to="/interview">
    <button className="upload-button">
      Go to AI Interview Generator
    </button>
  </Link>
</div>
            <div
              style={{
                width: "100%",
                height: "18px",
                background: "#d1d5db",
                borderRadius: "10px",
                overflow: "hidden",
                marginBottom: "30px",
              }}
            >
              <div
                style={{
                  width: `${result.analysis.score.overallScore}%`,
                  height: "100%",
                  background: "#16a34a",
                }}
              />
            </div>

            <div
              style={{
                display: "grid",
                gridTemplateColumns: "repeat(auto-fit,minmax(220px,1fr))",
                gap: "20px",
                marginBottom: "30px",
              }}
            >
              <ScoreCard
                title="Skills"
                value={result.analysis.score.skillsScore}
                total={30}
              />

              <ScoreCard
                title="Education"
                value={result.analysis.score.educationScore}
                total={15}
              />

              <ScoreCard
                title="Projects"
                value={result.analysis.score.projectsScore}
                total={20}
              />

              <ScoreCard
                title="Experience"
                value={result.analysis.score.experienceScore}
                total={20}
              />

              <ScoreCard
                title="Certifications"
                value={result.analysis.score.certificationsScore}
                total={15}
              />
            </div>

            <hr />

            <h2>Skills</h2>

            <div
              style={{
                display: "flex",
                flexWrap: "wrap",
                gap: "10px",
                marginBottom: "25px",
              }}
            >
              {result.analysis.skills.map((skill, index) => (
                <div
                  key={index}
                  style={{
                    background: "#2563eb",
                    color: "white",
                    padding: "8px 16px",
                    borderRadius: "25px",
                    fontWeight: "600",
                  }}
                >
                  {skill}
                </div>
              ))}
            </div>

            <hr />

            <h2>Strengths</h2>

            <div
              style={{
                display: "flex",
                flexWrap: "wrap",
                gap: "10px",
                marginBottom: "25px",
              }}
            >
              {result.analysis.score.strengths.map((item, index) => (
                <div
                  key={index}
                  style={{
                    background: "#16a34a",
                    color: "white",
                    padding: "10px 16px",
                    borderRadius: "25px",
                  }}
                >
                  ✓ {item}
                </div>
              ))}
            </div>

            <hr />

            <h2>Missing Skills</h2>

            <div
              style={{
                display: "flex",
                flexWrap: "wrap",
                gap: "10px",
                marginBottom: "25px",
              }}
            >
              {result.analysis.score.missingSkills.map((item, index) => (
                <div
                  key={index}
                  style={{
                    background: "#dc2626",
                    color: "white",
                    padding: "10px 16px",
                    borderRadius: "25px",
                  }}
                >
                  ✗ {item}
                </div>
              ))}
            </div>

            <hr />

            <h2>Suggestions</h2>

            <div
              style={{
                display: "grid",
                gap: "15px",
                marginBottom: "25px",
              }}
            >
              {result.analysis.score.suggestions.map((item, index) => (
                <div
                  key={index}
                  style={{
                    background: "#1e293b",
                    borderLeft: "5px solid #3b82f6",
                    padding: "15px",
                    borderRadius: "10px",
                  }}
                >
                  💡 {item}
                </div>
              ))}
            </div>

            <hr />

            <h2>Extracted Resume Text</h2>

            <textarea
              rows={15}
              style={{
                width: "100%",
                padding: "10px",
                borderRadius: "8px",
              }}
              readOnly
              value={result.analysis.extractedText}
            />
          </>
        )}
      </div>
    </div>
  );
}

export default ResumeUploader;