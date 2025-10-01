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
   
public void addStudent(String studentId) {
    submissions.put(studentId, false);
}

// Mark a student as submitted using student ID
public void markSubmitted(String studentId) {
    if (submissions.containsKey(studentId)) {
        submissions.put(studentId, true);
    }
}


    // Get submission status
    public Map<String, Boolean> getSubmissions() {
        return submissions;
    }
    // Get only completed submissions
    public Map<String, Boolean> getCompletedSubmissions() {
    Map<String, Boolean> completed = new HashMap<>();
    for (Map.Entry<String, Boolean> entry : submissions.entrySet()) {
        if (entry.getValue()) {
            completed.put(entry.getKey(), true);
        }
    }
    return completed;
}


}
