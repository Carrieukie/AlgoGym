package strings;

public class LeetCode168 {
//    public static void main(String[] args) {
//        System.out.println(convertToTitle(28));
//    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();

        while (columnNumber > 0) {
            int remainder = (columnNumber - 1) % 26;  // Adjust to make 'Z' work correctly
            str.append((char)('A' + remainder));  // Append the correct character
            columnNumber = (columnNumber - 1) / 26;  // Update the column number
        }

        return str.reverse().toString();
    }
}
