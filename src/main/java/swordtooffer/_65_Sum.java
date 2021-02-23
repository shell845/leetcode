package main.java.swordtooffer;

/**
 * @author YC (shell845)
 * @date 22/4/2020 12:12 PM
 */

public class _65_Sum {
    /** bitwise
     * time complexity O(logn) space O(1) */
    public int add(int a, int b) {
        int sum = 0, carry = 0;
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
