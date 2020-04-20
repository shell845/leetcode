package leetcodemainset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YC 03/16/2020
 */

public class _94_InorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> InorderTraversal94(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dig(root, list);
        return list;
    }

    private void dig(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dig(node.left, list);
        list.add(node.val);
        dig(node.right, list);
    }
}
