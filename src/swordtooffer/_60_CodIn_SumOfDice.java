package swordtooffer;

import java.util.Arrays;

/**
 * @author YC (shell845)
 * @date 20/4/2020 12:40 PM
 */

public class _60_CodIn_SumOfDice {
    /** time complexity O(n * 6 * n * 6) -> O(n^2), space O(n)*/
    public double[] twoSum_2(int n) {
        double[] ans = new double[5 * n + 1];
        int[] dp = new int[6 * n];
        double totalCount = Math.pow(6, n);
        // initialize base case
        for (int i = 0; i < 6; i++) {
            dp[i] = 1;
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < n; i++) {
            for (int j = 6 * (i + 1) - 1; j >= i; j--) {
                int sum = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j - k < i - 1) break;
                    sum += dp[j - k];
                }
                dp[j] = sum;
            }
            System.out.println(Arrays.toString(dp));
        }
        for (int i = 0, j = n - 1; i < ans.length; i++, j++) {
            ans[i] = dp[j] / totalCount;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    /** time complexity O(n * 6 * n * 6) -> O(n^2), space O(n^2)*/
    public double[] twoSum(int n) {
        double[] ans = new double[5*n + 1];
        int[][] dp = new int[n + 1][6*n + 1];
        double totalCount = Math.pow(6, n);
        // initialize base case
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        // dp
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= 6*(i); j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][j] += j >= k ? dp[i - 1][j - k] : 0;
                    if (i == n)
                        ans[j-i] = dp[i][j] / totalCount;
                }
            }
            print2DArray(dp);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private void print2DArray(int[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        _60_CodIn_SumOfDice test = new _60_CodIn_SumOfDice();
        test.twoSum(2);
        test.twoSum_2(2);
    }
}
