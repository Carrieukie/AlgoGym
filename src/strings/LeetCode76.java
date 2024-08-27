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
            char rightChar = s.charAt(right++);
            if (map.containsKey(rightChar)) {
                // Decrement the frequency of the character in the map
                int newCount = map.get(rightChar) - 1;
                map.put(rightChar, newCount);

                // If the character is still needed (i.e., its count was positive), decrease the counter
                if (newCount >= 0) {
                    counter--;
                }
            }


            while (counter == 0) { // This loop runs as long as we have a valid window
                // Update the minimum length and head position if this window is smaller than the previous ones
                int currentMin = right - left;
                if (currentMin < minLength) {
                    minLength = currentMin;
                    head = left; // Store the start position of the smallest valid window
                }

                // Move the left pointer to narrow the window
                char startChar = s.charAt(left++);

                // If the character at the left pointer was part of the target string, adjust the map
                if (map.containsKey(startChar)) {
                    // Increment the frequency of the character in the map since it is leaving the window
                    int newCount = map.put(startChar, map.get(startChar) + 1);

                    // If the character count becomes positive, it means the window is no longer valid
                    if (newCount > 0) {
                        counter++; // We now need this character again to satisfy the condition
                    }
                }
            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(head, head + minLength);
    }
}
