import java.util.Scanner;
public class input {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);//scanner is an object with the class called Scanner
        System.out.println("What is your name: ");
        String name = scanner.nextLine();
        System.out.println("Welcome to ... " + name );
        scanner.close();

        Scanner a_num = new Scanner(System.in);
        System.out.println("Give me a number: ");
        int a = a_num.nextInt();
        Scanner b_num = new Scanner (System.in);
        System.out.println("Give me a second number: ");
        int b = b_num.nextInt();
        int sum = a + b;
        System.out.println("The total is: " + sum);

        String food1, food2, food3;
        int calo1, calo2, calo3, totalCalories;

        Scanner food_1 = new Scanner (System.in);
        System.out.println("Enter the first food: ");
        food1 = food_1.nextLine();
        Scanner calorie_1 = new Scanner (System.in);
        System.out.println("Enter the calorie for "+ food1 +":");
        calo1=calorie_1.nextInt();

        Scanner food_2 = new Scanner (System.in);
        System.out.println("Enter the second food: ");
        food2 = food_2.nextLine();
        Scanner calorie_2 = new Scanner (System.in);
        System.out.println("Enter the calorie for "+ food2 +":");
        calo2=calorie_2.nextInt();

        Scanner food_3 = new Scanner (System.in);
        System.out.println("Enter the third food: ");
        food3 = food_3.nextLine();
        Scanner calorie_3 = new Scanner (System.in);
        System.out.println("Enter the calorie for "+ food3 +":");
        calo3=calorie_3.nextInt();


        totalCalories = calo1 + calo2 + calo3;
        System.out.println("Total calorie intake: " + totalCalories +" kcal");

        // int a=5, b=5;
        // boolean result = (a==b); //this is will output true
        // System.out.println(result);

        // result = (a!=b);
        // System.out.println(result);


    }
    
}
