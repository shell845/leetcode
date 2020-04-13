/**
 * @author YC 04/02/2020
 */

package Day30;

import java.util.Arrays;

public class Day1SingleNumber {

    /** Complexity O(n), space O(1) */
    public int singleNumber_XOR(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    /** Complexity O(nlogn), space O(n) */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums); // O(nlogn) for sorting
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i+= 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] n = {2, 2, 1};
        Day1SingleNumber test = new Day1SingleNumber();
        System.out.println(test.singleNumber(n));
    }
}
