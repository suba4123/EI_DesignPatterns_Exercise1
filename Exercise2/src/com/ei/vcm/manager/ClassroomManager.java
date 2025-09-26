package com.ei.vcm.manager;

import com.ei.vcm.factory.EntityFactory;
import com.ei.vcm.model.Classroom;
import com.ei.vcm.model.Student;

import java.util.HashMap;
import java.util.Map;

public class ClassroomManager {
    private static ClassroomManager instance;
    private final Map<String, Classroom> classrooms = new HashMap<>();

    private ClassroomManager() {}

    public static synchronized ClassroomManager getInstance() {
        if (instance == null) {
            instance = new ClassroomManager();
        }
        return instance;
    }

    public void addClassroom(String name) {
        if (classrooms.containsKey(name)) {
            System.out.println("Classroom already exists: " + name);
            return;
        }
        classrooms.put(name, EntityFactory.createClassroom(name));
        System.out.println("Classroom created: " + name);
    }

    public void addStudent(String id, String name, String className) {
        Classroom c = classrooms.get(className);
        if (c == null) {
            System.out.println("Classroom not found: " + className);
            return;
        }
        if (c.addStudent(EntityFactory.createStudent(id, name))) {
            System.out.println("Student added: " + name + " to " + className);
        } else {
            System.out.println("Student already exists in class: " + className);
        }
    }

    public Classroom getClassroom(String name) {
        return classrooms.get(name);
    }
}
