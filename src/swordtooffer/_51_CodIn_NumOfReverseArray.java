package swordtooffer;

import java.util.Arrays;

/**
 * @author YC 04/14/2020
 */

public class _51_CodIn_NumOfReverseArray {

    /** Merge sort
     * time complexity O(nlogn), space(n) */
    private int count;

    public int reversePairs_mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
        return count;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums,mid + 1, r);
        merge(nums, l, r, mid);
    }

    private void merge(int[] nums, int l, int r, int mid) {
        if (l >= r) return;
        int[] temp = new int[r - l + 1];
        // System.out.println(l + " " + r + " " + mid + " " + temp.length);
        int markl = mid, markr = r;
        for (int i = temp.length - 1; i >= 0; i--) {
            if (markl >= l && markr > mid) {
                if (nums[markl] > nums[markr]) {
                    count += markr - mid;
                    temp[i] = nums[markl];
                    markl--;
                } else {
                    temp[i] = nums[markr];
                    markr--;
                }
            } else if (markl >= l) {
                temp[i] = nums[markl];
                markl--;
            } else {
                temp[i] = nums[markr];
                markr--;
            }
        }

        for (int value : temp) {
            nums[l] = value;
            l++;
        }
    }

    /** time complexity O(n^2), space O(1) */
    public int reversePairs_bruteForce(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _51_CodIn_NumOfReverseArray test = new _51_CodIn_NumOfReverseArray();
        // test.reversePairs(new int[] {7,5,6,4});
    }
}
