import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author YC 04/06/2020
 */

public class _40_CodInGetLeastNumbers {
    /** Complexity O(n), space O(1)
     * Suit for large arr & small k */
    public int[] getLeastNumbers_heap(int[] arr, int k) {
        Comparator<Integer> cmp = (a, b) -> {
            if (a > b) return -1;
            if (a < b) return 1;
            return 0;
        };

        PriorityQueue<Integer> queue = new PriorityQueue<>(cmp);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.add(arr[i]);
            } else {
                if (arr[i] < queue.peek()) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i] = queue.poll();
            i++;
        }
        return  ans;
    }

    /** Complexity O(n), space O(1) */
    public int[] getLeastNumbers_partition(int[] arr, int k) {
        System.out.println(Arrays.toString(arr));
        partition(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private void partition(int[] arr, int l, int r, int k) {
        if (l >= r) return;

        int i = l;
        int j = r - 1;
        while (i < j) {
            while (i < r && arr[i] < arr[r]) {
                i++;
            }
            while (j > l && arr[j] >= arr[r]) {
                j--;
            }
            if (i < j) swap(arr, i, j);
        }
        if (arr[i] > arr[r]) swap(arr, i, r);
        if (i > k - 1) {
            partition(arr, l, i - 1, k);
        } else if (i < k - 1) {
            partition(arr, i + 1, r, k);
        } else return;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /** Complexity O(nlogn), space O(1) */
    public int[] getLeastNumbers_sort(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        int i = 0;
        int j = 0;
        while (i < arr.length && j < k) {
            ans[j] = arr[i];
            i++;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        _40_CodInGetLeastNumbers test = new _40_CodInGetLeastNumbers();
        test.getLeastNumbers_partition(new int[]{3,2,1}, 2);
    }
}
