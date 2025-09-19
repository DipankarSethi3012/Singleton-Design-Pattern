package lazyLoading.SimpleLazyLoading;

public class LazySingleton {
    private static LazySingleton instance; //declared only

    private LazySingleton() {} //private constructor so that object can't be created with the new keyword

    public LazySingleton getInstance() {
        if(instance == null) { //only first time the instance is created.
            instance = new LazySingleton();
        }
        return instance;
    }
}

//Lazy Loading: Singleton instance is created only when it's needed . When first time the getInstance() method is called.
//Thread safety is main concern in Lazy Loading.
//Pros: saves memory if the instance is never used. Object Creation is deferred until required.
//Cons: No thread safe by default. Requires sync in multithreaded environments.