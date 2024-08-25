import java.util.Stack;

public class LeetCode71 {
//    public static void main(String[] args) {
//        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
//    }

    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].trim() != "") {
                stack.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!stack.isEmpty()) {
            String s = stack.pop();

            if (s.equals("..")) {
                count++;
            } else if (s.equals(".")) {

            } else {
                if (count == 0) {
                    sb.insert(0, "/" + s);
                } else {
                    count--;
                }
            }
        }
        return sb.toString().isEmpty() ? "/" : sb.toString();
    }
}
