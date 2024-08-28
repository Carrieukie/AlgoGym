package strings;

public class LeetCode97 {
//    public static void main(String[] args) {
//        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return isInterleave(s1, s2, s3, 0, 0, 0, memo);
    }

    private static boolean isInterleave(String s1, String s2, String s3, int indexs1, int indexs2, int indexs3, Boolean[][] memo) {
        if (indexs3 == s3.length()) {
            return true;
        }

        if (memo[indexs1][indexs2] != null){
            return memo[indexs1][indexs2];
        }

        if (indexs1 < s1.length() && s3.charAt(indexs3) == s1.charAt(indexs1)) {
            boolean isInterleave = isInterleave(s1, s2, s3, indexs1 + 1, indexs2, indexs3 + 1, memo);
            memo[indexs1][indexs2] = isInterleave;
            if (isInterleave) {
                return true;
            }
        }

        if (indexs2 < s2.length() && s3.charAt(indexs3) == s2.charAt(indexs2)) {
            boolean isInterleave = isInterleave(s1, s2, s3, indexs1, indexs2 + 1, indexs3 + 1, memo);
            memo[indexs1][indexs2] = isInterleave;
            if (isInterleave) {
                return true;
            }
        }
        memo[indexs1][indexs2] = false;
        return false;
    }
}
