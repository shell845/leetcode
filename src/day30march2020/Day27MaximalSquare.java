package day30march2020;

/**
 * @author YC (shell845)
 * @date 28/4/2020 11:34 AM
 */

public class Day27MaximalSquare {
    /** Dynamic programming
     * time complexity O(MN), space O(N) */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) return 0;
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int max = 0, prev = 0;
        int[] dp = new int[cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '0') dp[j] = 0;
                else {
                    dp[j] = Math.min(dp[j - 1], Math.min(dp[j], prev)) + 1;
                    max = Math.max(max, dp[j]);
                }
                prev = temp;
            }
        }
        return max * max;
    }

    /** Dynamic programming
     * time complexity O(MN), space O(MN) */
    public int maximalSquare_dp1(char[][] matrix) {
        if (matrix == null) return 0;
        int max = 0, rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    /** Brute force - accept
     * time complexity O((MN)^2), space O(MN) */
    public int maximalSquare_bf2(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    if (maxsqlen < sqlen) {
                        maxsqlen = sqlen;
                    }
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    /** Brute force - time limit exceeded
     * time complexity O((MN)^2), space O(MN) */
    public int maximalSquare_bf1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        for (int i = 0; i < matrix.length - max; i++) {
            for (int j = 0; j < matrix[0].length - max; j++) {
                if (matrix[i][j] == '0') continue;
                int len = 1 + findSquare(matrix, i, j);
                max = Math.max(max, len);
            }
        }
        return max * max;
    }

    private int findSquare(char[][] matrix, int i, int j) {
        if (matrix[i][j] == '0') return 0;
        int len = 0;
        if (i < matrix.length - 1 && j < matrix[0].length - 1) {
            if (matrix[i + 1][j] == '1' && matrix[i][j + 1] == '1' && matrix[i + 1][j + 1] == '1') {
                int a = findSquare(matrix, i + 1 , j);
                int b = findSquare(matrix, i , j + 1);
                int c = findSquare(matrix, i + 1 , j + 1);
                len = 1 + Math.min(a, Math.min(b, c));
            }
        }
        return len;
    }
}
