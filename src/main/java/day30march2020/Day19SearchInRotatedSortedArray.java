package main.java.day30march2020;

/**
 * @author YC (shell845)
 * @date 20/4/2020 10:58 AM
 */

public class Day19SearchInRotatedSortedArray {
    /** time complexity O(logn) space O(1) */
    public int search_binarysearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        // binary search
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else r = mid - 1;
            }
        }

        return nums[l] == target? l : -1;
    }

    /** time complexity O(logn) space O(1) */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        // find the pivot point l
        int len = nums.length - 1;
        int l = 0, r = len;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r -= 1;
            }
        }
        int pivot = l;
        // define the target number is in the left part or right part
        if (pivot == 0) {
            l = 0;
            r = len;
        } else if (target > nums[0]) {
            l = 0;
            r = pivot - 1;
        } else if (target < nums[0]) {
            l = pivot;
            r = len;
        } else return 0;
        // find the target number
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else return mid;
        }
        return -1;
    }
}
