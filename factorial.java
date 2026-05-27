public class factorial {
    public static void main(String[] args) {
        int number = 4;
        int result = factorial(number);
        System.out.println("The result of the factorial of " + number + " is " + result);
        
    }


    public static int factorial(int n) {
        if (n ==0 ) {
            return 0;
        }
        return n*factorial(n-1);
    }
}
