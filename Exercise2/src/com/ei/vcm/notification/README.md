# Notification Module

This package (`com.ei.vcm.notification`) is responsible for **student and classroom notifications** within the Virtual Classroom Manager application.  
It provides a clean abstraction for sending notifications and makes the system easily extensible to support multiple notification channels.

---

## 📂 Contents
- **`Notifier.java`** – Interface that defines the contract for sending notifications.  
- **`ConsoleNotifier.java`** – Concrete implementation of the `Notifier` interface that logs messages to the console using `java.util.logging.Logger`.

---

## 📌 Design Overview
- **Interface (`Notifier`)**  
  - Defines methods to send notifications either to a **single student** or to **all students in a class**.
  - Promotes **loose coupling** by allowing different implementations (e.g., console, email, SMS, push notifications).

- **Implementation (`ConsoleNotifier`)**  
  - Logs notification messages to the console.  
  - Uses `Logger` instead of `System.out.println` for better maintainability and control.  
  - Acts as a simple proof-of-concept implementation.

---

## 🎯 Design Pattern Used
- **Strategy Pattern**:  
  The `Notifier` interface allows different strategies (console, email, etc.) for delivering notifications.  
  The client code can switch between implementations without changing its logic.

---

