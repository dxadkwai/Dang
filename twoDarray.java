public class twoDarray {
    public static void main(String[] args) {
        // int [][] myArray = new int[5][5];
        // myArray[0][0] = 1;
        // myArray[0][1] = 2;
        // myArray[0][2] = 3;
        // myArray[1][0] = 4;
        // myArray[1][1] = 5;
        // myArray[1][2] = 6;
        // myArray[2][0] = 7;
        // myArray[2][1] = 8;
        // myArray[2][2] = 9;
        int[][] myArray = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        // int max = 0;
        int total = 0;
        for (int[] element : myArray) {
            for (int element2 : element) {
                total += element2;
            }
            
        }
        System.out.println(total);

    }
    
}
