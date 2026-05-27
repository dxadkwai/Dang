package OOp;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many students do you want to enter");
        int num = scanner.nextInt();

        student [] students = new student[num];
        for (int i = 0; i < num; i++) {
            scanner.nextLine();
            System.out.println("Enter details for student "+(i+1)+":" );
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Roll Number: ");
            int rollNumber = scanner.nextInt();
            
            System.out.print("Age: ");
            int age = scanner.nextInt();
            
            System.out.print("Height (in cm): ");
            double height = scanner.nextDouble();


            students[i] = new student(name, age, height, rollNumber) ;

        }

        calculate(students);
        scanner.close();


    
    }

    public static void calculate(student[] students) {
        int totalAge = 0;
        double totalHeight = 0.0;
        int oldestAge = students[0].age;
        double tallestHeight = students[0].height;
        String oldestStudent = students[0].name;
        String tallestStudent = students[0].name;

        for (student student : students) {
            totalAge += student.age;
            totalHeight += student.height;
            
            if (student.age>oldestAge) {
                oldestAge = student.age;
                oldestStudent = student.name;
            }

            if (student.height>tallestHeight) {
                tallestHeight = student.height;
                tallestStudent = student.name;
            }
        }


        double averageAge = (double) totalAge / students.length;
        double averageHeight = totalHeight / students.length;
 
        System.out.println("\n--- Statistics ---");
        System.out.println("Average Age: " + averageAge + " years");
        System.out.println("Average Height: " + averageHeight + " cm");
        System.out.println("Oldest Student: " + oldestStudent + " (Age: " + oldestAge + " years)");
        System.out.println("Tallest Student: " + tallestStudent + " (Height: " + tallestHeight + " cm)");
    }

   
    
}
