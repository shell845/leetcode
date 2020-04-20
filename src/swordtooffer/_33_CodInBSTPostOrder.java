package swordtooffer;

import java.util.Stack;

/**
 * @author YC 03/31/2020
 */

public class _33_CodInBSTPostOrder {
    /** Complexity O(N), space O(N) */
    public boolean verifyPostorder_stack(int[] postorder) {
        if (postorder == null) return false;

        Stack<Integer> stack = new Stack();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

    /** Complexity O(N^2), space O(N) */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) return false;

        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] tree, int left, int right) {
        if (left >= right) return true;

        int i = left;
        while (i < right) {
            if (tree[i] >= tree[right]) {
                for (int j = i + 1; j < right; j++) {
                    if (tree[j] < tree[right]) return false;
                }
                break;
            }
            i++;
        }
        return helper(tree, left, i - 1) && helper(tree, i, right - 1);
    }
}
