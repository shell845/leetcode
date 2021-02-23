package main.java.swordtooffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author YC 04/09/2020
 */

public class _45_CodInArrayToMinNum {
    /** Complexity O(nlogn), space O(n) */
    public String minNumber_quickSort(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        System.out.println(Arrays.toString(s));
        // shuffle array before sort to ensure performance
        quickSort(s, 0, s.length - 1);

        System.out.println(Arrays.toString(s));
        StringBuilder sb = new StringBuilder();
        for (String str:s) {
            sb.append(str);
        }
        return sb.toString();
    }

    private void quickSort(String[] s, int l, int r) {
        if (l >= r) return;

        // 10, 2
        int i = l;
        int j = r - 1;
        String temp = s[i]; // initial value, consider if not going through while loop (i == j)
        while (i < j) {
            while ((s[i] + s[r]).compareTo(s[r] + s[i]) < 0) {
                i++;
                if (i == r) break;
            }
            while ((s[j] + s[r]).compareTo(s[r] + s[j]) >= 0) {
                j--;
                if (j == l) break;
            }
            if (i >= j) break;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        if ((s[i] + s[r]).compareTo(s[r] + s[i]) >= 0) {
            temp = s[i];
            s[i] = s[r];
            s[r] = temp;
        }
        quickSort(s, l, i - 1);
        quickSort(s, i + 1, r);
    }

    /** Complexity O(nlogn), space O(n) */
    public String minNumber(int[] nums) {
        Comparator<String> cmp = (a, b) -> {
            return (a + b).compareTo(b + a);
        };

        // or:
        // Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        PriorityQueue<String> queue = new PriorityQueue<>(cmp);
        for (int i : nums) {
            queue.add(String.valueOf(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _45_CodInArrayToMinNum test = new _45_CodInArrayToMinNum();
        System.out.println(test.minNumber_quickSort(new int[] {3,30,34,5,9}));
    }
}
