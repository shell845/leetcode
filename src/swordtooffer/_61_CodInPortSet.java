package swordtooffer;

import java.util.Arrays;

/**
 * @author ych
 * @date 21/4/2020 11:39 AM
 */
public class _61_CodInPortSet {
    /** time complexity O(nlogn), space(1)
     * Note: nlogn is equivalent to constance when n is small */
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) return false;

        Arrays.sort(nums);
        int zeroCount = 0;
        for (int i = 0 ; i < nums.length - 1; i++) {
            if (nums[i] == 0) zeroCount++;
            else {
                int temp = nums[i + 1] - nums[i];
                if (temp == 0) return false;
                else if (temp > 1) {
                    zeroCount = zeroCount - temp + 1;
                    if (zeroCount < 0) return false;
                }
            }
        }
        return true;
    }
}
