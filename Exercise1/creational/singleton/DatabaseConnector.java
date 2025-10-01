package singleton;


// Singleton Class
public class DatabaseConnector {
    // The single instance (lazy initialization)
    private static DatabaseConnector instance;

    // Private constructor to prevent instantiation
    private DatabaseConnector() {
        System.out.println("Database Connected!");
    }

    // Global access point
    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }
}
