Model Package

The com.ei.vcm.model package defines the core domain entities of the Virtual Classroom Manager.
These classes represent real-world concepts and act as the foundation of the system.

📂 Contents

Classroom.java – Represents a virtual classroom, managing enrolled students and scheduled assignments.

Student.java – Represents a student with an ID, name, and assignment submission tracking.

Assignment.java – Represents an assignment with a title, due date, and submission state.

🧩 Design Principles

Single Responsibility Principle (SRP): Each class focuses on one well-defined responsibility.

Encapsulation: Fields and state are kept private, accessed through methods.

Separation of Concerns: Domain entities are independent of management (manager) or creation logic (factory).

🎯 Why It Matters

Provides a clean, reusable foundation for the system.

Keeps business logic separate from orchestration.

Simplifies future extensions (e.g., adding new entity types).