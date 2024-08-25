import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
//    public static void main(String[] args) {
//        System.out.println(letterCombinations("23"));
//    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.isEmpty()){
            return ans;
        }

        String[][] keypad = {
                {},
                {},
                {"a","b","c"},
                {"d","e","f"},
                {"g","h","i"},
                {"j","k","l"},
                {"m","n","o"},
                {"p","q","r","s"},
                {"t","u","v"},
                {"w","x","y","z"}
        };

        generatePermutations(keypad,digits,ans,0,"");

        return ans;
    }

    private static void generatePermutations(String[][] keypad, String digits, List<String> ans, int index,String combination) {
        if (index == digits.length()){
            ans.add(combination);
            return;
        }

        String[] possibilities = keypad[Integer.valueOf(String.valueOf(digits.charAt(index)))];

        for (int i = 0; i < possibilities.length; i++) {
            generatePermutations(keypad, digits, ans, index + 1, combination + possibilities[i]);
        }
    }
}
