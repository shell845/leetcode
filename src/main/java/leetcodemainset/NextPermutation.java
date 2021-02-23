package main.java.leetcodemainset;

import java.util.Arrays;

/**
 * @author YC 03/10/2020
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        /** O(n) */
        System.out.println(Arrays.toString(nums));
        int last = nums.length - 1;
        int idx = last;
        while (idx > 0 && nums[idx - 1] >= nums[idx]) {
            idx--;
        }
        System.out.println(idx);
        if (idx == 0) {
            Arrays.sort(nums);
        } else if (idx == nums.length - 1) {
            swap(nums, idx, idx - 1);
        } else {
            sort(nums, idx);
        }
    }

    // 1,1,5,2,1 -> [1,2,1,1,5]
    private void sort(int[] nums, int idx) {
        int n = nums.length - 1;
        while (n >= idx) {
            if (nums[idx - 1] < nums[n]) break;
            n--;
        }
        System.out.println("n " + n);
        swap(nums, n, idx - 1);
        System.out.println(Arrays.toString(nums));
        sortRest(nums, idx);
    }

    private void sortRest(int[] nums, int s) {
        int j;
        for (int i = s; i < nums.length; i++) {
            j = i;
            while (nums[j] < nums[j - 1] && j > s) {
                swap(nums, j, j - 1);
                j--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = new int[] {2,3,1};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1
//        [1,2,3] - [1,3,2]
//        [1,1,5,2] - [1,2,1,5]
//        [1,1,5,2,1] - [1,2,1,1,5]
//        [1,1,5,6] - [1,1,6,5]
//        lexicographical order between two sequences is defined by
//        a1a2...ak <lex b1b2 ... bk if ai < bi for the first i where ai and bi differ
    }
}
