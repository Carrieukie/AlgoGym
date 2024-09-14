package strings;

public class LeetCode151 {
//    public static void main(String[] args) {
//        System.out.println(reverseWords("the sky is blue"));
//    }
    public static String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            ans.append(str[i]);
            if (i != 0){
                ans.append(" ");
            }
        }
        ans.trimToSize();
        return ans.toString();
    }
}
