package strings;

import java.util.Arrays;

public class LeetCode115 {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return numDistinct(s, t, 0, 0, dp);
    }

    private static int numDistinct(String s, String t, int sIndex, int tIndex, int[][] dp) {
        if (t.length() == tIndex) {
            return 1;
        }

        if (s.length() == sIndex) {
            return 0;
        }

        if (dp[sIndex][tIndex] != -1){
            return dp[sIndex][tIndex];
        }

        int take = 0;
        int notTake;

        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            take = numDistinct(s, t, sIndex + 1, tIndex + 1, dp);
        }
        notTake = numDistinct(s, t, sIndex + 1, tIndex, dp);


        int numDistict = take + notTake;
        dp[sIndex][tIndex] = numDistict;
        return numDistict;
    }
}
