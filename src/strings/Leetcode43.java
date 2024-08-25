package strings;

public class Leetcode43 {
//    public static void main(String[] args) {
//        System.out.println(multiply("123", "456"));
//    }

    public static String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int one = num1.charAt(i) - '0';
                int two = num2.charAt(j) - '0';
                int product = one * two;

                int p1 = i + j;
                int p2 = i + j + 1;

                int carriedForward = product + pos[p2];
                pos[p1] += carriedForward / 10;
                pos[p2] = carriedForward % 10;
            }
        }

        for(int p : pos) if(!(sb.isEmpty() && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
