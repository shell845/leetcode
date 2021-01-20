package leetcodemainset;

import java.util.*;

/**
 * @author YC (shell845)
 * @date 19/1/2021 9:25 PM
 */

public class RemoveDuplicateAdjacent {
    /* remove adjacent duplicates in array
    [1,2,2,1,3,4,3,5,5] ---> [3,4,3]
    */

    public int[] removeDuplicatedAdjacent(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        boolean duplicate = false;
        for (int n : nums) {
            if (!stack.isEmpty() && stack.peekLast() == n) {
                duplicate = true;
            } else if (duplicate) {
                stack.pop();
                duplicate = false;
            } else stack.push(n);
        }

        int n = stack.size();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String args[]) {
        RemoveDuplicateAdjacent r = new RemoveDuplicateAdjacent();
        int[] ans = r.removeDuplicatedAdjacent(new int[]{1,1,0,2,2,0,3,0});
        for (int n : ans) {
            System.out.println(n);
        }
    }
}
