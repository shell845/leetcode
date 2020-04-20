package leetcodemainset;

/**
 * @author YC 03/20/2020
 */

public class _70_ClimbingStairs {
    /** Complexity O(n) Space O(1) */
    public int climbStairs(int n) {
        int fir = 0;
        int sec = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = fir + sec;
            fir = sec;
            sec = sum;
        }
        return sec;
    }
}
