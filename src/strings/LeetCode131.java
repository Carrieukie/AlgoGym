package strings;

import java.util.*;

public class LeetCode131 {
//    public static void main(String[] args) {
//        System.out.println((partition("ababababababababababababcbabababababababababababa")));
//    }

    public static int partition(String s) {
        List<List<String>> result = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        backtrack(s, 0, new ArrayList<>(), result,set);
        if (set.isEmpty()){
            return 0;
        }else {
            return set.first();
        }
    }

    private static void backtrack(String s, int start, List<String> path, List<List<String>> result, TreeSet<Integer> set) {
        // If we've reached the end of the string, add the current partition to the result list
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            set.add(path.size());
            return;
        }
        // Explore all possible partitions
        for (int end = start; end <= s.length(); end++) {
            // If the current substring is a palindrome, add it to the current path
            String substring = s.substring(start,end);
            if (isPalindrome(substring)) {
                path.add(s.substring(start, end));
                // Recur to find other partitions
                backtrack(s, end , path, result, set);
                // Backtrack to explore other partitions
                path.remove(path.size() - 1);
            }
        }
    }

    private  static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}
