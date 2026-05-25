import java.util.Scanner;
public class while_loop {
    public static void main (String args[]) {
        // Scanner scanner = new Scanner (System.in);
        // int input;
        // do {
        //     System.out.println("Please enter a number. Enter 0 to exit! ");
        //     input = scanner.nextInt();
        //     System.out.println("THanks for entering! ");
            
        // }   while (input !=0) ;
        //     scanner.close();

        for (int i = 0; i <=5; i++) {
            if (i ==3) {
                break;
            }
            System.out.println(i);

        }
        System.out.print("THats the end!");
        
    }
    
}
