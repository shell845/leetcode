/**
 * @author YC 04/13/2020
 */

package Day30;

import java.util.Arrays;

public class Day11LastStoneWeight {
    /** Solution 1: use Arrays.sort() */

    /** Solution 2: self write quickSort and insertionSort */
    /* public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return -1;

        // shuffle the array before quick sort
        quickSort(stones, 0, stones.length - 1);
        System.out.println(Arrays.toString(stones));
        for (int i = 0; i < stones.length - 1; i++) {
            stones[i + 1] = stones[i] - stones[i + 1];
            insertionSort(stones, i + 1);
        }
        return stones[stones.length - 1];
    } */

    /** Solution 3: heapSort */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return -1;

        // shuffle the array before quick sort
        heapSort(stones);
        System.out.println(Arrays.toString(stones));
        for (int i = 0; i < stones.length - 1; i++) {
            stones[i + 1] = stones[i] - stones[i + 1];
            heapSort(stones);
        }
        return stones[stones.length - 1];
    }

    private void heapSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            minHeap(arr, i);
            swap(arr, 0, i);
        }
    }

    private void minHeap(int[] arr, int last) {
        for (int i = last; i > 0; i--) {
            if (parent(i) > arr[i]) swap(arr, parent(i), i);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l, j = r - 1;
        while (true) {
            while (arr[i] >= arr[r]) {
                if (i == r) break;
                i++;
            }
            while (arr[j] < arr[r]) {
                if (j == l) break;
                j--;
            }
            if (i < j) swap(arr, i, j);
            else break;
        }
        swap(arr, i, r);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    private void insertionSort(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                swap(arr, i - 1, i);
            } else return;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Day11LastStoneWeight test = new Day11LastStoneWeight();
        int[] arr = new int[] {2, 7, 4, 1, 8, 1};
        test.lastStoneWeight(arr);
        System.out.println(Arrays.toString(arr));
    }
}
