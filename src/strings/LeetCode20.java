package strings;

import java.util.Stack;

public class LeetCode20 {
//    public static void main(String[] args) {
//        System.out.println(isValid("(]"));
//    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{'){
                stack.push('}');
            } else if (s.charAt(i) == '['){
                stack.push(']');
            } else if (s.charAt(i) == '('){
                stack.push(')');
            } else {
               return s.charAt(i) == stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
