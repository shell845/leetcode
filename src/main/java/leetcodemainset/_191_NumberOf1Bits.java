package main.java.leetcodemainset;

/**
 * @author YC 03/24/2020
 */

// you need to treat n as an unsigned value
public class _191_NumberOf1Bits {

    /** Complexity O(logn) Space O(1) */
    public int hammingWeight_3(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) count++;
            flag = flag << 1;
        }
        return count;
    }

    /** Complexity O(logn) Space O(1) */
    public int hammingWeight_2(int n) {
        int count = 0;
        while (n != 0) {
            count = count + n & 1;
            n = n >>> 1;
        }
        return count;
    }

    /** Bitwise operation
     * n = 1100
     * n - 1 = 1011
     * n & (n - 1) = 1000 --> equivalent to remove the right most 1 from original n */
    /** Complexity O(M) Space O(1) */
    public int hammingWeight_1(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
