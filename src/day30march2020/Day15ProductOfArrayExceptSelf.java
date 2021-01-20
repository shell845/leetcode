package day30march2020;

/**
 * @author YC (shell845)
 * @date 16/4/2020 11:10 AM
 */

public class Day15ProductOfArrayExceptSelf {
    /** time complexity O(n), space O(n)
     * Consideration:
     *   - cannot user division since array numbers may be 0
     *   - relate to 2 pointer questions: iterate once from right most & once from left most */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return null;

        int[] ans = new int[nums.length];
        int[] temp = new int[nums.length];

        int postfix = 1;
        for (int i = temp.length - 1; i > 0; i--) {
            postfix *= nums[i];
            temp[i] = postfix;
        }

        int prefix = 1;
        for (int i = 0; i < ans.length - 1; i++) {
            ans[i] = prefix * temp[i + 1];
            prefix *= nums[i];
        }
        ans[ans.length - 1] = prefix;

        return ans;
    }
}
