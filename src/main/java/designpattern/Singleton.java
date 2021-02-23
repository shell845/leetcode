package main.java.designpattern;

/**
 * @author YC (shell845)
 * @date 22/2/2021 11:55 AM
 */

public class Singleton {
    /**
     * Hungry implementation
     */
    /*
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
    */

    /**
     * Static Inner Class
     */
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Lazy init
     */
    /*
    private static Singleton INSTANCE;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
    */

    /**
     * Double check
     */
    /*
    private static volatile Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) INSTANCE = new Singleton();
            }
        }
        return INSTANCE;
    }
    */
}
