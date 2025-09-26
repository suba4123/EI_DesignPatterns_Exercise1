package com.ei.vcm.model;

public class Assignment {
    private final String title;
    private final String dueDate;

    public Assignment(String title, String dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getTitle() { return title; }
    public String getDueDate() { return dueDate; }
}
