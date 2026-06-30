import java.util.ArrayList;
import java.util.Arrays;

public class bigo {



    // public static void printItems(int n) {
    //     for (int i = 0; i<n; i++) {
    //         System.out.println(i);
    //     }

    //     for (int j = 0; j<n; j++) {
    //         System.out.println(j);
    //     }
    // }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(2, 3, 5, 8, 10));
        System.out.println(myList);


        myList.remove(2);
        System.out.println(myList);
    }
}
