package main.java.leetcodemainset;

/**
 * @author YC 03/06/2020
 */

public class FindMedianSortedArrays {
    private int[] a;
    private int[] b;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            a = nums2;
            b = nums1;
        } else {
            a = nums1;
            b = nums2;
        }

        int m = a.length;
        int n = b.length;

        int lo = 0;
        int hi = m;
        int base = (m + n + 1) / 2;

        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int j = base - i;

            if (i > 0 && a[i - 1] > b[j]) {
                // i too big
                hi = i - 1;
            } else if (i < m && b[j - 1] > a[i]) {
                // i too small
                lo = i + 1;
            } else {
                // find i
                int midl = 0;
                if (i == 0) {
                    midl = b[j - 1];
                } else if (j == 0) {
                    midl = a[i - 1];
                } else {
                    midl = Math.max(a[i - 1], b[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return midl;
                } else {
                    int midr = 0;
                    if (i == m) {
                        midr = b[j];
                    } else if (j == n) {
                        midr = a[i];
                    } else {
                        midr = Math.min(b[j], a[i]);
                    }

                    return (midl + midr) / 2.0;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] n1 = {2, 4};
        int[] n2 = {1, 3, 5};
        FindMedianSortedArrays test = new FindMedianSortedArrays();
        double r = test.findMedianSortedArrays(n1, n2);
        System.out.println(r);
    }
}
