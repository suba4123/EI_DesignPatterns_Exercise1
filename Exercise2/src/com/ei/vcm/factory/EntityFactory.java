package com.ei.vcm.factory;

import com.ei.vcm.model.Assignment;
import com.ei.vcm.model.Classroom;
import com.ei.vcm.model.Student;

public class EntityFactory {
    public static Classroom createClassroom(String name) {
        return new Classroom(name);
    }

    public static Student createStudent(String id, String name) {
        return new Student(id, name);
    }

    public static Assignment createAssignment(String title, String dueDate) {
        return new Assignment(title, dueDate);
    }
}
