package main.java.day30march2020;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author YC (shell845)
 * @date 19/4/2020 12:36 PM
 */

public class Day17MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] record = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                record[i][j] = -1;
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            bfs(grid, curr[0], curr[1], record, queue);
        }
        return record[grid.length - 1][grid[0].length - 1];
    }

    private void bfs(int[][] grid, int si, int sj, int[][] record, Queue<int[]> queue) {
        if (si >= grid.length || sj >= grid[si].length || record[si][sj] != -1) return;

        int up = -1, left = -1;
        if (si > 0) up = record[si - 1][sj];
        if (sj > 0) left = record[si][sj - 1];

        if (up == -1 && left == -1) record[si][sj] = grid[si][sj];
        else if (up == -1) record[si][sj] = left + grid[si][sj];
        else if (left == -1) record[si][sj] = up + grid[si][sj];
        else record[si][sj] = Math.min(up, left) + grid[si][sj];

        queue.add(new int[]{si, sj + 1});
        queue.add(new int[]{si + 1, sj});
    }
}
