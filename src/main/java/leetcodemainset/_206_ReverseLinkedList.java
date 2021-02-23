package main.java.leetcodemainset;

/**
 * @author YC 03/28/2020
 */

public class _206_ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = null;
        return prev;
    }

    public ListNode reverseList_recursive2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList_recursive2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = null;
        return reverse(temp, head);
    }

    private ListNode reverse(ListNode node, ListNode preNode) {
        ListNode temp = node.next;
        node.next = preNode;
        if (temp != null) {
            return reverse(temp, node);
        } else return node;
    }
}
