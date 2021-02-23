package main.java.leetcodemainset;

/**
 * @author YC (shell845)
 * @date 16/4/2020 12:05 PM
 */

public class _54_KthLargestInBST {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

   /** Time complexity O(n), space O(1)
    * 题目指出：1 \leq k \leq N1≤k≤N （二叉搜索树节点个数）；因此无需考虑 k > Nk>N 的情况。
    * 若考虑，可以在中序遍历完成后判断 k > 0k>0 是否成立，若成立则说明 k > Nk>N
    */
    private int count;
    private int result;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        result = -1;
        inorderFromRight(root);
        return result;
    }

    private void inorderFromRight(TreeNode node) {
        if (node == null) return;
        inorderFromRight(node.right);
        count--;
        if (count > 0) {
            inorderFromRight(node.left);
        } else if (count == 0) {
            result = node.val;
        }
    }
}
