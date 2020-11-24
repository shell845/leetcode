package leetcodemainset;

/**
 * @author YC (shell845)
 * @date 24/5/2020 11:57 AM
 */

public class _200_NumOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i > 0 && grid[i - 1][j] == '1') uf.union(i * col + j, (i - 1) * col + j);
                    if (i < row - 1 && grid[i + 1][j] == '1') uf.union(i * col + j, (i + 1) * col + j);
                    if (j > 0 && grid[i][j - 1] == '1') uf.union(i * col + j, i * col + j - 1);
                    if (j < col - 1 && grid[i][j + 1] == '1') uf.union(i * col + j, i * col + j + 1);
                }
            }
        }
        return uf.getCount();
    }
}

class UnionFind {
    int count;
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) {
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    count++;
                }
                rank[i * n + j] = 0;
            }
        }
    }

    public int find(int i) {
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
