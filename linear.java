public class linear {
    public static void main(String[] args) {
        int nums[] = {5, 6 ,10, 4, 9};
        int target = 9;

        int result = linearSearch(nums,target);

        if (result!= -1) {
            System.out.println("The index of target is at " + result);
        } else {
            System.out.println("Not found");
        }
    }

    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i<nums.length;i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
}