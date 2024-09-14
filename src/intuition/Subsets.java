package intuition;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
//    public static void main(String[] args) {
//        System.out.println(generateSubsets("aab"));
//    }

    public static List<String> generateSubsets(String input) {
        List<String> subsets = new ArrayList<>();
        generateSubsets(subsets, input, 0, "");
        return subsets;
    }

    private static void generateSubsets(List<String> subsets, String input, int index, String curr) {
        if (index == input.length()) {
            subsets.add(curr);
            return;
        }
        generateSubsets(subsets, input, index + 1, curr);
        generateSubsets(subsets, input, index + 1, curr + input.charAt(index));
    }
}
