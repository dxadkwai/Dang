import java.util.Arrays;

public class duplicate {
    public static int[] duplicateNum (int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        Arrays.sort(nums);

        int [] temp = new int[nums.length];
        int j = 0;

        for (int i =0; i < nums.length - 1; i++) {
            if (nums[i]!=nums[i+1]) {
                temp[j++] = nums[i];
                
            }

        }

        temp[j++] = nums[nums.length-1];

        int [] result = new int[j];
        for (int i =0; i < j; i++) {
            result[i] = temp[j];
        }

        return result;

    }

    public static void main(String[] args) {
        // Example array with duplicates
        int[] array = {4, 5, 9, 4, 2, 2, 8, 9, 1, 3, 6, 1};
 
        // Remove duplicates
        int[] uniqueArray = duplicateNum(array);
 
        // Print the result
        System.out.println("Array with duplicates removed: " + Arrays.toString(uniqueArray));

    }

}
