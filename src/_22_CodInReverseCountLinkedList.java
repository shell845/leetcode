import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author YC 03/27/2020
 */

public class _22_CodInReverseCountLinkedList {
       public class ListNode {
           int val;
           ListNode next;

           ListNode(int x) {
               val = x;
           }
       }

        /** Complexity O(n), space O(1) */
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (k <= 0) return head;

            ListNode pointer = head;
            while (k > 0 & pointer != null) {
                pointer = pointer.next;
                k--;
            }
            ListNode node = head;
            while (pointer != null) {
                node = node.next;
                pointer = pointer.next;
            }
            return node;
        }

        /** Complexity O(n), space O(n) */
        public ListNode getKthFromEnd_stack(ListNode head, int k) {
            ArrayDeque<ListNode> stack = new ArrayDeque();
            ListNode node = head;
            while (node != null) {
                stack.push(node);
                node = node.next;
            }
            while (!stack.isEmpty() && k > 1) {
                stack.pop();
                k--;
            }
            return stack.isEmpty() ? head:stack.peek();
        }
}
