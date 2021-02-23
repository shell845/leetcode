package main.java.leetcodemainset;

import java.util.Arrays;

/**
 * @author YC 03/10/2020
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) throw new IllegalArgumentException();
        Arrays.sort(nums);

        int size = nums.length;
        int sum = nums[size - 1] + nums[size - 2] + nums[size - 3];

        for (int i = 0; i < size; i++) {
            int j = i + 1;
            int k = size - 1;
            int tempSum;
            while (j < k) {
                tempSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(tempSum - target) < Math.abs(sum - target)) {
                    sum = tempSum;
                }
                if (sum - target == 0) return sum;
                if (tempSum - target > 0) {
                    k--;
                } else j++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        int result = t.threeSumClosest(new int[] {1, 2, 4, 8, 16, 32, 64, 128}, 82);
        System.out.println(( (int)Double.NEGATIVE_INFINITY));
    }
}
