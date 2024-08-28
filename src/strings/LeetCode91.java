package strings;

import java.util.Arrays;

public class LeetCode91 {
//    public static void main(String[] args) {
//        System.out.println(numDecodings("11106"));
//    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodings(s, 0, dp);
    }

    private static int numDecodings(String s, int i, int[] dp) {
        if (s.length() == i) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1){
            return dp[i];
        }

        int ways = numDecodings(s, i + 1, dp);

        if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            ways += numDecodings(s, i + 2, dp);
        }
        dp[i] = ways;
        return ways;
    }

}
