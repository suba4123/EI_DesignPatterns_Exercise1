# ClassroomManager

The `ClassroomManager` is the **core coordinator** of the Virtual Classroom system.  
It manages classrooms, students, and assignments while handling notifications.  

---

## ✨ Key Responsibilities
- Create and remove classrooms  
- Enroll students into classrooms  
- Schedule and track assignments  
- Handle student submissions  
- Notify students and classes about events  

---

## 🧩 Design Principles & Patterns

- **Singleton Pattern** – Ensures a single global instance of `ClassroomManager`.  
- **Factory Pattern** – Uses `EntityFactory` for object creation (`Classroom`, `Student`, `Assignment`) to decouple instantiation from logic.  
- **Observer/Strategy Pattern** – Uses `Notifier` abstraction with `ConsoleNotifier` implementation for sending notifications.  

---

## 🏛 SOLID Principles in Action
- **SRP** – `ClassroomManager` focuses only on coordination, not on object creation (delegated to `EntityFactory`) or notification details (delegated to `Notifier`).  
- **OCP** – New notifiers (e.g., Email, SMS) can be added without modifying existing code.  
- **LSP** – Any `Notifier` implementation can replace another without breaking functionality.  
- **ISP** – `Notifier` interface defines minimal, relevant methods only.  
- **DIP** – Depends on `Notifier` abstraction, not its concrete implementation.  

