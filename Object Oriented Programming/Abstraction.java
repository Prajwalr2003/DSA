public class Abstraction {
    public static void main(String[] args)
    {
        Mustang ms = new Mustang();
        ms.walk();

        Chicken chicken = new Chicken();
        chicken.changeColor();
        System.out.println(chicken.color);
    }
}

abstract class Animal{
    String color;

    Animal(){
        // System.out.println("animal constructor is called...");
        color = "brown";
    }

    void eat(){
        System.out.println("animal eats");
    }

    abstract void walk();
}

class Horse extends Animal{
    Horse(){
        System.out.println("horse Constructor is called...");
    }
    void changeColor(){
        color = "dark brown";
    }
    void walk(){
        System.out.println("walk on 4 legs");
    }
}

class Mustang extends Horse{
    Mustang(){
        System.out.println("mustang constructor is called...");
    }
}
class Chicken extends Animal{
    void changeColor(){
        color = "white";
    }
    void walk(){
        System.out.println("walk on 2 legs");
    }
}
