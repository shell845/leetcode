package main.java.swordtooffer;

/**
 * @author YC (shell845)
 * @date 22/4/2020 12:27 PM
 */

public class _66_ProductSum {
    /** two pointers, mirror iterate, dp
     * time complexity O(n), space O(1) */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[0];

        int len = a.length;
        int[] b = new int[len];

        b[len - 1] = a[len - 1];
        for (int i = len - 2; i > 0; i--) {
            b[i] = b[i + 1] * a[i];
        }

        int temp = 1;
        for (int i = 0; i < len - 1; i++) {
            b[i] = temp * b[i + 1];
            temp *= a[i];
        }
        b[len - 1] = temp;

        return b;
    }
}
