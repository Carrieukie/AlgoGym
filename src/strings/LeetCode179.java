package strings;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode179 {
//    public static void main(String[] args) {
//        System.out.println("a".compareTo("b"));
//    }

    public static String largestNumber(int[] nums) {
        Queue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();

        for (int num : nums) {
            pq.add(Integer.toString(num));  // Add numbers as strings
        }

        if(pq.peek().equals("0")) { // if array elements are all 0, instead of returning the largest answer as "00" we return just "0"
            return "0";
        }

        while (!pq.isEmpty()) {
            sb.append(pq.remove());
        }

        return sb.toString();
    }
}
