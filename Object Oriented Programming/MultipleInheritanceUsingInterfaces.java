public class MultipleInheritanceUsingInterfaces {
    public static void main(String[] args){
        Bear b = new Bear();
        b.eats();
        b.hunts();
    }
}

interface Herbivores{
    void eats();
}

interface Carnivores{
    void hunts();
}

class Bear implements Herbivores, Carnivores{
    public void eats(){
        System.out.println("eats grass & meat");
    }
    public void hunts(){
        System.out.println("hunts animal");
    }
}
