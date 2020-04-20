package swordtooffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YC 03/16/2020
 */

public class _03_CodInFindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        /** Complexity O(n), Space O(1) */
        if (nums.length < 2) return -1;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] >= nums.length) return -1;
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) return nums[i];
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;

        /** Complexity O(n), Space O(n)*/
        /* if (nums.length < 2) return -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i:nums) {
            if (set.contains(i)) return i;
            set.add(i);
        }
        return -1; */
    }
}
