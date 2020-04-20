package leetcodemainset;

import java.util.Stack;

/**
 * @author YC (shell845)
 * @date 15/4/2020 11:56 AM
 */
public class _160_IntersectionOfTwoLinkedLists {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }

    /** time complexity O(m+n), space O(1)
     *  pay attention to the exit criteria when 2 links has no intersect */
    public ListNode getIntersectionNode_short(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : headB;
            nodeB = nodeB != null ? nodeB.next : headA;
        }
        return nodeA;
    }

    /** time complexity O(m+n), space O(1) */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int alen = 0, blen = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            alen++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            blen++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        if (alen > blen) {
            int diff = alen - blen;
            while (diff > 0) {
                nodeA = nodeA.next;
                diff--;
            }
        } else {
            int diff = blen - alen;
            while (diff > 0) {
                nodeB = nodeB.next;
                diff--;
            }
        }

        while(nodeA != null) {
            if (nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return null;
    }

   /** time complexity O(m+n), space O(m+n) */
    public ListNode getIntersectionNode_stack(ListNode headA, ListNode headB) {
        Stack<ListNode> a = new Stack();
        Stack<ListNode> b = new Stack();
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            a.push(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            b.push(nodeB);
            nodeB = nodeB.next;
        }
        ListNode intersect = null;
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.peek() == b.peek()) {
                intersect = a.pop();
                b.pop();
            } else return intersect;
        }
        return intersect;
    }
}
