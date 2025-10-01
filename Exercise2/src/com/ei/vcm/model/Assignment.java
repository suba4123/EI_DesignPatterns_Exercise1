package com.ei.vcm.model;

import java.util.HashMap;
import java.util.Map;

public class Assignment {
    private final String title;
    private final String dueDate;

    // Track submissions: student name -> submitted (true/false)
    private final Map<String, Boolean> submissions;

    public Assignment(String title, String dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.submissions = new HashMap<>();
    }

    public String getTitle() { return title; }
    public String getDueDate() { return dueDate; }

    // Add a student to track submission
    public void addStudent(String studentName) {
        submissions.put(studentName, false);
    }

    // Mark a student as submitted
    public void markSubmitted(String studentName) {
        if (submissions.containsKey(studentName)) {
            submissions.put(studentName, true);
        }
    }

    // Get submission status
    public Map<String, Boolean> getSubmissions() {
        return submissions;
    }
}
