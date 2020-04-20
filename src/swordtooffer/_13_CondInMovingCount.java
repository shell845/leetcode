package swordtooffer;

/**
 * @author YC 03/23/2020
 */

public class _13_CondInMovingCount {
    /** Complexity O(mn), space O(mn)*/
    public int movingCount(int m, int n, int k) {
        boolean[][] grid = new boolean[m][n];
        return dfs(grid, k, 0, 0);
    }

    private int dfs(boolean[][] grid, int k, int i, int j) {
        int check = i / 10 + i % 10 + j / 10 + j % 10; // 1 <= n,m <= 100
        if (check > k || i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j]) return 0;
        grid[i][j] = true;
        // check right & down only
        return 1 + dfs(grid, k, i + 1, j) + dfs(grid, k, i, j + 1);
    }
}
