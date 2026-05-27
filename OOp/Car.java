package OOp;

public class Car {
    String color;
    String model;
    int year;


    // default constructor
    // public Car() {
    //     System.out.println("Recording data for new car!");
    //     color = "Unknown";
    //     model = "unknown";

    // }

    //*parameterized constructor */

    public Car(String mycolor, String mymodel, int myyear) {
        color = mycolor;
        model = mymodel;
        year = myyear;
    }


    public void showDetails() {
        System.out.println("Hi");
    }
}
