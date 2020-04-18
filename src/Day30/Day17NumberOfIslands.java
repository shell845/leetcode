package Day30;

/**
 * @author YC (shell845)
 * @date 18/4/2020 11:04 AM
 */

public class Day17NumberOfIslands {
    /** time complexity O(N), space O(1) */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // find an island and turn the island to 0 (if can modify grid; if cannot modify then need an extra 2D array to mark)
                    count++;
                    islandToWater(grid, i, j);
                }
            }
        }
        return count;
    }

    private void islandToWater(char[][] grid, int si, int sj) {
        grid[si][sj] = '0';
        if (si < grid.length - 1 && grid[si + 1][sj] == '1') islandToWater(grid, si + 1, sj);
        if (si > 0 && grid[si - 1][sj] == '1') islandToWater(grid, si - 1, sj);
        if (sj < grid[si].length - 1 && grid[si][sj + 1] == '1') islandToWater(grid, si, sj + 1);
        if (sj > 0 && grid[si][sj - 1] == '1') islandToWater(grid, si, sj - 1);
    }
}
