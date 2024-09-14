package strings;

import java.util.HashMap;

public class LeetCode205 {
//    public static void main(String[] args) {
//        System.out.println(isIsomorphic("edgg","addd"));
//    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Character> sToTMap = new HashMap<>();
        HashMap<Character, Character> tToSMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Check forward mapping
            if (sToTMap.getOrDefault(sChar, tChar) != tChar) {
                return false;
            }
            sToTMap.putIfAbsent(sChar, tChar);

            // Check reverse mapping
            if (tToSMap.getOrDefault(tChar, sChar) != sChar) {
                return false;
            }
            tToSMap.putIfAbsent(tChar, sChar);
        }

        return true;
    }
}
