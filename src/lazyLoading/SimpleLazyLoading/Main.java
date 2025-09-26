package lazyLoading.SimpleLazyLoading;

public class Main {
    public static void main(String[] args) {
        //can't call because the constructor is private
//        LazySingleton lazySingleton = new LazySingleton();

        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton1 = LazySingleton.getInstance();

        System.out.println(lazySingleton1 + " " + lazySingleton);
    }
}
