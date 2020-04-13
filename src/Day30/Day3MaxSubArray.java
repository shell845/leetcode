/**
 * @author YC 04/04/2020
 */

package Day30;

public class Day3MaxSubArray {
    /** Complexity O(n), space O(1) */
    public int maxSubArray_DP(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] < 0? nums[i] : nums[i] + dp[i - 1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /** Complexity O(n), space O(1) */
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) return Integer.MIN_VALUE;
        int max = nums[0], local = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = local < 0 ? nums[i] : local + nums[i];
            max = Math.max(max, local);
        }
        return max;
    }

    /** Complexity O(n^2), space O(1) */
    public int maxSubArray_BruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int localMax = nums[i];
            max = Math.max(max, localMax);
            for (int j = i + 1; j < nums.length; j++) {
                localMax = localMax + nums[j];
                max = Math.max(max, localMax);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Day3MaxSubArray test = new Day3MaxSubArray();
        test.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        int[] i = new int[0];
        System.out.println(i.length);
    }
}
