package EagerLoading;

public class Main {
    public static void main(String[] args) {
        //we can't create on object because the constructor is private
//        EagerSingleton eagerSingleton = new EagerSingleton();

        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();

        System.out.println(eagerSingleton1 + " " + eagerSingleton2);
    }
}
