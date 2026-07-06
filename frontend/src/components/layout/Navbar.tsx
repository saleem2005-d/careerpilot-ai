import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav
      style={{
        background: "#0f172a",
        color: "white",
        padding: "18px 30px",
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
      }}
    >
      <h2>CareerPilot AI</h2>

      <div
        style={{
          display: "flex",
          gap: "20px",
          alignItems: "center",
        }}
      >
        <Link
          style={{ color: "white", textDecoration: "none" }}
          to="/"
        >
          Home
        </Link>

        <Link
          style={{ color: "white", textDecoration: "none" }}
          to="/dashboard"
        >
          Dashboard
        </Link>

        <Link
          style={{ color: "white", textDecoration: "none" }}
          to="/resume"
        >
          Resume
        </Link>

        <Link
          style={{ color: "white", textDecoration: "none" }}
          to="/"
        >
          Login
        </Link>
      </div>
    </nav>
  );
}

export default Navbar;