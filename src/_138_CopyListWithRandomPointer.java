import java.util.HashMap;

/**
 * @author YC 04/01/2020
 */

public class _138_CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /** Complexity O(n), space O(1) */
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // copy next
        Node node = head;
        Node temp = null;
        while (node != null) {
            temp = node.next;
            node.next = new Node(node.val);
            node.next.next = temp;
            node = temp;
        }
        // copy random
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        // split copy nodes
        Node copy = head.next;
        Node copyNode = copy;

        node = head;
        node.next = null;

        temp = copy.next;
        int pos = 2;
        while (temp != null) {
            if ((pos & 1) == 1) {
                copyNode.next = temp;
                copyNode = copyNode.next;
            } else {
                node.next = temp;
                node = node.next;
            }
            temp = temp.next;
            pos++;
        }
        node.next = null;
        copyNode.next = null;
        return copy;
    }

    /** Complexity O(n), space O(n) */
    public Node copyRandomList_hashMap(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    /** Complexity O(n), space O(n) */
    public Node copyRandomList_naiveHashMap(Node head) {
        if (head == null) return null;

        HashMap<Node, Integer> map = new HashMap<>();
        HashMap<Integer, Node> mapCopy = new HashMap<>();
        Node node = head;
        Node copy = new Node(head.val);
        Node copyNode = copy;

        map.put(node, 0);
        mapCopy.put(0, copy);
        int pos = 0;
        while (node.next != null) {
            copyNode.next = new Node(node.next.val);
            copyNode = copyNode.next;
            node = node.next;
            map.put(node, ++pos);
            mapCopy.put(pos, copyNode);
        }
        copyNode.next = null; // end fo list

        copyNode = copy; // restart from head to copy random
        node = head;
        while (copyNode != null) {
            if (node.random != null) {
                copyNode.random = mapCopy.get(map.get(node.random));
            } else copyNode.random = null;
            copyNode = copyNode.next;
            node = node.next;
        }
        return copy;
    }
}
