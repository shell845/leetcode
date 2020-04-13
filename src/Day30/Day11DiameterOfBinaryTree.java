/**
 * @author YC 04/12/2020
 */

package Day30;

public class Day11DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** Post-order traverse + DFS
     * time complexity O(n), space O(1) */
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        postOrder(root);
        return diameter;
    }

    private int postOrder(TreeNode node) {
        if (node == null) return 0;

        int left = postOrder(node.left);;
        int right = postOrder(node.right);;
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
