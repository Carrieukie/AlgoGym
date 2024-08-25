public class LeetCode38 {
//    public static void main(String[] args) {
//        System.out.println(countAndSay(4));
//    }
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return rleEncode(countAndSay(n - 1));
    }

    public static String rleEncode(String number) {
        StringBuilder result = new StringBuilder();
        char prevChar = number.charAt(0);
        int count = 1;

        for (int i = 1; i < number.length(); i++) {
            char currentChar = number.charAt(i);
            if (currentChar == prevChar) {
                count++;
            } else {
                result.append(count).append(prevChar);
                prevChar = currentChar;
                count = 1;
            }
        }

        // Append the last group
        result.append(count).append(prevChar);
        return result.toString();
    }

}
