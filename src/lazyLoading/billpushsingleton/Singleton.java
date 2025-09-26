package lazyLoading.billpushsingleton;

public class Singleton {

    private static class Holder {
        private static final Singleton instance = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance() {
        return Holder.instance;
    }
}

