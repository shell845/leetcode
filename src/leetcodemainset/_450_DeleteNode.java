package leetcodemainset;

/**
 * @author YC 03/16/2020
 */

public class _450_DeleteNode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode450(TreeNode root, int key) {
        return delete(root, key);
    }

    private TreeNode delete(TreeNode node, int key) {
        if (node == null) return null;
        int cmp = node.val - key;
        if (cmp > 0) node.left = delete(node.left, key);
        else if (cmp < 0) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            TreeNode t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
}
