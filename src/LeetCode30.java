import java.util.*;

public class LeetCode30 {
//    public static void main(String[] args) {
//        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar","the"}));
//    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || words.length == 0 || words[0].isEmpty()) {
            return ans;
        }

        int singleWordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = singleWordLength * totalWords;

        // Create a frequency map for the words
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Slide over the string with different starting points within a single word length
        for (int i = 0; i < singleWordLength; i++) {
            int leftPointer = i, rightPointer = i;
            int matchedWords = 0;

            Map<String, Integer> window = new HashMap<>();

            while (rightPointer + singleWordLength <= s.length()) {
                // Extract the word from the right pointer
                String word = s.substring(rightPointer, rightPointer + singleWordLength);
                rightPointer += singleWordLength;

                if (wordCountMap.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);

                    if (window.get(word).equals(wordCountMap.get(word))) {
                        matchedWords++;
                    }

                    // If the window size exceeds the total length, move the left pointer
                    while (rightPointer - leftPointer == totalLength) {
                        if (matchedWords == wordCountMap.size()) {
                            ans.add(leftPointer);
                        }

                        String leftWord = s.substring(leftPointer, leftPointer + singleWordLength);
                        leftPointer += singleWordLength;

                        if (wordCountMap.containsKey(leftWord)) {
                            if (window.get(leftWord).equals(wordCountMap.get(leftWord))) {
                                matchedWords--;
                            }
                            window.put(leftWord, window.get(leftWord) - 1);
                        }
                    }
                } else {
                    // Reset the window if a word not in `words` is found
                    window.clear();
                    matchedWords = 0;
                    leftPointer = rightPointer;
                }
            }
        }
        return ans;
    }
}
