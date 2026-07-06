package com.careerpilot.backend.service;

import com.careerpilot.backend.dto.JobMatchRequest;
import com.careerpilot.backend.dto.JobMatchResponse;
import com.careerpilot.backend.util.SkillExtractor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobMatchService {

    public JobMatchResponse match(JobMatchRequest request) {

        List<String> resumeSkills =
                SkillExtractor.extractSkills(request.getResumeText());

        List<String> jobSkills =
                SkillExtractor.extractSkills(request.getJobDescription());

        List<String> matchedSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();
        List<String> suggestions = new ArrayList<>();

        for (String skill : jobSkills) {

            if (resumeSkills.contains(skill)) {
                matchedSkills.add(skill);
            } else {
                missingSkills.add(skill);
                suggestions.add("Learn " + skill);
            }

        }

        int matchScore;

        if (jobSkills.isEmpty()) {
            matchScore = 0;
        } else {
            matchScore = (matchedSkills.size() * 100) / jobSkills.size();
        }

        JobMatchResponse response = new JobMatchResponse();

        response.setMatchScore(matchScore);
        response.setMatchedSkills(matchedSkills);
        response.setMissingSkills(missingSkills);
        response.setSuggestions(suggestions);

        return response;
    }
}