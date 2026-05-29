package inheritance;

public class Animal {


    String name;
    public Animal (String name) {
        this.name=name;
        System.out.println("Animal constructor.");
        
    }
    void eat() {
        System.out.println("This animal eats food!");
    }
}
