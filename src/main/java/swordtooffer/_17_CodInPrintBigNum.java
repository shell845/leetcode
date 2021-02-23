package main.java.swordtooffer;

/**
 * @author YC 03/25/2020
 */

public class _17_CodInPrintBigNum {
    /** User string for int / long overflow scenario */
    public void printNumbers_bigNum(int n) {
        if (n < 0) return;

        char[] c = new char[n];
        for (int i = 0; i < n; i++) {
            c[i] = '0';
        }

        /* solution 1: while loop */
        while (!increment(c)) {
            printNumber(c);
        }

        /* solution 2: recursion */
        incrementRecursive(c, n, -1);

        /* solution 3: StringBuilder */
        StringBuilder sb = new StringBuilder("0");
        while(incrementStringBuilder(sb, n)) {
            System.out.println(sb.reverse().toString());
            sb.reverse();
        }
    }

    private void incrementRecursive(char[] c, int n, int index) {
        if (index == n - 1) {
            printNumber(c);
            return;
        }

        for (int i = 0; i < 10; i++) {
            c[index + 1] = (char) ('0' + i);
            incrementRecursive(c, n, index + 1);
        }
    }

    private boolean increment(char[] c) {
        boolean isOverflow = false;
        int nTakeOVer = 0;
        int nLength = c.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = c[i] - '0' + nTakeOVer;
            if (i == nLength - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOVer = 1;
                    c[i] = (char) ('0' + nSum);
                }
            } else {
                c[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    private boolean incrementStringBuilder(StringBuilder sb, int n) {
        boolean takeOver = false;
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || takeOver) {
                if (sb.charAt(i) == '9') {
                    takeOver = true;
                    sb.setCharAt(i, '0');
                } else {
                    sb.setCharAt(i, (char) (sb.charAt(i) + 1));
                    takeOver = false;
                }
            } else break;
        }
        if (takeOver) {
            sb.append('1');
        }
        return sb.length() <= n;
    }

    private void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }


    /** Simple solution not considering big number */
    public int[] printNumbers_simple(int n) {
        int max = (int) Math.pow(10, n);
        int[] ans = new int[max - 1];
        for (int i = 1; i < max; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        _17_CodInPrintBigNum test = new _17_CodInPrintBigNum();
        test.printNumbers_bigNum(3);
    }
}
