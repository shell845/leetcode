package main.java.swordtooffer;

/**
 * @author YC 03/19/2020
 */

public class _06_CodInReversePrint {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    /** Solition 4 Recursion - Complexity O(n), space O(n) */

    /** Solition 3 Reverse LinkedList - Complexity O(n), space O(n) */

    /** Solition 2 Stack - Complexity O(n), space O(n) */

    /** Solution 1 Loop - Complexity O(n), space O(n) */
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        int[] ans = new int[count];
        node = head;
        int i = count - 1;
        while (node != null) {
            ans[i] = node.val;
            i--;
            node = node.next;
        }

        return ans;
    }
}
