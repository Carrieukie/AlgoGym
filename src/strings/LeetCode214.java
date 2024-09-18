package strings;

public class LeetCode214 {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("daa"));
    }

    public static String shortestPalindrome(String s) {
        StringBuilder r = new StringBuilder(s).reverse();
        for (int i = 0; i <= s.length(); i++) {
            String sSubs = r.substring(i);
            if (s.startsWith(sSubs)) {
                return r.substring(0, i) + s;
            }
        }
        return ""; // This line won't be reached since s is guaranteed to have a palindrome
    }
}

