package productionuse;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Properties;

public class AppManager {

    private AppManager() {}

    private static class Holder {
        private static final AppManager instance = new AppManager();
    }

    public static AppManager getInstance() {
        return Holder.instance;
    }

    // ------Configuration Management------
    //properties class ek key value storage hai, mostly configurations ke liye use hoti hai
    private Properties config = new Properties(); //config object mai saare application ke settings store hote hai

    //purpose app.properties ko read krna or config object mai sload krna
    private void loadConfig() {
        //getClass().getClassLoader().getResourceAsStream("app.properties") -> JVM class Path se app.properties ka stream read krta hai
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("app.properties")) {
            if(input != null) {
                config.load(input); //agr file exist krti hai to load ho jaati hai
                log("Configuration loaded Successfully");
            } else {
                log("No Configuration file found");
            }
        } catch (IOException e) {
            log("Error loading configuration: " + e.getMessage());
        }
    }

    //Purpose -> Project mai specify key ki value return krna
    //Example-> String dbUrl = AppManager.getInstance().getConfig("db.url");
    public String getConfig(String key) {
        return config.getProperty(key);
    }

    //-----Simple Logger-----
    public void log(String message) {
        System.out.println("[" + LocalDateTime.now() + "] " + message);
    }
}
