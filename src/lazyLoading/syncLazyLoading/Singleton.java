package lazyLoading.syncLazyLoading;

public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

//synchronization ensures that only one thread multiple threads don't pass the null check and creates instances simultaneously.
//The program becomes thread safe.
//The problem is that there's overhead because every call to getInstance is synchronized even after the instance is created. The program become slow.