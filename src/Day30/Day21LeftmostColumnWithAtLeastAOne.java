package Day30;

import java.util.List;

/**
 * @author ych
 * @date 21/4/2020 4:49 PM
 */
public class Day21LeftmostColumnWithAtLeastAOne {
    interface BinaryMatrix {
       public int get(int x, int y);
       public List<Integer> dimensions();
   };

    /** time complexity O(nlogm), space O(nlogm) for recursion
     * use binary search to reduce search times */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int row = dim.get(0) - 1, col = dim.get(1) - 1, leftmost = -1;

        for (int i = 0; i <= row; i++) {
            if (binaryMatrix.get(i, col) == 0) continue;

            int localLeft = binarySearch(binaryMatrix, i, 0, col);
            if (leftmost == -1) leftmost = localLeft;
            else leftmost = Math.min(leftmost, localLeft);
            if (leftmost == 0) return leftmost;
        }
        return leftmost;
    }

    private int binarySearch(BinaryMatrix binaryMatrix, int row, int l, int r) {
        if (l >= r) {
            return l;
        }

        int mid = (l + r) / 2;
        if (binaryMatrix.get(row, mid) == 0) {
            return binarySearch(binaryMatrix, row, mid + 1, r);
        } else return binarySearch(binaryMatrix, row, l, mid);
    }
}
