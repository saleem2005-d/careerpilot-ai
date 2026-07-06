package com.careerpilot.backend.util;

import java.util.ArrayList;
import java.util.List;

public class SkillExtractor {

    public static List<String> extractSkills(String text) {

        List<String> skills = new ArrayList<>();

        if (text == null) {
            return skills;
        }

        String lowerText = text.toLowerCase();

        for (String skill : SkillDatabase.SKILLS) {

            if (lowerText.contains(skill.toLowerCase())) {
                skills.add(skill);
            }

        }

        return skills;
    }

    private SkillExtractor() {
    }
}