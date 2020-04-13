import java.util.Queue;

/**
 * @author YC 04/11/2020
 */

public class _47_CodInMaxValueOfGift {
    /** Iteration
     * time O(mn), space O(n) */
    public int maxValue_iterate1DArray(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int[] val = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = val[j];
                }
                if (j > 0) {
                    left = val[j - 1];
                }
                val[j] = Math.max(left, up) + grid[i][j];
            }
        }

        return val[grid[0].length - 1];
    }

    /** Iteration
     * time O(mn), space O(mn) */
    public int maxValue_iterate(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int[][] val = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = val[i - 1][j];
                }
                if (j > 0) {
                    left = val[i][j - 1];
                }
                val[i][j] = Math.max(left, up) + grid[i][j];
            }
        }

        return val[grid.length - 1][grid[0].length - 1];
    }

    /** DFS recursion
     * exceed time limit
     * time(?) space(mn) */
    public int maxValue_dfs(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int[][] val = new int[grid.length][grid[0].length];
        val[0][0] = grid[0][0];
        maxValueHelper(grid, val, 0, 0);
        return val[grid.length - 1][grid[0].length - 1];
    }

    private void maxValueHelper(int[][] grid, int[][] val, int i, int j) {
        if (i >= grid.length || j >= grid[i].length) return;
        if (i > 0) {
            val[i][j] = Math.max(val[i][j], val[i - 1][j] + grid[i][j]);
        }
        if (j > 0) {
            val[i][j] = Math.max(val[i][j], val[i][j - 1] + grid[i][j]);
        }
        maxValueHelper(grid, val, i + 1, j);
        maxValueHelper(grid, val, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] m = new int[0][0];
        System.out.println(m.length);
        System.out.println(m[0].length);
    }
}
