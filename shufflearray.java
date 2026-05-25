public class shufflearray {
    public static void main(String args[]) {
        int [] nums = {1,3,5,9,10,14};
        int n = nums.length/2;

        int[] rearranged = new int[nums.length];
        for (int i = 0; i<n;i++) {
            rearranged[2*i] = nums[i];
            rearranged[2*i + 1] = nums[i+n];

        }
        System.out.print("Rearranged array: ");
        for (int i : rearranged) {
            System.out.print(i + " ");
        
        }
    }
    
}
