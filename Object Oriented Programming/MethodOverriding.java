public class MethodOverriding {
    public static void main(String[] args){
        Deer deer = new Deer();
        deer.eat();
    }
}

class Animal{
    String color;

    void eat(){
        System.out.println("eats anything");
    }
}

class Deer extends Animal{
    void eat(){
        System.out.println("eat grass");
    }
}