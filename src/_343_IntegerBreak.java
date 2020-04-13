/**
 * @author YC 03/23/2020
 */

public class _343_IntegerBreak {
    /** 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1 */
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }


    /** Lazy */
    /** Complexity O(1) Space O(1) */
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;

        int cut3 = n / 3;
        if (n - cut3 * 3 == 1) cut3 -= 1;

        int cut2 = (n - cut3 * 3) / 2;

        return (int) (Math.pow(3, cut3) * Math.pow(2, cut2));
    }

    /** Dynamic Programming */
    /** Complexity O(n) Space O(n) */
    public int integerBreak_dp(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;

        int[] product = new int[n + 1];
        // attention to below special value setup
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int p = product[j] * product[i - j];
                max = Math.max(max, p);
            }
            product[i] = max;
        }
        return product[n];
    }
}
