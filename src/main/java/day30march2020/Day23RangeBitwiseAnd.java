package main.java.day30march2020;

/**
 * @author ych
 * @date 24/4/2020 12:14 PM
 */
public class Day23RangeBitwiseAnd {
    public int rangeBitwiseAnd_startFromEnd(int m, int n) {
        while(n > m)
            n = n & n - 1;
        return m & n;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int i = 0; // how many bits are 0 on the right in result
        while(m != n){
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }

    public int rangeBitwiseAnd_fast(int m, int n) {
        int p = m ^ n;
        p |= p >> 1;
        p |= p >> 2;
        p |= p >> 4;
        p |= p >> 8;
        p |= p >> 16;
        return ~p & n;
    }

    public int rangeBitwiseAnd_buildInFunction(int m, int n) {
        return m == n ? m : m & ~(Integer.highestOneBit(m ^ n) - 1);
    }

    public int rangeBitwiseAnd_regular(int m, int n) {
        if (m == 0 || m == n) return m;

        int result = 0;
        while (m > 0 && n > 0) {
            int msbm = msb(m);
            int msbn = msb(n);
            if (msbm != msbn) break;
            int val = (1 << msbm);
            result += val;
            m -= val;
            n -= val;
        }
        return result;
    }

    // find most significant bit
    private int msb(int num) {
        int msb = -1;
        while (num > 0) {
            num = num >> 1;
            msb++;
        }

        return msb;
    }

    public int rangeBitwiseAnd_burteForce(int m, int n) {
        if (m == 0 || m == n) return m;
        int result = m;
        for (int i = m + 1; i <= n; i++) {
            result = result & i;
        }
        return result;
    }

    public static void main(String[] args) {
        Day23RangeBitwiseAnd test = new Day23RangeBitwiseAnd();

    }
}
