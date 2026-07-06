import { BrowserRouter, Routes, Route } from "react-router-dom";

import ResumeUploader from "./components/resume/ResumeUploader";
import JobMatcher from "./pages/JobMatcher";
import ResumeTailor from "./pages/ResumeTailor";
import InterviewGenerator from "./pages/InterviewGenerator";
import CoverLetterGenerator from "./pages/CoverLetterGenerator";
import CareerRoadmap from "./pages/CareerRoadmap";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ResumeUploader />} />
        <Route path="/resume" element={<ResumeUploader />} />
        <Route path="/job-match" element={<JobMatcher />} />
        <Route path="/resume-tailor" element={<ResumeTailor />} />
        <Route
  path="/interview"
  element={<InterviewGenerator />}
/><Route
  path="/cover-letter"
  element={<CoverLetterGenerator />}
/><Route
  path="/career-roadmap"
  element={<CareerRoadmap />}
/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;