package lazyLoading.lockLazyLoading;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance == null) { //to check the instance is null
            synchronized (Singleton.class) { //acquire lock so that other thread can't come
                if(instance == null) { //Again check ths instance (Because At first 2 threads can pass the null check. After lock and volatile instance it may be mot empty now.)
                    instance = new Singleton();
                }
            }
        }

        return  instance;
    }

}

//volatile ensures that the value of instance is read/written from the main memory. If we can't use volatile the value go to thread cache/ cpu cache.