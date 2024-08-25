import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {

    private static final Map<String, Integer> romanToIntMap = new HashMap<>();

    static {
        romanToIntMap.put("I", 1);
        romanToIntMap.put("IV", 4);
        romanToIntMap.put("V", 5);
        romanToIntMap.put("IX", 9);
        romanToIntMap.put("X", 10);
        romanToIntMap.put("XL", 40);
        romanToIntMap.put("L", 50);
        romanToIntMap.put("XC", 90);
        romanToIntMap.put("C", 100);
        romanToIntMap.put("CD", 400);
        romanToIntMap.put("D", 500);
        romanToIntMap.put("CM", 900);
        romanToIntMap.put("M", 1000);
    }

    public int romanToInt(String s) {
        int ans = 0;
        int i = 0;

        while (i < s.length()) {
            // Check if a two-character combination exists
            if (i < s.length() - 1 && romanToIntMap.containsKey(s.substring(i, i + 2))) {
                ans += romanToIntMap.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += romanToIntMap.get(s.substring(i, i + 1));
                i++;
            }
        }

        return ans;
    }
}
