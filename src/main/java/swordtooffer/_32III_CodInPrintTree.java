package main.java.swordtooffer;

import java.util.*;

/**
 * @author YC 03/30/2020
 */

public class _32III_CodInPrintTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** Other solutions:
     * - double ended queue
     * - Collections.reverse(List)
     * - use 2 stacks */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean rightFirst = false;
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int n = queue.size();
            Stack<Integer> stack = new Stack();
            while (n > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (rightFirst) {
                    stack.push(node.val);
                } else layer.add(node.val);
                n--;
            }
            if (rightFirst) {
                while (!stack.isEmpty()) {
                    layer.add(stack.pop());
                }
            }
            rightFirst = !rightFirst;
            ans.add(layer);
        }

        return ans;
    }
}
