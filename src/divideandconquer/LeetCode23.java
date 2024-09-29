package divideandconquer;

import java.util.Arrays;
import java.util.Random;

public class LeetCode23 {
//    public static void main(String[] args) {
//        // Create an array to hold 5 sorted linked lists
//        ListNode[] linkedLists = new ListNode[5];
//
//        // Generate 5 sorted linked lists with random values
//        Random random = new Random(5);
//        for (int i = 0; i < linkedLists.length; i++) {
//            linkedLists[i] = generateSortedList(random.nextInt(10) + 10); // Each list will have a length between 10 and 19
//        }
//
//        // Print the linked lists to verify
//        for (int i = 0; i < linkedLists.length; i++) {
//            System.out.print("List " + (i + 1) + ": ");
//            printList(linkedLists[i]);
//        }
//        System.out.print("Merged List :");
//        printList(mergeKLists(linkedLists));
//    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        for (ListNode listNode1 : lists) {
            listNode = mergetwoLists(listNode, listNode1);
        }
        return listNode;
    }

    public static ListNode mergetwoLists(ListNode listsOne, ListNode listsTwo) {
        ListNode merged = new ListNode(0);
        ListNode current = merged;

        while (listsOne != null && listsTwo != null) {
            if (listsOne.val < listsTwo.val) {
                current.next = listsOne;
                listsOne = listsOne.next;
            } else {
                current.next = listsTwo;
                listsTwo = listsTwo.next;
            }
            current = current.next;
        }
        if (listsOne == null) {
            current.next = listsTwo;
        } else {
            current.next = listsOne;
        }
        return merged.next;
    }

    // Helper method to generate a sorted linked list of a given length with random values
    public static ListNode generateSortedList(int length) {
        Random random = new Random(6);
        int[] values = new int[length];

        // Generate random values
        for (int i = 0; i < length; i++) {
            values[i] = random.nextInt(100); // Random value between 0 and 99
        }

        // Sort the array of random values
        Arrays.sort(values);

        // Create the sorted linked list
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
