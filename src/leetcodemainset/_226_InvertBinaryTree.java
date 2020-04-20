package leetcodemainset;

/**
 * @author YC 03/29/2020
 */

public class _226_InvertBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** Another solution: use queue & while loop, but need extra space */

    /** Mirror of the tree */
    /** Complexity O(N), space O(N) */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
