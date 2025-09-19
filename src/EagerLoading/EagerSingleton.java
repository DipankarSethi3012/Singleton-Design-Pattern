package EagerLoading;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){} //keeping the constructor private presents from the creation of objects using the new keyword

    public static  EagerSingleton getInstance() {
        return instance; //returns only one instance that is eager loaded into the memory
    }
}
//Eager Loading: Object is instanced when the class is loaded into the memory.
// Pros: Thread safe and easy to implement
//Cons: Memory waste if instance is never used, Not suitable for heavy objects.