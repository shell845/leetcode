/**
 * @author YC 03/28/2020
 */

public class _21_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists_loop(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode pointer = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = l1 == null? l2:l1;
        return node.next;
    }

    /** Complexity O(M + N), space O(1) */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
    }
}
