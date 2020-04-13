/**
 * @author YC 04/09/2020
 */

package Day30;

import java.util.ArrayList;

public class Day8MiddleNode {
      public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    /** Complexity O(n), space O(1) */
    public ListNode middleNode_twopointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

   /** Complexity O(n), space O(n) */
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        return list.get(list.size() /2);
    }
}
