package arrays;

public class LeetCode41 {
    public static void main(String[] args) {

    }

    public static int firstMissingPositive(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (current < 0 || current >= nums.length){
                continue;
            }
            nums[current] = nums[current] * -1;
        }

        return ans;
    }
}
