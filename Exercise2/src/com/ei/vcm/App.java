package com.ei.vcm;

import com.ei.vcm.manager.ClassroomManager;

public class App {
    public static void main(String[] args) {
        ClassroomManager manager = ClassroomManager.getInstance();
        manager.addClassroom("Math101");
        manager.addStudent("S001", "Suba", "Math101");
        manager.addStudent("S002", "Nandhini", "Math101");
    }
}
