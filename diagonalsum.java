import java.util.Scanner;
public class diagonalsum {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter the size of the square matrix");
        // int n = scanner.nextInt();

        int [][] mat = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int primary = 0;
        int secondary = 0;
        int total = 0;
        int n = mat.length;
        
        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j< mat[i].length; j++) {
                if (i==j) {
                    primary += mat[i][j]; 
                } else if (n-1-i==j) {
                    if (n-1-1!=i) {
                        secondary += mat[i][j];
                    }

                } 
            }
        }
        total = secondary + primary;
        System.out.println(total);
    }
    
}
