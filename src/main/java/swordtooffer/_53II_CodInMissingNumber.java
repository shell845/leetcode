package main.java.swordtooffer;

/**
 * @author YC (shell845)
 * @date 16/4/2020 11:27 AM
 */

public class _53II_CodInMissingNumber {
    /**Attention:
     * array length is n - 1, numbers are [0, n - 1]
     * so in [0, 1, 2],
     * length = 3,
     * n = 4,
     * numbers are [0, 3],
     * the missing number is 3 */
    public int missingNumber(int[] nums) {
        if (nums == null) return -1;

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == mid) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
