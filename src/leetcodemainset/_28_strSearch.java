package leetcodemainset;

/**
 * @author YC (shell845)
 * @date 2/2/2021 3:07 PM
 */

public class _28_strSearch {
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;

        int m = haystack.length(), n = needle.length();
        // build KMP dp matrix, iterate through pattern needle
        int[][] dp = new int[n][5];
        int pos = 0; // shade index
        dp[pos][needle.charAt(pos) - 'a'] = 1; // base case
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 5; c++) dp[i][c] = dp[pos][c];
            dp[i][needle.charAt(i) - 'a'] = i + 1;
            pos = dp[pos][needle.charAt(i) - 'a']; // update shade index
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // search for matching substring
        pos = 0; // position of pattern string
        for (int i = 0; i < m; i++) {
            pos = dp[pos][haystack.charAt(i) - 'a']; // next status
            if (pos == n) return i - n + 1; // all match
        }

        return -1;
    }

    public static void main(String args[]) {
        strStr("ababa", "ababc");
    }
}
