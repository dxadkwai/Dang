import java.util.ArrayList;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("Apple");fruits.add("Banana");fruits.add("Cherry");
        
        System.out.println(fruits.get(0));
        boolean fr = fruits.contains("Banana");
        System.out.print(fr);
        
        // for (String fruit : fruits) {
        //     System.out.println(fruit);
        // }


    }
}
