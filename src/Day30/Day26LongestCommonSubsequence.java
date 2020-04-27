package Day30;

/**
 * @author ych
 * @date 27/4/2020 12:22 PM
 */
public class Day26LongestCommonSubsequence {
    /** time complexity O(MN), space O(MN)
     * Dynamic programming */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] dp = new int[c1.length][c2.length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j - 1] + 1 : 1;
                } else {
                    int up = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = Math.max(up, left);
                }
            }
        }
        return dp[c1.length - 1][c2.length - 1];
    }

    /** time complexity O(MN), space O(M + N) */
    public int longestCommonSubsequence_reference(String text1, String text2) {
        char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
        int dp[] = new int[t2.length+1];
        for(int i = 1; i <= t1.length; i++) {
            int prev = 0;
            for(int j = 1; j <= t2.length; j++) {
                int tmp = dp[j];
                if(t1[i-1] == t2[j-1]) dp[j] = prev + 1;
                else dp[j] = Math.max(dp[j], dp[j-1]);
                prev = tmp;
            }
        }
        return dp[t2.length];
    }
}
