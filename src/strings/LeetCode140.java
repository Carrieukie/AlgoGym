package strings;

import java.util.ArrayList;
import java.util.List;

public class LeetCode140 {
//    public static void main(String[] args) {
//        System.out.println(wordBreak("catsanddog", new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"))));
//    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        wordBreak(s, wordDict, ans, new StringBuilder());
        return ans;
    }

    private static void wordBreak(String s, List<String> wordDict, List<String> ans, StringBuilder stringBuilder) {
        if (s.isEmpty()) {
            ans.add(stringBuilder.toString().trim());
            return;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                int originalLength = stringBuilder.length();

                stringBuilder.append(" ").append(word);

                wordBreak(s.substring(word.length()), wordDict, ans, stringBuilder);

                // Backtrack by removing the added word and possible preceding space
                stringBuilder.delete(originalLength, stringBuilder.length());
            }
        }
    }
}
