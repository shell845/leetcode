package swordtooffer; /**
 * @author YC 03/19/2020
 */

/** Same as main problem set #105 */
public class _07_CodInBuildTree {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

   /** Complexity O(n), space O(n) */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij) {
        if (pi < 0 || pj > preorder.length - 1 || ii < 0 || ij > inorder.length - 1 ||
                pi > pj || ii > ij) return null;

        TreeNode root = new TreeNode(preorder[pi]);

        int rootIdx = -1;
        for (int i = ii; i <= ij; i++) {
            if (inorder[i] == preorder[pi]) {
                rootIdx = i;
                break;
            }
        }

        if (rootIdx == -1) return null;
        root.left = buildTreeHelper(preorder, pi + 1, pi + (rootIdx - ii), inorder, ii, rootIdx - 1);
        root.right = buildTreeHelper(preorder, pi + (rootIdx - ii) + 1, pj, inorder, rootIdx + 1, ij);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[] {1, 2, 3};
        int[] in = new int[] {3, 2, 1};
        _07_CodInBuildTree test = new _07_CodInBuildTree();
        TreeNode root = test.buildTree(pre, in);
        System.out.println(root.val + " "+ root.left.val + " " + root.left.left.val);
    }
}
