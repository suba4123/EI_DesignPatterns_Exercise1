package com.ei.vcm.manager;

import com.ei.vcm.factory.EntityFactory;
import com.ei.vcm.model.Assignment;
import com.ei.vcm.model.Classroom;
import com.ei.vcm.model.Student;
import com.ei.vcm.notification.ConsoleNotifier;
import com.ei.vcm.notification.Notifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ClassroomManager {
    private static ClassroomManager instance;
    private final Map<String, Classroom> classrooms = new HashMap<>();
    private final Notifier notifier;
    private static final Logger logger = Logger.getLogger(ClassroomManager.class.getName());

    private ClassroomManager() {
        this.notifier = new ConsoleNotifier();
    }

    public static synchronized ClassroomManager getInstance() {
        if (instance == null) instance = new ClassroomManager();
        return instance;
    }

    public void addClassroom(String name) {
        if (classrooms.containsKey(name)) {
            logger.warning("Classroom already exists: " + name);
            return;
        }
        classrooms.put(name, EntityFactory.createClassroom(name));
        logger.info("Classroom created: " + name);
    }
    public void viewStudents(String className) {
    Classroom c = classrooms.get(className);

    // Check if classroom exists
    if (c == null) {
        logger.warning("Classroom not found: " + className);
        return;
    }

    // Get students list
    List<Student> students = c.listStudents();

    // Handle empty class
    if (students.isEmpty()) {
        logger.warning("No students enrolled in class: " + className);
        return;
    }

    // ✅ Log students info
    logger.info("Students in " + className + ":");
    for (Student s : students) {
        logger.info(" - " + s.getId() + " | " + s.getName());
    }
}



    public void addStudent(String id, String name, String className) {
        Classroom c = classrooms.get(className);
        if (c == null) {
            logger.warning("Classroom not found: " + className);
            return;
        }
        if (c.addStudent(EntityFactory.createStudent(id, name))) {
            logger.info("Student " + id + " added to " + className);
            notifier.notifyStudent(id, "You have been enrolled in " + className);
        } else {
            logger.warning("Student already exists in class: " + className);
        }
    }

    // ➡️ New: Schedule assignment
    public void scheduleAssignment(String className, String title, String dueDate) {
        Classroom c = classrooms.get(className);
        if (c == null) {
            logger.warning("Classroom not found: " + className);
            return;
        }
        Assignment a = EntityFactory.createAssignment(title, dueDate);
        if (c.addAssignment(a)) {
            logger.info("Assignment scheduled: " + title + " for " + className);
            notifier.notifyAllInClass(className, "New assignment posted: " + title);
        } else {
            logger.warning("Assignment already exists: " + title);
        }
    }

    // ➡️ New: Submit assignment
    public void submitAssignment(String studentId, String className, String assignmentTitle) {
        Classroom c = classrooms.get(className);
        if (c == null) {
            logger.warning("Classroom not found: " + className);
            return;
        }
        Student s = c.getStudent(studentId);
        if (s == null) {
            logger.warning("Student not found: " + studentId);
            return;
        }
        Assignment a = c.getAssignment(assignmentTitle);
        if (a == null) {
            logger.warning("Assignment not found: " + assignmentTitle);
            return;
        }
        s.markSubmitted(assignmentTitle);
        logger.info("Assignment submitted by " + studentId + " for " + className + " -> " + assignmentTitle);
        notifier.notifyAllInClass(className, "Student " + s.getName() + " submitted " + assignmentTitle);
    }
    public void removeClassroom(String name) {
    if (!classrooms.containsKey(name)) {
        throw new IllegalArgumentException("Classroom not found: " + name);
    }
    classrooms.remove(name);
    logger.info("Classroom removed: " + name);
}


    public Classroom getClassroom(String name) { return classrooms.get(name); }
}
