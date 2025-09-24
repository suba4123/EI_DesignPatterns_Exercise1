import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Concrete Observer
class Student implements Observer {
    private String name;
    public Student(String name) { this.name = name; }
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}

// Subject
class Classroom {
    private List<Observer> students = new ArrayList<>();
    public void addObserver(Observer s) { students.add(s); }
    public void notifyObservers(String message) {
        for(Observer s : students) s.update(message);
    }
}

// Main class (demo)
public class StudentNotificationDemo {
    public static void main(String[] args) {
        Classroom class1 = new Classroom();
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        class1.addObserver(s1);
        class1.addObserver(s2);

        class1.notifyObservers("Class starts at 10 AM!");
    }
}
