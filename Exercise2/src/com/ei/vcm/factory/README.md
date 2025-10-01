# EntityFactory

The `EntityFactory` provides a **centralized way to create objects** (`Classroom`, `Student`, `Assignment`) in the Virtual Classroom system.

---

## ✨ Key Responsibilities
- Encapsulates object creation logic  
- Provides clean, reusable static methods  
- Keeps `ClassroomManager` and other classes focused on their own responsibilities  

---

## 🧩 Design Principle & Pattern
- **Factory Pattern** – Centralizes object creation, ensuring consistency and reducing duplication.  
- **SRP (Single Responsibility Principle)** – Only responsible for building entities, not managing them.  
- **OCP (Open/Closed Principle)** – Easy to extend with new entity types without touching existing logic.  

---

## 🎯 Why It’s Effective
By using a **Factory**, the system becomes:  
- **Cleaner** – no scattered `new` calls everywhere  
- **Flexible** – adding new entities or changing construction logic requires changes only here  
- **Maintainable** – separates creation from business logic  
