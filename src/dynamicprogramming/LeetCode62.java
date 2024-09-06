package dynamicprogramming;

import java.util.HashMap;

public class LeetCode62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(30000,7000));
    }

    public static long uniquePaths(int m, int n) {
        // Create a 2D array to store the number of unique paths to each cell
        long[][] dp = new long[m][n];

        // Fill the first row and first column with 1s since there's only one way to reach each cell in these rows and columns
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the rest of the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The number of ways to reach the current cell is the sum of the ways to reach the cell above and the cell to the left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The answer is stored in the bottom-right corner of the grid
        return dp[m - 1][n - 1];
    }
}
