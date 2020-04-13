import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YC 03/30/2020
 */

public class _32_CodInPrintTreeByLayer {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** Complexity O(N), space O(N) */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            ans.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        int[] ansarray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansarray[i] = ans.get(i);
        }

        return ansarray;
    }
}
