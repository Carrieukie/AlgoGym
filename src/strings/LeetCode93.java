package strings;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
//    public static void main(String[] args) {
//        System.out.println(restoreIpAddresses("255255128"));
//    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return new ArrayList<>();
        }
        ArrayList<String> ans = new ArrayList<>();
        generateIps(s, ans, 0, "", 0);
        return ans;
    }

    private static void generateIps(String curr, ArrayList<String> ans, int index, String temp, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4 && index == curr.length()) {
            ans.add(temp);
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > curr.length()) {
                break;
            }
            String s = curr.substring(index, i + index);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) {
                continue;
            }
            generateIps(curr, ans, index + i, temp + s + (count == 3 ? "" : "."), count + 1);
        }
    }
}
