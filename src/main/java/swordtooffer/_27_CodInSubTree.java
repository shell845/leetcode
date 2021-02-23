package main.java.swordtooffer;

/**
 * @author YC 03/29/2020
 */

public class _27_CodInSubTree {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  /** Complexity O(MN), space O(M) for recursion calls */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;

        return match(A, B) || isSubStructure (A.left, B) || isSubStructure(A.right, B);
    }

    private boolean match(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;

        if (a.val == b.val) {
            return match(a.left, b.left) && match(a.right, b.right);
        } else {
            return false;
        }
    }
}
