import { Link } from "react-router-dom";

function Sidebar() {
  return (
    <div
      style={{
        width: "220px",
        background: "#111827",
        color: "white",
        minHeight: "100vh",
        padding: "20px",
      }}
    >
      <h2>CareerPilot</h2>

      <hr />

      <div style={{ marginTop: "20px", display: "grid", gap: "15px" }}>
        <Link to="/" style={{ color: "white", textDecoration: "none" }}>
          🏠 Home
        </Link>

        <Link
          to="/dashboard"
          style={{ color: "white", textDecoration: "none" }}
        >
          📊 Dashboard
        </Link>

        <Link
          to="/resume"
          style={{ color: "white", textDecoration: "none" }}
        >
          📄 Resume
        </Link>

        <Link
          to="/jobs"
          style={{ color: "white", textDecoration: "none" }}
        >
          💼 Jobs
        </Link>

        <Link
          to="/roadmap"
          style={{ color: "white", textDecoration: "none" }}
        >
          🚀 Roadmap
        </Link>
      </div>
    </div>
  );
}

export default Sidebar;