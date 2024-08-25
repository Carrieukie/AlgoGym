package strings;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode6 {

//    public static void main(String[] args) {
//        String ans = convert("PAYPALISHIRING", 3);
//        System.out.println(ans);
//    }

    public static String convert(String s, int numRows) {
        if (s == null){
            return "";
        }

        if (numRows <= 1){
            return s;
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder [] rows = new StringBuilder[numRows];

        // init stringbuilders
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int rowIndex = 0;
        int incValue = 1;

        for (int i = 0; i < s.length(); i++) {
            rows[rowIndex].append(s.charAt(i));

            if (rowIndex == 0){
                incValue = 1;
            }

            if (rowIndex == numRows -1){
                incValue = -1;
            }

            rowIndex += incValue;

        }

        for (int i = 0; i < rows.length; i++) {
            ans.append(rows[i].toString());
        }
        return ans.toString();
    }
}
