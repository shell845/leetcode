package swordtooffer;

/**
 * @author YC 03/26/2020
 */

public class _18_CodInDeleteLinkedListNode {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

   public ListNode deleteDuplicateNode(ListNode head) {
       ListNode node = head;
       ListNode preNode = null;
       while (node != null) {
           preNode = node;
           if (node.next != null) {
               node = node.next;
               while (preNode.val == node.val && node.next != null) {
                   node = node.next;
               }
               if (preNode.next != node) {
                   if (node.next == null) {
                       preNode.next = null;
                       break;
                   } else {
                       preNode.next = node;
                   }
               }
           }
       }
       return head;
   }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        ListNode preNode = null;
        while (node != null) {
            if (node.val == val) {
                // delete & return
                if (preNode == null) {
                    head = head.next;
                } else {
                    preNode.next = node.next;
                }
                break;
            }
            preNode = node;
            node = node.next;
        }
        return head;
    }
}
