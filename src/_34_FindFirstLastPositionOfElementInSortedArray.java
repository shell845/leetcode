/**
 * @author YC (shell845)
 * @date 15/4/2020 1:13 PM
 */

public class _34_FindFirstLastPositionOfElementInSortedArray {
    /** time complexity O(logn), space O(1) */
    public int[] searchRange_iteration(int[] nums, int target) {
        int[] ans = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return ans; // attention: corner case
        int l = 0, r = nums.length - 1, mid = 0;
        // last
        while(l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] <= target) l = mid + 1;
            else r = mid - 1;
        }
        ans[1] = (r >= 0 && r < nums.length && nums[r] == target)? r : -1; // attention: corner case
        // first
        l = 0;
        r = nums.length - 1;
        while(l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        ans[0] = (l >= 0 && l < nums.length && nums[l] == target)? l : -1; // attention: corner case

        return ans;
    }

    /** time complexity O(logn), space O(1) */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target, 0, nums.length - 1);
        ans[1] = findLast(nums, target, 0, nums.length - 1);
        return ans;
    }

    private int findFirst(int[] nums, int target, int l, int r) {
        if (nums == null || l > r) return -1;

        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            } else {
                return findFirst(nums, target, l, mid - 1);
            }
        } else if (nums[mid] < target) {
            return findFirst(nums, target, mid + 1, r);
        } else {
            return findFirst(nums, target, l, mid - 1);
        }
    }

    private int findLast(int[] nums, int target, int l, int r) {
        if (nums == null || l > r) return -1;

        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            if (mid == nums.length - 1 || nums[mid + 1] != target) {
                return mid;
            } else {
                return findLast(nums, target, mid + 1, r);
            }
        } else if (nums[mid] < target) {
            return findLast(nums, target, mid + 1, r);
        } else {
            return findLast(nums, target, l, mid - 1);
        }
    }

}
