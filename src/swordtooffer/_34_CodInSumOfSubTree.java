package swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author YC 03/31/2020
 */

public class _34_CodInSumOfSubTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** Complexity O(N), space O(N) */
    LinkedList<List<Integer>> path = new LinkedList<>();
    LinkedList<Integer> subPath = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return path;
    }

    private void helper(TreeNode node, int sum) {
        if (node == null) return;
        subPath.add(node.val);
        sum = sum - node.val;
        if (sum == 0 && node.left == null && node.right == null) {
            path.add(new LinkedList(subPath));
        }
        helper(node.left, sum);
        helper(node.right, sum);
        subPath.removeLast();
    }

    /** Attention: negative number & negative sum*/
    public List<List<Integer>> pathSum_origin(TreeNode root, int sum) {
        List<List<Integer>> path = new ArrayList<>();
        helper(root, sum, path, new ArrayList<Integer>());
        return path;
    }

    private void helper(TreeNode node, int sum, List path, List<Integer> subPath) {
        if (node == null) return;

        sum = sum - node.val;
        subPath.add(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            path.add(new ArrayList(subPath));
            subPath.remove(subPath.size() - 1);
            return;
        }
        if (node.left != null) helper(node.left, sum, path, subPath);
        if (node.right != null) helper(node.right, sum, path, subPath);
        subPath.remove(subPath.size() - 1);
    }
}
