package main.java.leetcodemainset;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YC 03/29/2020
 */

public class _101_SymmetricTree__ {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** Complexity O(N), space O(N) */
    public boolean isSymmetric_iteration(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode a = queue.remove();
            TreeNode b = queue.remove();
            if (a == null && b == null) {
                continue;
            } else if (a == null || b == null) {
                return false;
            } else if (a.val != b.val) return false;
            queue.add(a.left);
            queue.add(b.right);
            queue.add(a.right);
            queue.add(b.left);
        }
        return true;
    }

    /** Complexity O(N), space O(N) */
    public boolean isSymmetric_recursive(TreeNode root) {
        return match(root, root);
    }

    private boolean match(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return (a.val == b.val) && match(a.left, b.right) && match(a.right, b.left);
    }
}
