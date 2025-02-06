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