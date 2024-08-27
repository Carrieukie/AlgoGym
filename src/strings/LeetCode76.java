package strings;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public static void main(String[] args) {
        System.out.println(minWindow("kdasdasdasdasfmkdl", "dsd"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = t.length();
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int head = 0;

        while (right < s.length()) {
            char endChar = s.charAt(right++);
            if (map.containsKey(endChar)) {
                if (map.put(endChar, map.get(endChar) - 1) > 0) counter--;
            }

            while (counter == 0) { // valid window
                if (right - left < minLength) {
                    minLength = right - (head = left);
                }

                char startChar = s.charAt(left++);
                if (map.containsKey(startChar)) {
                    if (map.put(startChar, map.get(startChar) + 1) == 0) counter++; // make it invalid
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(head, head + minLength);
    }
}
