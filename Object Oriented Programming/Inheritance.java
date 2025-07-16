public class Inheritance {
    public static void main(String[] args){
        Shark sk = new Shark();
        sk.eat();

        Human akshay = new Human();
        akshay.breathe();
    }
}

class Animal{
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}

class Fish extends Animal{
    void fins(){
        System.out.println("120");
    }

    void swim(){
        System.out.println("Swims");
    }
}

class Bird extends Animal{
    void fly(){
        System.out.println("Flying");
    }
}

class Mammal extends Animal{
    void walk(){
        System.out.println("Walking");
    }
}

class Tuna extends Fish{
    void speed(){
        System.out.println("Fast");
    }
}

class Shark extends Fish{
    void danger(){
        System.out.println("Villain");
    }
}

class Peacock extends Bird{
    void dance(){
        System.out.println("Dances");
    }
}

class Dog extends Mammal{
    void bark(){
        System.out.println("Barking");
    }
}

class Cat extends Mammal{
    void sound(){
        System.out.println("Meoww");
    }
}

class Human extends Mammal{
    void toilet(){
        System.out.println("Bathroom");
    }
}