package com.ei.vcm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classroom {
    private final String name;
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Assignment> assignments = new HashMap<>();

    public Classroom(String name) { this.name = name; }
    public String getName() { return name; }

    public boolean addStudent(Student s) {
        if (students.containsKey(s.getId())) return false;
        students.put(s.getId(), s);
        return true;
    }

    public Student getStudent(String id) { return students.get(id); }
    public List<Student> listStudents() { return new ArrayList<>(students.values()); }

    public boolean addAssignment(Assignment a) {
        if (assignments.containsKey(a.getTitle())) return false;
        assignments.put(a.getTitle(), a);
        return true;
    }

    public Assignment getAssignment(String title) { return assignments.get(title); }
    public List<Assignment> listAssignments() { return new ArrayList<>(assignments.values()); }
}
