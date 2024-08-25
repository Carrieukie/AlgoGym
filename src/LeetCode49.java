import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode49 {
//    public static void main(String[] args) {
//        groupAnagrams(new String[]{
//                "eat","tea","tan","ate","nat","bat"
//        }).forEach(System.out::println);
//    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashMap = new HashMap<>();

        for (String word: strs){
            char[] charArray  = word.toCharArray();
            Arrays.sort(charArray);
            if (!hashMap.containsKey(Arrays.toString(charArray))){
                hashMap.put(Arrays.toString(charArray), new ArrayList<>());
            }
            hashMap.get(Arrays.toString(charArray)).add(word);
        }

        return hashMap.values().stream().toList();
    }
}
