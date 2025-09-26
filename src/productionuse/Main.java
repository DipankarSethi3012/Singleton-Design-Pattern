package productionuse;

public class Main {
    public static void main(String[] args) {
        AppManager manager = AppManager.getInstance();

        // Logging
        manager.log("Application started.");

        // Config access
        String dbUrl = manager.getConfig("db.url");
        manager.log("Database URL: " + dbUrl);
    }
}
