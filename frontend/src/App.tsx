import { BrowserRouter, Routes, Route } from "react-router-dom";

import ResumeUploader from "./components/resume/ResumeUploader";
import JobMatcher from "./pages/JobMatcher";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ResumeUploader />} />
        <Route path="/resume" element={<ResumeUploader />} />
        <Route path="/job-match" element={<JobMatcher />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;