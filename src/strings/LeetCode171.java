package strings;

public class LeetCode171 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AAA"));
    }

    public static int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int currentCharIndex = (int) columnTitle.charAt(i) - 'A' + 1;
            res = res * 26  + currentCharIndex;
        }
        return res;
    }
}
