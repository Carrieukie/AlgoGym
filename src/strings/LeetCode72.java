package strings;

import java.util.HashMap;

public class LeetCode72 {
    public static void main(String[] args) {
        String X = "kitten", Y = "sitting";

        System.out.println("The Levenshtein distance is " +
                minDistance(X,Y));
    }

    public static int minDistance(String word1, String word2) {
        HashMap<String, Integer> memo = new HashMap<>();
        return dist(word1, word1.length(), word2, word2.length(),memo);
    }

    public static int dist(String X, int m, String Y, int n, HashMap<String, Integer> memo) {
        // base case: empty strings (case 1)
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        // Create a unique key for the current subproblem
        String key = m + "," + n;

        // If the result is already memoized, return it
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return dist(X, m - 1, Y, n - 1, memo);
        }

        int minMoves = minimum(dist(X, m - 1, Y, n, memo) + 1,    // deletion (case 3a))
                dist(X, m, Y, n - 1, memo) + 1,           // insertion (case 3b))
                dist(X, m - 1, Y, n - 1, memo) + 1);   // substitution (case 2 & 3c)
        memo.put(key,minMoves);

        return memo.get(key);
    }

    public static int minimum(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
