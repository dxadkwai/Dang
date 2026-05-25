import java.util.Scanner;
public class harshad {
    public static void main (String args[]) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        int num = number;
        int sum = 0;
        while (num>0) {
            sum += (num%10);
            num/=10;
        } 
        
        
        if (number % sum == 0) {
            System.out.println("THis is a Harshad number!");
        } else {
            System.out.println("THis is not a Harshad number!");
        }
        
    }
}
