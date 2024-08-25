public class LeetCode67 {
//    public static void main(String[] args) {
//        System.out.println(addBinary("11010101010100101001010101001010101001010101010010101001001010101010100101010100101","1110010101010100101010010101010101010010101010010101010101"));
//    }

    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int indexa = a.length() - 1;
        int indexb = b.length() - 1;
        int carry = 0;

        while (indexa >= 0 || indexb >= 0 || carry == 1) {
            if (indexa >= 0) {
                carry += a.charAt(indexa) - '0';
                indexa--;
            }

            if (indexb >= 0) {
                carry += b.charAt(indexb) - '0';
                indexb--;
            }
            builder.append(carry % 2);
            carry = carry /2;
        }

        return builder.reverse().toString();
    }
}
