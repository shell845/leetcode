package leetcodemainset;

/**
 * @author YC 03/24/2020
 */

public class _50_PowerXN {
    /** Time Limit Exceeded */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long nn = n;
        if (nn < 0)  {
            nn = -nn;
            x = 1 / x;
        }
        double result = 1.0;
        while (nn > 0) {
            if ((nn & 1) == 1) result *= x;
            x *= x;
            nn >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        _50_PowerXN test = new _50_PowerXN();
        System.out.println(test.myPow(2, 10));
    }
}
