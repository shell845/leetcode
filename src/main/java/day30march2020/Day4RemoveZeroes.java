/**
 * @author YC 05/04/2020
 */

package main.java.day30march2020;

public class Day4RemoveZeroes {
    /** Complexity O(n), space O(1) */
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }
        for (int i = p; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /** Complexity O(n^2), space O(1) */
    public void moveZeroes_bruteforce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                    if (j == nums.length - 1) return;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
