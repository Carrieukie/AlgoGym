package strings;

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

//    public static String addBinary(String a, String b) {
//        return addBinaryRecursive(a, b, 0);
//    }

    private static String addBinaryRecursive(String a, String b, int carry) {
        // Base case: if both strings are empty and there's no carry, return an empty string
        if (a.isEmpty() && b.isEmpty() && carry == 0) {
            return "";
        }

        // If one string is empty, treat its value as "0"
        int aBit = a.isEmpty() ? 0 : a.charAt(a.length() - 1) - '0';
        int bBit = b.isEmpty() ? 0 : b.charAt(b.length() - 1) - '0';

        // Calculate the current sum and new carry
        int sum = aBit + bBit + carry;
        int currentBit = sum % 2;
        int newCarry = sum / 2;

        // Recursively process the next digits
        String nextA = a.isEmpty() ? "" : a.substring(0, a.length() - 1);
        String nextB = b.isEmpty() ? "" : b.substring(0, b.length() - 1);

        return addBinaryRecursive(nextA, nextB, newCarry) + currentBit;
    }

}
