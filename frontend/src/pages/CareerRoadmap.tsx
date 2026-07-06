import { useState } from "react";
import {
  generateCareerRoadmap,
  type CareerRoadmapResponse,
} from "../api/resumeApi";

function CareerRoadmap() {
  const [currentSkills, setCurrentSkills] = useState("");
  const [targetRole, setTargetRole] = useState("");
  const [experienceLevel, setExperienceLevel] = useState("");
  const [result, setResult] = useState<CareerRoadmapResponse | null>(null);
  const [loading, setLoading] = useState(false);

  async function handleGenerate() {
    if (!currentSkills || !targetRole || !experienceLevel) {
      alert("Please fill all fields.");
      return;
    }

    try {
      setLoading(true);

      const response = await generateCareerRoadmap({
        currentSkills,
        targetRole,
        experienceLevel,
      });

      setResult(response);
    } catch (error) {
      console.error(error);
      alert("Failed to generate roadmap.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="upload-container">
      <div className="upload-card">
        <h1>AI Career Roadmap Generator</h1>

        <textarea
          rows={5}
          placeholder="Current Skills"
          value={currentSkills}
          onChange={(e) => setCurrentSkills(e.target.value)}
          style={{ width: "100%", marginBottom: "20px" }}
        />

        <input
          type="text"
          placeholder="Target Role"
          value={targetRole}
          onChange={(e) => setTargetRole(e.target.value)}
          style={{ width: "100%", marginBottom: "20px", padding: "10px" }}
        />

        <input
          type="text"
          placeholder="Experience Level (Beginner, Intermediate, Advanced)"
          value={experienceLevel}
          onChange={(e) => setExperienceLevel(e.target.value)}
          style={{ width: "100%", marginBottom: "20px", padding: "10px" }}
        />

        <button
          className="upload-button"
          onClick={handleGenerate}
          disabled={loading}
        >
          {loading ? "Generating..." : "Generate Roadmap"}
        </button>

        {result && (
          <>
            <hr />
            <h2>Your Career Roadmap</h2>

            <textarea
              rows={25}
              value={result.roadmap}
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

export default CareerRoadmap;