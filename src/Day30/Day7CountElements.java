/**
 * @author YC 04/08/2020
 */

package Day30;

import java.util.Arrays;
import java.util.HashSet;

public class Day7CountElements {
    /** Complexity O(n), space O(n) */
    public int countElements_set(int[] arr) {
        if (arr == null) return 0;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);
        for (int i : arr) {
            if (set.contains(i + 1)) count++;
        }
        return count;
    }

    /** Complexity O(n^2), space O(1) */
    public int countElements_bruteforce(int[] arr) {
        if (arr == null) return 0;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] == 1) {
                    count++;
                    break;
                } else if (arr[j] - arr[i] > 1) break;
            }
        }
        return count;
    }
}
