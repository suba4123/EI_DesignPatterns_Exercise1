package com.ei.vcm.notification;

import java.util.logging.Logger;

public class ConsoleNotifier implements Notifier {
    private static final Logger logger = Logger.getLogger(ConsoleNotifier.class.getName());

    @Override
    public void notifyStudent(String studentId, String message) {
        logger.info("[Notify -> Student " + studentId + "] " + message);
    }

    @Override
    public void notifyAllInClass(String className, String message) {
        logger.info("[Notify -> Class " + className + "] " + message);
    }
}
