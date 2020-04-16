/**
 * @author YC (shell845)
 * @date 16/4/2020 12:29 PM
 */

public class _55_CodInDepthOfBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** check if balanced
     *  leetcode #110
     *  time complexity O(n), space O(1) (O(n) including recursion) */
    private boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        helper(root);
        return isBalanced;

        // return helper2(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            isBalanced = false;
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    // no need global variable isBalanced, check depth of root is -1 instead
    private int helper2(TreeNode node) {
        if (node == null) return 0;

        int left = helper(node.left);
        if (left == -1) return -1;
        int right = helper(node.right);
        if (right == -1) return -1;

        return Math.abs(left - right) > 1? -1 : Math.max(left, right) + 1;
    }

    /** find max depth
     * leetcode #104
     * time complexity O(n), space O(1) (O(n) including recursion) */
    public int maxDepth_I(TreeNode root) {
        return dfs_I(root);
    }

    private int dfs_I(TreeNode node) {
        if (node == null) return 0;
        int left = dfs_I(node.left);
        int right = dfs_I(node.right);
        return Math.max(left, right) + 1;
    }
}
