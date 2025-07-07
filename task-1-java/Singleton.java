import java.util.*;

class Singleton{
    private static Singleton instance;
    private Singleton(){
        System.out.println("Singleton is Instantiated.");
    }
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    public static void action(){
        System.out.println("Something is Done");
    }
    public static void main(String[] args){
        Singleton.getInstance().action();
    }
}

