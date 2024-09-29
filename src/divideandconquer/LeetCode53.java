package divideandconquer;

public class LeetCode53 {
//    public static void main(String[] args) {
//
//    }

    public int maxSubArray(int[] nums) {
        int best = Integer.MIN_VALUE, sum = 0;
        for (int k = 0; k < nums.length; k++) {
            sum = Math.max(nums[k], sum + nums[k]);
            best = Math.max(best, sum);
        }
        return best;
    }
}
