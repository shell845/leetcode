package main.java.leetcodemainset;

/**
 * @author YC 04/09/2020
 */

public class _400_FindNthDigit {
    /** Complexity O(n), space O(1) */
    public int findNthDigit(int n) {
        int digit = 1;
        long base = 9;
        int start = 1;
        while (n > base * digit) {
            n -= base * digit;
            base *= 10;
            start *= 10;
            digit++;
        }

        start += (n - 1) / digit;
        String s = Integer.toString(start);
        return Character.getNumericValue(Integer.toString(start).charAt((n - 1) % digit));
    }

    public static void main(String[] args) {
        _400_FindNthDigit test = new _400_FindNthDigit();
        System.out.println(test.findNthDigit(1000000000));
    }
}
