package day30march2020;

/**
 * @author YC (shell845)
 * @date 29/4/2020 10:35 PM
 */

public class Day29BinaryTreeMaxPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /** time O(N), space O(logN) for recursion */
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(postOrder(node.left), 0);
        int right = Math.max(postOrder(node.right), 0);
        // node.val + left, node.val + right, node.val + left + right, node.val
        int temp1 = node.val + left + right;
        int temp2 = node.val + Math.max(left, right);
        max = Math.max(max, Math.max(temp1, temp2));
        return temp2;
    }
}
