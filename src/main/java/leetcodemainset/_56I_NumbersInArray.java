package main.java.leetcodemainset;

/**
 * @author YC (shell845)
 * @date 16/4/2020 1:23 PM
 */

public class _56I_NumbersInArray {
    /** leetcode #136, #137, #260 */

    /** I: 1 numbers appear once while other numbers appear 3 times in array
     * time complexity O(n), space O(1) */
    public int singleNumber_II(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int mask = 1;
            for (int j = 31; j >= 0; j--) {
                if ((nums[i] & mask) != 0) {
                    bitSum[j]++;
                }
                mask <<= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

    public int singleNumber_II_shorter(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            int mask = 1 << i;
            for (int j:nums) {
                if ((mask & j) != 0) count++;
            }
            if ((count % 3) != 0) result |= mask;
        }
        return result;
    }

    /** I: 2 numbers appear once while other numbers appear twice in array
     * time complexity O(n), space O(1) */
    public int[] singleNumbers_I(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }

        /** a num & -num the result is right most position of 1 in num
         * -num = 2's complement of num = ~num + 1*/
        int temp = sum & (-sum);
        /*int temp = 1;
        while (true) {
            if ((sum & temp) == temp) break;
            temp <<= 1;
        }*/
        int num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & temp) == temp) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        return new int[] {num1, num2};
    }
}
