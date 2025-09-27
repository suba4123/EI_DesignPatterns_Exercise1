package com.ei.vcm.notification;

public interface Notifier {
    void notifyStudent(String studentId, String message);
    void notifyAllInClass(String className, String message);
}
