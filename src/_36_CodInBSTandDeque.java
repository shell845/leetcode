/**
 * @author YC 04/01/2020
 */

public class _36_CodInBSTandDeque {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    /** Complexity O(n), space O(1) */
    Node head = null, tail = null, prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inorderTraverse(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void inorderTraverse(Node node) {
        if (node == null) return;

        inorderTraverse(node.left);
        if (prev == null) {
            head = node;
        } else prev.right = node; // incorrect if set node.left = prev here, prev.left was set in last recursion while prev.right not set yet
        node.left = prev; // node.left must be prev, node.right is unknown yet (to be set as prev.right in next recursion)
        prev = node;
        tail = node;
        inorderTraverse(node.right);
    }
}
