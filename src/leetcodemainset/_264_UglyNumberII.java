package leetcodemainset;

import java.util.ArrayList;

/**
 * @author YC 04/13/2020
 */

public class _264_UglyNumberII {
    /** time complexity O(n), space O(n) */
    public int nthUglyNumber_ref(int n) {
        if (n < 1) return -1;

        int[] ugly = new int[n];
        ugly[0] = 1;
        int m2 = 0, m3 = 0, m5 = 0;
        int f2 = 2, f3 = 3, f5 = 5;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(f2, f3), f5);
            if (ugly[i] == f2) f2 = 2 * ugly[++m2];
            if (ugly[i] == f3) f3 = 3 * ugly[++m3];
            if (ugly[i] == f5) f5 = 5 * ugly[++m5];
        }
        return ugly[n - 1];
    }

    /** time complexity O(n), space O(n) */
    public int nthUglyNumber(int n) {
        if (n < 1) return -1;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int m = 1; // current max ugly number
        int m2 = 0, m3 = 0, m5 = 0; // next ugly num is the min of these three
        int t2 = 0, t3 = 0, t5 = 0; // min i

        while (list.size() < n) {
            for (int i = t2; i < list.size(); i++) {
                if (list.get(i) * 2 > m) {
                    m2 = list.get(i) * 2;
                    break;
                }
                t2++;
            }
            for (int i = t3; i < list.size(); i++) {
                if (list.get(i) * 3 > m) {
                    m3 = list.get(i) * 3;
                    break;
                }
                t3++;
            }
            for (int i = t5; i < list.size(); i++) {
                if (list.get(i) * 5 > m) {
                    m5 = list.get(i) * 5;
                    break;
                }
                t5++;
            }
            m = Math.min(Math.min(m2, m3), m5);
            list.add(m);
            System.out.println(list.size() + " " + m);
        }

        System.out.println(list.get(n - 1));
        return list.get(n - 1);
    }

    public static void main(String[] args) {
        _264_UglyNumberII test = new _264_UglyNumberII();
        test.nthUglyNumber_ref(10);
    }
}
