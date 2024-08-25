package strings;

import java.util.*;

public class LeetCode32 {
//    public static void main(String[] args) {
//        System.out.println(longestValidParentheses(")()())"));
//    }

    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '('){
                left++;
            }else {
                right ++;
            }

            if (right == left){
                ans = Math.max(ans, left + right);
            }

            if (right > left){
                left = 0;
                right = 0;
            }
        }

        return ans;
    }
}
