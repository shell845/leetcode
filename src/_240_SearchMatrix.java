/**
 * @author YC 03/18/2020
 */

public class _240_SearchMatrix {
    private int[][] m;
    private int t;

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /** Complexity O(n + m), Space O(1) */
        if (matrix.length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else return true;
        }
        return false;
    }

        /** Complexity O(nm), Space O(1) */
        /* if (matrix.length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length;j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false; */

        /** Complexity O(nm), Space O(1)
         * Recursively search mid-point. This solution is too complicate & not efficient */
        /*if (matrix.length == 0) return false;
        this.m = matrix;
        this.t = target;
        return findHelper(0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean findHelper(int minR, int maxR, int minC, int maxC) {
        if (minR > maxR || minC > maxC) return false;

        if (minR == maxR && minC == maxC ) {
            return (this.m[minR][minC] == this.t);
        }


        int midR = (minR + maxR) / 2;
        int midC = (minC + maxC) / 2;

        if (midR == minR && midC == minC) {
            return (this.m[minR][minC] == this.t ||
                    this.m[minR][maxC] == this.t ||
                    this.m[maxR][minC] == this.t ||
                    this.m[maxR][maxC] == this.t);
        }

        if (this.m[midR][midC] > this.t) {
            return (findHelper(minR, midR, minC, midC) || findHelper(midR, maxR, minC, midC) || findHelper(minR, midR, midC, maxC));
        } else if (this.m[midR][midC] < this.t) {
            return (findHelper(midR, maxR, midC, maxC) || findHelper(midR, maxR, minC, midC) || findHelper(minR, midR, midC, maxC));
        } else return true;
    } */

    public static void main(String[] args) {
        int[][] m = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
//        int[][] m = new int[][] {{1, 3, 5}};
        _240_SearchMatrix s = new _240_SearchMatrix();
        boolean res = s.findNumberIn2DArray(m, 3);
        System.out.println(res);
    }
}
