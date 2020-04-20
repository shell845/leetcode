package swordtooffer;

/**
 * @author YC 03/27/2020
 */

public class _21_CodInRearrangeArrayOddEven {
    /** Complexity O(n), space O(1) */
    public int[] exchange_2pointer(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while (i < j && (nums[j] & 1) == 0) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /** Naive solution
     * Complexity O(n) space O(n) */
    public int[] exchange_naive(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                result[right] = nums[i];
                right--;
            } else {
                result[left] = nums[i];
                left++;
            }
        }
        return result;
    }
}
