// Singleton class
class DatabaseConnector {
    private static DatabaseConnector instance;
    private DatabaseConnector() { System.out.println("Database Connected!"); }
    public static DatabaseConnector getInstance() {
        if (instance == null) instance = new DatabaseConnector();
        return instance;
    }
}

// Demo
public class DatabaseConnectorExample {
    public static void main(String[] args) {
        DatabaseConnector db1 = DatabaseConnector.getInstance();
        DatabaseConnector db2 = DatabaseConnector.getInstance();

        System.out.println("Are both instances same? " + (db1 == db2));
    }
}
