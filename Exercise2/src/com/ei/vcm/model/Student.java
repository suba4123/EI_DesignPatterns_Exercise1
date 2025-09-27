package com.ei.vcm.model;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private final String id;
    private final String name;
    // Track assignment submissions: assignmentTitle -> submitted (true/false)
    private final Map<String, Boolean> submissions = new HashMap<>();

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    // Called when a student submits an assignment
    public void markSubmitted(String assignmentTitle) {
        submissions.put(assignmentTitle, true);
    }

    // Check if a student has submitted a particular assignment
    public boolean hasSubmitted(String assignmentTitle) {
        return submissions.getOrDefault(assignmentTitle, false);
    }
}
