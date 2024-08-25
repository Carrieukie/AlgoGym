package strings;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
//    public static void main(String[] args) {
//        System.out.println(generateParenthesis(3));
//    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, 0,0,"", ans);
        return ans;
    }

    public static void generateParenthesis(int n, int opening, int closing, String comb, List<String> ans) {
        if (opening == closing && comb.length() == n * 2){
            ans.add(comb);
        }

        if (opening < n){
            generateParenthesis(n,opening + 1, closing, comb + "(", ans);
        }

        if (closing < opening){
            generateParenthesis(n,opening, closing + 1, comb + ")", ans);
        }
    }
}
