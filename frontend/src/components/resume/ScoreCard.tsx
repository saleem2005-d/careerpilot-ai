interface Props {
  title: string;
  value: number;
  total: number;
}

function ScoreCard({ title, value, total }: Props) {
  const percent = (value / total) * 100;

  return (
    <div
      style={{
        background: "#ffffff",
        borderRadius: "12px",
        padding: "20px",
        boxShadow: "0 5px 15px rgba(0,0,0,0.15)",
      }}
    >
      <h3
        style={{
          color: "#1e293b",
          marginBottom: "12px",
        }}
      >
        {title}
      </h3>

      <div
        style={{
          background: "#e5e7eb",
          height: "10px",
          borderRadius: "10px",
          overflow: "hidden",
        }}
      >
        <div
          style={{
            width: `${percent}%`,
            height: "100%",
            background: "#22c55e",
          }}
        />
      </div>

      <h2
        style={{
          marginTop: "15px",
          color: "#16a34a",
        }}
      >
        {value}/{total}
      </h2>
    </div>
  );
}

export default ScoreCard;