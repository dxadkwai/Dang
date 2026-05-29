package inheritance;

public class Device {
    String brand;
    String model;

    public Device (String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("The brand is "+brand);
        System.out.println("The model is "+model);


    }
}
