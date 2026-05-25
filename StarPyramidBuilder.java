import java.util.Scanner;
 
public class StarPyramidBuilder {
    public static void main(String args[]) {
        // Step 1: Declare and initialize Scanner object
        Scanner scanner = new Scanner(System.in);
 
        // Step 2: Prompt the user for input
        System.out.print("Enter the number of levels: ");
        int levels = scanner.nextInt();
 
        // Step 3: Build the pyramid using nested loops
        for (int i = 1; i <= levels; i++) {
            // Print leading spaces (COMPLETE THIS PART)
            for (int j = 0; j <(levels - i) ; j++) {
                System.out.print(" ");
            }
            // Print stars (COMPLETE THIS PART)
            for (int k = 0; k <(2*i-1) ; k++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }
 
        // Step 4: Close Scanner
        scanner.close();
    }
}