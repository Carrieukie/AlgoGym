import java.util.HashSet;

public class LeetCode3 {
//    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0, left = 0;
        HashSet<Character> seen = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char current =  s.charAt(right);

            while (seen.contains(current)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(current);
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
