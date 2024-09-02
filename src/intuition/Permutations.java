package intuition;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
//    public static void main(String[] args) {
//        List<String> ans = generatePermutations("abc");
//        System.out.println(ans);
//    }

    private static List<String> generatePermutations(String str) {
        List<String> ans = new ArrayList<>();
        generatePermutations(str, "", ans);
        return ans;
    }

    private static void generatePermutations(String str, String current, List<String> ans) {
        if (str.isEmpty()) {
            ans.add(current);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            // Choose the current character
            char ch = str.charAt(i);
            // Form the remaining string excluding the chosen character
            String remaining = str.substring(0, i) + str.substring(i + 1);
            // Recur with the chosen character added to the current string
            generatePermutations(remaining, current + ch, ans);
        }
    }

    private static List<String> generatePermutationsBackTracking(String str) {
        List<String> ans = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        generatePermutations(str, new StringBuilder(), used, ans);
        return ans;
    }


    private static void generatePermutations(String str, StringBuilder current, boolean[] used, List<String> ans) {
        if (current.length() == str.length()) {
            ans.add(current.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (used[i]) continue; // Skip if this character is already used

            // Make the choice
            used[i] = true;
            current.append(str.charAt(i));

            // Explore further
            generatePermutations(str, current, used, ans);

            // Backtrack: undo the choice
            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
}
