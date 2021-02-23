package main.java.leetcodemainset; /**
 * @author YC 03/20/2020
 */
/**
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 **/

public class _509_FibonacciNumber {
    public int fib(int N) {
        // use long instead of int for big number
        int a = 0, b = 1, sum = 0;
        for(int i = 0; i < N - 2; i++){ // not looping for 0 & 1
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;

        /** Complexity exponential */
        /*if (N == 0) return 0;
        if (N == 1) return 1;
        return fib(N - 1) + fib(N - 2);*/
    }

    public static void main(String[] args) {
        _509_FibonacciNumber test = new _509_FibonacciNumber();
        System.out.println(test.fib(2));
    }
}
