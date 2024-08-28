package strings;

public class LeetCode125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("OP"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                builder.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String cleanedString = builder.toString();
        String reversedString = builder.reverse().toString();

        return cleanedString.equals(reversedString);
    }

}
