package day30march2020;

/**
 * @author YC (shell845)
 * @date 20/4/2020 4:12 PM
 */

public class Day20ConstructBSTFromPreorder {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

   /** time complexity O(n), space O(n) */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        buildTree(preorder, root, 1, preorder.length - 1);
        return root;
    }

    private void buildTree(int[] preorder, TreeNode node, int left, int right) {
        if (node == null || left > right || left < 0 || right > preorder.length - 1) return;

        node.left = preorder[left] < node.val? new TreeNode(preorder[left]) : null;
        int split = right + 1;
        for (int i = left; i <= right; i++) {
            if (preorder[i] >= node.val) {
                node.right = new TreeNode(preorder[i]);
                split = i;
                break;
            }
        }
        buildTree(preorder, node.left, left + 1, split - 1);
        buildTree(preorder, node.right, split + 1, right);
    }
}
