// Singleton Design pattern is a type of creation design pattern
// It is used to create a single instance of a class
// It restricts the instantiation of a class to a single instance
// This is useful when exactly one object is needed to coordinate actions across the system.
class Singleton{
    private static Singleton instance; 
    private Singleton(){
        // Private constructor to prevent instantiation
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
            System.out.println("New instance has been created");
        }
        return instance;
    }
}

class ThreadSafeSingleton{
    private static volatile ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){
        // Private constructor to prevent instantiation
    }

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
            System.out.println("New instance has been created");
        }
        return instance;
    }
}

class Main{
    public static void main(String[] args) {
        Singleton singletonInstance = Singleton.getInstance();
        ThreadSafeSingleton threadSafeSingletonInstance = ThreadSafeSingleton.getInstance();
    }
}