package inheritance;

public class Computer extends Device {
    int ram;
    int storage;





    public Computer(String brand, String model, int ram, int storage) {
        super(brand, model);
        //TODO Auto-generated constructor stub
        this.ram = ram;
        this.storage = storage;



    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Ram: "+ram);
        System.out.println("Storage: "+storage); 
    }
    
}
