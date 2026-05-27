package quadraticformula;
import java.util.Scanner;
public class equation {
    int a;
    int b;
    int c;

    public equation() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    } 

    public void Solution() {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Type in the coefficient of x^2: ");
        a = scanner.nextInt();
        System.out.print("Type in the coefficient of x^1: ");
        b = scanner.nextInt();
        System.out.print("Type in the coefficient of x^0: ");
        c = scanner.nextInt();


        calculateSolution(a,b,c); 
    }
    
    public void calculateSolution(int a, int b, int c) {
        double discriminant = (b * b) - (4 * a * c);

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("There are 2 roots in this equation: ");
            System.out.println("x1 = " + root1);
            System.out.println("x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2.0 * a);
            System.out.println("There is 1 root in this equation:");
            System.out.println("x = " + root);
        } else {
            System.out.println("No real roots.");
        }
    }   
}  
