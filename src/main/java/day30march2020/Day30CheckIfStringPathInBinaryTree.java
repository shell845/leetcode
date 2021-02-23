package main.java.day30march2020;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YC (shell845)
 * @date 30/4/2020 11:58 PM
 */

public class Day30CheckIfStringPathInBinaryTree {
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

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null || arr[0] != root.val) return false;

        Map<Integer, TreeNode> backup = new HashMap<>();
        TreeNode node = root;
        int index = 1;
        while (index < arr.length) {
            TreeNode temp = null;
            if (node.left != null && node.left.val == arr[index]) temp = node.left;
            if (node.right != null && node.right.val == arr[index]) {
                if (temp == null) temp = node.right;
                else backup.put(index, node.right);
            }
            if (temp == null) {
                if (backup.isEmpty()) return false;
                for (int i = index; i > 0; i--) {
                    if (backup.containsKey(i)) {
                        temp = backup.get(i);
                        index = i + 1;
                        backup.remove(i);
                        break;
                    }
                }
                if (temp == null) return false;
                else node = temp;
            } else {
                node = temp;
                index++;
            }
        }
        return index == arr.length && node.left == null && node.right == null;
    }
}
