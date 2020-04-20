package leetcodemainset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YC 03/29/2020
 */

public class _54_SpiralMatrix {
    /** Improved solution */
    public int[] spiralOrder_array(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int[] ans = new int[matrix.length * matrix[0].length];
        int l = 0, r = matrix[0].length - 1;
        int u = 0, d = matrix.length - 1;
        int pos = 0;

        while (true) {
            // right
            for (int i = l; i <= r; i++) {
                ans[pos++] = matrix[u][i];
            };
            if (++u > d) break;
            // down
            for (int i = u; i <= d; i++) {
                ans[pos++] = matrix[i][r];
            }
            if (--r < l) break;
            // left
            for (int i = r; i >= l; i--) {
                ans[pos++] = matrix[d][i];
            }
            if (--d < u) break;
            // up
            for (int i = d; i >= u; i--) {
                ans[pos++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return ans;
    }

    /** Original solution */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        turnRight(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, list);
        return list;
    }

    private void turnRight(int[][] matrix, int i, int ilast, int j, int jlast, List<Integer> list) {
        if (j > jlast) return;
        int k = j;
        while (k <= jlast) {
            list.add(matrix[i][k]);
            k++;
        }
        turnDown(matrix, i + 1, ilast, j, jlast, list);
    }

    private void turnDown(int[][] matrix, int i, int ilast, int j, int jlast, List<Integer> list) {
        if (i > ilast) return;
        int k = i;
        while (k <= ilast) {
            list.add(matrix[k][jlast]);
            k++;
        }
        turnLeft(matrix, i, ilast, j, jlast - 1, list);
    }

    private void turnLeft(int[][] matrix, int i, int ilast, int j, int jlast, List<Integer> list) {
        if (jlast < j) return;
        int k = jlast;
        while (k >= j) {
            list.add(matrix[ilast][k]);
            k--;
        }
        turnUp(matrix, i, ilast - 1, j, jlast, list);
    }

    private void turnUp(int[][] matrix, int i, int ilast, int j, int jlast, List<Integer> list) {
        if (ilast < i) return;
        int k = ilast;
        while (k >= i) {
            list.add(matrix[k][j]);
            k--;
        }
        turnRight(matrix, i, ilast, j + 1, jlast, list);
    }
}
