package main.java.leetcodemainset;

/**
 * @author YC 04/05/2020
 */

public class _169_MajorityElement {

    /** Complexity O(n), space O(1) */
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count++;
                continue;
            }
            if (nums[i] == num) {
                count++;
            } else count --;
        }
        return num;
    }

    /** Partition */
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement_partition(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    /** Bitwise O(n) */
    static void findMajority(int arr[], int n)
    {
        // Number of bits in the integer
        int len = 32;

        // Variable to calculate majority element
        int number = 0;

        // Loop to iterate through all the bits of number
        for (int i = 0; i < len; i++)
        {
            int count = 0;
            // Loop to iterate through all elements in array
            // to count the total set bit
            // at position i from right
            for (int j = 0; j < n; j++)
            {
                if ((arr[j] & (1 << i)) != 0)
                    count++;
            }

            // If the total set bits exceeds n/2,
            // this bit should be present in majority Element.
            if (count > (n / 2))
                number += (1 << i);
        }

        int count = 0;

        // iterate through array get
        // the count of candidate majority element
        for (int i = 0; i < n; i++)
            if (arr[i] == number)
                count++;

        // Verify if the count exceeds n/2
        if (count > (n / 2))
            System.out.println(number);
        else
            System.out.println("Majority Element Not Present");
    }
}
