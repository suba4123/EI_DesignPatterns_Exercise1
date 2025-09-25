// Product interface
interface Shape {
    void draw();
}

// Concrete Products
class Circle implements Shape {
    public void draw() { System.out.println("Drawing a Circle."); }
}
class Square implements Shape {
    public void draw() { System.out.println("Drawing a Square."); }
}

// Factory
class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        if (type.equalsIgnoreCase("square")) return new Square();
        return null;
    }
}

// Demo
public class ShapeFactoryExample {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape s1 = factory.getShape("circle");
        Shape s2 = factory.getShape("square");

        s1.draw();
        s2.draw();
    }
}
