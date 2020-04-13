import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author YC 03/22/2020
 */

public class _154_FindMinInRotatedSortedArrayII {
    /** Complexity O(logN), space O(1) */
    /** Good for long array*/
    public int minArray(int[] nums) {
        if (nums == null) return -1;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] <= nums[j]) {
                j = j - 1;
            } else if (nums[mid] > nums[j]) {
                i = mid + 1;
            }
        }
        if (i == j) return nums[i];
        return -1;
    }

    /** Complexity O(n), space O(1) */
    /** Good for short array*/
    public int findMin(int[] nums) {
        if (nums == null) return -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }
}
