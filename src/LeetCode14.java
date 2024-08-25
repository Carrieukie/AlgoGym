public class LeetCode14 {
//    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(
//                new String[]{"flower","flow","flight"}
//        ));
//    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // Start with the first string as the initial prefix

        for (int i = 1; i < strs.length; i++) {
            String currentString = strs[i];
            int pointer = 0;

            // Compare the prefix with the current string character by character
            while (pointer < prefix.length() && pointer < currentString.length() && prefix.charAt(pointer) == currentString.charAt(pointer)) {
                pointer++;
            }

            // Update the prefix with the common portion found so far
            prefix = prefix.substring(0, pointer);

            // If at any point the common prefix becomes empty, return immediately
            if (prefix.isEmpty()) return "";
        }

        return prefix;
    }
}
