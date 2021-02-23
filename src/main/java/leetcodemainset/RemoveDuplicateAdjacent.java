package main.java.leetcodemainset;

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
        /* use array as stack */
        int i = 0;
        for (int j = 0; j < nums.length; ++i, ++j) {
            nums[i] = nums[j];
            if (i > 0 && nums[i] == nums[i - 1]) i -= 2;
        }
        return Arrays.copyOfRange(nums, 0, i);

        /*
        // use stringbuilder as stack for char
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (char c : S.toCharArray()) {
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1);
                len--;
            } else {
                sb.append(c);
                len++;
            }
        }
        return sb.toString();
         */

        /* use stack
        Deque<Integer> stack = new LinkedList<>();
        for (int n : nums) {
            if (!stack.isEmpty() && stack.peek() == n) {
                stack.pop();
            } else stack.push(n);
        }

        int n = stack.size();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            ans[i] = stack.pop();
        }
        return ans;
        */
    }

    public static void main(String args[]) {
        RemoveDuplicateAdjacent r = new RemoveDuplicateAdjacent();
        int[] ans = r.removeDuplicatedAdjacent(new int[]{1,1,0,2,2,0,3,0});
        for (int n : ans) {
            System.out.println(n);
        }
    }
}
