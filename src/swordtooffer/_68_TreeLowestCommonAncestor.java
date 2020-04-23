package swordtooffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ych
 * @date 23/4/2020 12:11 PM
 */
public class _68_TreeLowestCommonAncestor {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    /** Binary Tree
     * time complexity O(N), space O(N) */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);

        if(leftNode == null) return rightNode;
        if(rightNode == null) return leftNode;

        return root;
    }

    /** Binary Tree
     * Use deque
     * time complexity O(N), space O(N) */
    boolean find = false;
    public TreeNode lowestCommonAncestor_tree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        Deque<TreeNode> dequep = new ArrayDeque<>();
        Deque<TreeNode> dequeq = new ArrayDeque<>();
        dfs(root, p, dequep);
        find = false;
        dfs(root, q, dequeq);

        TreeNode node = null;
        while (!dequep.isEmpty() && !dequeq.isEmpty()) {
            if (dequep.getFirst() == dequeq.removeFirst()) {
                node = dequep.removeFirst();
            } else break;
        }

        return node;
    }

    private void dfs(TreeNode node, TreeNode target, Deque<TreeNode> deque) {
        if (node == null) return;
        deque.add(node);
        if (node == target) { // find
            find = true;
            return;
        } else {
            dfs(node.left, target, deque);  // search left
            if (find) return;
            dfs(node.right, target, deque); // search right
            if (find) return;
        }
        deque.removeLast();
    }

    /** Binary SEARCH Tree
     * time complexity O(N), space O(1) */
    public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        TreeNode node = root;
        // p <= q
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        // find node
        while (node != null) {
            if (node.val >= p.val && node.val <= q.val) return node;
            if (node.val >= q.val) {
                node = node.left;
            } else node = node.right;
        }
        return null;
    }
}
