public class LeetCode8 {
//    public static void main(String[] args) {
//
//    }
    public static boolean isMatch(String string, String pattern) {
        // Memoization table, initialized with null
        Boolean[][] memo = new Boolean[string.length() + 1][pattern.length() + 1];
        return isMatch(string, pattern, 0, 0, memo);
    }

    private static boolean isMatch(String string, String pattern, int stringIndex, int patternIndex, Boolean[][] memo) {
        // Base case: if both indices have reached the end, we have a match
        if (stringIndex == string.length() && patternIndex == pattern.length()) {
            return true;
        }

        // Base case: if pattern is exhausted but string is not, it's not a match
        if (patternIndex == pattern.length()) {
            return false;
        }

        // Check if this state is already computed
        if (memo[stringIndex][patternIndex] != null) {
            return memo[stringIndex][patternIndex];
        }

        // Check if the current characters match
        boolean charsMatch = stringIndex < string.length() &&
                (string.charAt(stringIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.');

        // Check if the next character in the pattern is '*'
        boolean nextOneStar = patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*';

        final boolean isMatch;

        if (nextOneStar) {
            // Two cases for '*' handling:
            // 1. Skip the '*' and the preceding element
            // 2. If charsMatch, use '*' to match one or more of the current character
            isMatch = isMatch(string, pattern, stringIndex, patternIndex + 2, memo) ||
                    (charsMatch && isMatch(string, pattern, stringIndex + 1, patternIndex, memo));
        } else {
            // If there is no '*', simply move to the next characters if charsMatch
            isMatch = charsMatch && isMatch(string, pattern, stringIndex + 1, patternIndex + 1, memo);
        }

        // Store the result in the memoization table
        memo[stringIndex][patternIndex] = isMatch;
        return isMatch;
    }
}
