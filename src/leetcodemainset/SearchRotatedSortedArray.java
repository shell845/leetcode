package leetcodemainset;

/**
 * @author YC 03/10/2020
 */

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        // 3 4* 0 1 2
        if (nums.length == 0) return -1;

        int idx = 0;
        while (idx < nums.length - 1 && nums[idx] < nums[idx + 1]) {
            idx++;
        }
        if (target > nums[0]) {
            //1st half
            return find(nums, 0, idx, target);
        } else if (target < nums[0]) {
            //2nd half
            return find(nums, idx + 1, nums.length - 1, target);
        } else return 0;

    }

    private int find(int[] nums, int start, int end, int tar) {
        if (start > end || (start == end && nums[start] != tar)) return -1;

        int mid = (start + end) / 2;
        if (tar == nums[mid]) {
            return mid;
        } else if (tar > nums[mid]) {
            return find(nums, mid + 1, end, tar);
        } else return find(nums, start, mid, tar);
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray srs = new SearchRotatedSortedArray();
        int result = srs.search(new int[] {1}, 0);
        System.out.println(result);
    }
}
