package com.ei.vcm;

import com.ei.vcm.manager.ClassroomManager;
import com.ei.vcm.model.Assignment;
import com.ei.vcm.model.Classroom;
import com.ei.vcm.model.Student;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClassroomManager manager = ClassroomManager.getInstance();

        System.out.println("Virtual Classroom Manager (type 'help' for commands)");
        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            String cmd = parts[0];

            try {
                switch (cmd) {
                    case "help":
                        System.out.println("Commands:");
                        System.out.println(" add_classroom <name>");
                        System.out.println(" add_student <id> <name> <class>");
                        System.out.println(" schedule_assignment <class> <title> <dueDate>");
                        System.out.println(" submit_assignment <id> <class> <title>");
                        System.out.println(" view_students <class>");
                        System.out.println(" view_assignments <class>");
                        System.out.println(" remove_classroom <name>");
                        System.out.println(" exit");
                        break;
                    case "add_classroom":
                        manager.addClassroom(parts[1]);
                        break;
                    case "add_student":
                        manager.addStudent(parts[1], parts[2], parts[3]);
                        break;
                    case "schedule_assignment":
                        manager.scheduleAssignment(parts[1], parts[2], parts[3]);
                        break;
                    case "submit_assignment":
                        manager.submitAssignment(parts[1], parts[2], parts[3]);
                        break;
                    case "view_students": {
                        Classroom c = manager.getClassroom(parts[1]);
                        if (c != null) {
                            for (Student s : c.listStudents())
                                System.out.println(s.getId() + " - " + s.getName());
                        }
                        break;
                    }
                    case "view_assignments": {
                        Classroom c = manager.getClassroom(parts[1]);
                        if (c != null) {
                            for (Assignment a : c.listAssignments())
                                System.out.println(a.getTitle() + " (Due: " + a.getDueDate() + ")");
                        }
                        break;
                    }
                    case "remove_classroom":
                         manager.removeClassroom(parts[1]);
                         break;

                    case "exit":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Unknown command. Type 'help'.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
