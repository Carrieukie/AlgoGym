package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode187 {
//    public static void main(String[] args) {
//        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
//    }

    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> ans = new HashSet<>();
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            // Get the current substring of length 10
            String currentSubstring = s.substring(i, i + 10);

            if (seen.contains(currentSubstring)) {
                ans.add(currentSubstring);
            }
            seen.add(currentSubstring);
        }

        // Convert the result set to a list and return it
        return List.copyOf(ans);
    }
}
