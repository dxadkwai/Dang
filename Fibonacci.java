import java.util.Scanner;
public class Fibonacci {
    public static void main(String args[]) {
        Scanner max = new Scanner (System.in);
        System.out.println("How many numbers do you like in this Fibonacci sequence: ");
        int number = max.nextInt();
        int n1 = 0;
        int n2 = 1;
        int temp = 0;
        System.out.print(n1 + ", ");
        System.out.print(n2 + ", ");
        for (int i = 0; i < (number-2); i++) {
            temp = n1+n2;
            System.out.print(temp + ", ");
            n1 = n2;
            n2 = temp;
           
        }
    }
    
}
