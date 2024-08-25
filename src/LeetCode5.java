public class LeetCode5 {


    public static String longestPalindrome(String s) {

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String evenSubstring = expandFromTheCenter(s,i,i+ 1);
            String oddSubstring = expandFromTheCenter(s,i,i);

            if (evenSubstring.length() > ans.length()){
                ans = evenSubstring;
            }

            if (oddSubstring.length() > ans.length()){
                ans = oddSubstring;
            }
        }
        return ans;
    }

    private static String expandFromTheCenter(String s, int toLeft, int toRight){
        while (toLeft > -1 && toRight < s.length() && s.charAt(toLeft) == s.charAt(toRight)){
            toLeft --;
            toRight ++;
        }
        return s.substring(toLeft+1,toRight);
    }
}
