package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode139 {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsandog", new ArrayList<>(List.of("cats", "dog", "sand", "and", "cat"))));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }

    public static boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> dp) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        if (s.isEmpty()) {
            return true;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                boolean res = (wordBreak(s.substring(word.length()), wordDict, dp));
                if (res) {
                    dp.put(s, true);
                    return true;
                } else {
                    dp.put(s, false);
                }
            }
        }
        dp.put(s, false);
        return false;
    }
}
