package strings;

public class Leetcode151 {
    public static void main(String[] args) {
        System.out.println(reverseWords(""));
    }
    public static String reverseWords(String s) {
        String[] str=s.split("\\s+");
        int n=str.length;
        String[] arr=new String[n];
        int index=0;
        for(int i=n-1;i>=0;i--){
            arr[index++]=str[i];

        }
        return String.join(" ", arr).trim();
    }
}
