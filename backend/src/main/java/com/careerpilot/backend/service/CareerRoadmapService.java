package com.careerpilot.backend.service;

import com.careerpilot.backend.dto.CareerRoadmapRequest;
import com.careerpilot.backend.dto.CareerRoadmapResponse;
import org.springframework.stereotype.Service;

@Service
public class CareerRoadmapService {

    public CareerRoadmapResponse generateRoadmap(CareerRoadmapRequest request) {

        String skills = request.getCurrentSkills();
        String role = request.getTargetRole();
        String level = request.getExperienceLevel();

        StringBuilder roadmap = new StringBuilder();

        roadmap.append("=========== AI CAREER ROADMAP ===========\n\n");

        roadmap.append("🎯 Target Role: ").append(role).append("\n");
        roadmap.append("📈 Experience Level: ").append(level).append("\n");
        roadmap.append("🛠 Current Skills: ").append(skills).append("\n\n");

        roadmap.append("=========== 30-DAY LEARNING PLAN ===========\n\n");

        roadmap.append("Week 1\n");
        roadmap.append("- Java Fundamentals\n");
        roadmap.append("- OOP Concepts\n");
        roadmap.append("- Collections Framework\n");
        roadmap.append("- Exception Handling\n\n");

        roadmap.append("Week 2\n");
        roadmap.append("- Spring Boot\n");
        roadmap.append("- REST APIs\n");
        roadmap.append("- SQL\n");
        roadmap.append("- Git & GitHub\n\n");

        roadmap.append("Week 3\n");
        roadmap.append("- React\n");
        roadmap.append("- Docker Basics\n");
        roadmap.append("- AWS Fundamentals\n");
        roadmap.append("- Build Mini Projects\n\n");

        roadmap.append("Week 4\n");
        roadmap.append("- Data Structures & Algorithms\n");
        roadmap.append("- System Design Basics\n");
        roadmap.append("- Mock Interviews\n");
        roadmap.append("- Resume Improvements\n\n");

        roadmap.append("=========== RECOMMENDED PROJECTS ===========\n\n");
        roadmap.append("✔ CareerPilot AI\n");
        roadmap.append("✔ Banking REST API\n");
        roadmap.append("✔ URL Shortener\n");
        roadmap.append("✔ Task Management System\n\n");

        roadmap.append("=========== CERTIFICATIONS ===========\n\n");
        roadmap.append("✔ Microsoft Learn\n");
        roadmap.append("✔ Oracle Java Certification\n");
        roadmap.append("✔ AWS Cloud Practitioner\n\n");

        roadmap.append("=========== INTERVIEW PREPARATION ===========\n\n");
        roadmap.append("✔ Solve 2 LeetCode problems daily\n");
        roadmap.append("✔ Complete Blind 75\n");
        roadmap.append("✔ Practice HR Interview Questions\n");
        roadmap.append("✔ Revise Java & Spring Boot\n\n");

        roadmap.append("=========== ESTIMATED READINESS ===========\n\n");
        roadmap.append("75% (after completing the roadmap)");

        return new CareerRoadmapResponse(roadmap.toString());
    }
}