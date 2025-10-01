package factory;

// Demo
public class ShapeFactoryMain {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape s1 = factory.getShape("circle");
        Shape s2 = factory.getShape("square");

        s1.draw();
        s2.draw();
    }
}
