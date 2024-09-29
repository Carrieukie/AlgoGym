package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {
    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7).forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        getSolutions(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private static void getSolutions(List<List<Integer>> ans, ArrayList<Integer> current, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(current));
        }

        for (int i = start; i < candidates.length; i++) {
//            if (i > start && candidates[i] == candidates[i - 1]) {
//                continue; // Skip duplicates
//            }
            current.add(candidates[i]);
            getSolutions(ans, current, candidates, target - candidates[i], i); // Not i + 1 because we can reuse the same element
            current.remove(current.size() - 1); // Backtrack
        }
    }

}
