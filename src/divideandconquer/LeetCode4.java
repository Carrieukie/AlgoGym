package divideandconquer;

public class LeetCode4 {
//    public static void main(String[] args) {
//        System.out.println(
//                findMedianSortedArrays(
//                        new int[]{1, 3,},
//                        new int[]{2}
//                )
//        );
//    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = 0, right = 0, steps = 0, lastMoved = 0;
        int middle = (nums1.length + nums2.length) / 2;

        while (steps != middle) {
            if (nums1[left] > nums2[right]) {
                left++;
                lastMoved = 0;
            } else {
                right++;
                lastMoved = 1;
            }
            steps++;
        }
        int ans;
        if (lastMoved == 1) {
            ans = nums2[right];
        } else {
            ans = nums2[left];
        }
        return ans;
    }
}
