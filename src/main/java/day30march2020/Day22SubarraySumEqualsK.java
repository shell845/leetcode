package main.java.day30march2020;

/**
 * @author ych
 * @date 23/4/2020 11:26 AM
 */
public class Day22SubarraySumEqualsK {
    /** time complexity O(n^2), space O(1) */
    public int subarraySum_bruteForce(int[] nums, int k) {
        if  (nums == null || nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) count++;
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
}
