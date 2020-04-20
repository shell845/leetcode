package swordtooffer;

/**
 * @author YC 03/27/2020
 */

public class _23_CodInEntryOfCircularLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode findCircularEntry(ListNode head) {
        ListNode pointer1 = head, pointer2 = head;
        // check if given linkedlist is a circular linkedlist
        while (pointer1 != null) {
            pointer2 = pointer2.next;
            if (pointer2 != null) {
                pointer1 = pointer1.next.next;
            } else return null;
            if (pointer1 == pointer2) {
                break;
            }
        }
        // find the number of circular nodes
        int circleNode = 1;
        pointer1 = pointer1.next;
        while (pointer1 != pointer2) {
            circleNode++;
            pointer1 = pointer2.next;
        }
        // find the entry node
        // n = circleNode, N = totalNode;
        // pointer1: walks n   --> walks n + (N - n + 1) = N + 1 back to entry node
        // pointer2: stay at 1 --> walks (N - n + 1) to reach entry node
        pointer1 = head;
        pointer2 = head;
        while (circleNode > 0) {
            pointer1 = pointer1.next;
            circleNode--;
        }
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }
}
