package strings;

public class LeetCode12 {
//    public static void main(String[] args) {
//        System.out.println(intToRoman(4));
//    }

    public static String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();

        // Define the values and corresponding Roman numerals
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                ans.append(symbols[i]);
            }
        }

        return ans.toString();
    }

}
