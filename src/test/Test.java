package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author YC 03/25/2020
 */

public class Test {
    public void printBigNum(int n) {
        if (n < 0) return;
        char[] c = new char[n];
        for (int i = 0; i < n; i++) {
            c[i] = '0';
        }

        /*while(!increment(c, n)) {
            System.out.println(Arrays.toString(c));
        }*/

        StringBuilder sb = new StringBuilder("0");
        while(incrementStringBuilder(sb, n)) {
            System.out.println(sb.reverse().toString());
            sb.reverse();
        }

        /*for (int i = 0; i < 10; i++) {
            c[0] = (char) ('0' + i);
            incrementRecursive(c, n, 1);
        }*/
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

    private boolean increment(char[] c, int n) {
        int carry = 0;
        boolean isOverFlow = false;
        for (int i = n - 1; i >= 0; i--) {
            int sum = c[i] - '0' + carry;
            if (i == n - 1) sum++;
            if (sum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                    break;
                }
                carry = 1;
                c[i] = '0';
                //c[i] = (char) ('0' + sum);
            } else {
                c[i] = (char) ('0' + sum);
                break;
            }
        }
        return isOverFlow;
    }

    private void incrementRecursive(char[] c, int n, int index) {
        if (index == n) {
            System.out.println(Arrays.toString(c));
            return;
        }

        for (int i = 0; i < 10; i++) {
            c[index] = (char) ('0' + i);
            incrementRecursive(c, n, index + 1);
        }
    }


    public static void main(String[] args) {
        Stack st = new Stack();
        System.out.println(st.pop());
    }
}
