package leetcodemainset;

import java.util.HashMap;

/**
 * @author YC (shell845)
 * @date 29/4/2020 2:01 PM
 */

public class _106_ConstructBinaryTreeInorderPostorderTraversal {
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

    int post_idx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // start from the last postorder element
        post_idx = postorder.length - 1;
        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder) idx_map.put(val, idx++);

        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int in_left, int in_right) {
        // if there is no elements to construct subtrees
        if (in_left > in_right)
            return null;

        // pick up post_idx element as a root
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // root splits inorder list into left and right subtrees
        int index = idx_map.get(root_val);

        // recursion
        post_idx--;
        // build right subtree
        root.right = helper(index + 1, in_right);
        // build left subtree
        root.left = helper(in_left, index - 1);
        return root;
    }

    /*public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        int size = inorder.length;
        TreeNode root = buildTree(inorder, 0, size - 1, postorder, 0, size - 1);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int iL, int iR, int[] postorder, int pL, int pR) {
        if (iL > iR || pL > pR) return null;
        // construct node
        TreeNode node = new TreeNode(postorder[pR]);
        // the node is a leaf node
        if (iL == iR) return node;
        // find spliting point in inorder array
        int iS = iL;
        while (iS <= iR) {
            if (inorder[iS] == postorder[pR]) break;
            iS++;
        }
        // find spliting point in postorder array
        int rightTreeLen = iR - iS;
        int pS = pR - rightTreeLen;
        // construct left child
        node.left = buildTree(inorder, iL, iS - 1, postorder, pL, pS - 1);
        // construct right child
        node.right = buildTree(inorder, iS + 1, iR, postorder, pS, pR - 1);

        return node;
    }*/
}
