package com.ei.vcm.model;
import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private final String name;
    private final List<Student> students = new ArrayList<>();

    public Classroom(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public boolean addStudent(Student s) {
        for (Student st : students) {
            if (st.getId().equals(s.getId())) return false;
        }
        students.add(s);
        return true;
    }

    public List<Student> getStudents() {
        return students;
    }
}
