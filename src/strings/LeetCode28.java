package strings;

public class LeetCode28 {
//    public static void main(String[] args) {
//        System.out.println(strStr("adbutsad", "sad"));
//    }

    public static int strStr(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String subsNeedle = haystack.substring(i, i + needle.length());
            if (needle.equals(subsNeedle)){
                return i;
            }
        }

        return -1;
    }
}
