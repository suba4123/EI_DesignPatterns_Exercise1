package singleton;

public class DatabaseConnectorMain {
    public static void main(String[] args) {
        DatabaseConnector db1 = DatabaseConnector.getInstance();
        DatabaseConnector db2 = DatabaseConnector.getInstance();

        // Both references point to the same object
        System.out.println("Are db1 and db2 the same instance? " + (db1 == db2));
    }
}
