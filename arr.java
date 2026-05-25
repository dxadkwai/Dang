public class arr {
    public static void main (String args[]) {
        

        int [] numbers = {1,15,800,12,4};
        // numbers2[0] = 400;
        // int counter = 0;
        
        // // System.out.println(numbers2);
        // for (int number : numbers) {
        //     System.out.println("Counter at "+ counter++);
        //     System.out.println(number);
        // }

        // String[] friends = {"Nick", "Bob", "Joe", "Osala"};
        // for (String friend : friends) {
        //     System.out.println(friend);
        // }
        int sum = 0;
        int max = 0;
        int min = 10000;
        for (int number : numbers) {
            sum += number;
            if (number > max) {
                max = number;
            } 
            if (number < min) {
                min = number;
            }
        }
        System.out.println("Total is " + sum);
        System.out.println("Max is " + max);
        System.out.println("Min is " + min);
    }
    
}
