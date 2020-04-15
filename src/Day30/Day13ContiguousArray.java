/**
 * @author YC 04/14/2020
 */

package Day30;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day13ContiguousArray {
    /** time complexity O(n), space O(n) */
    public int findMaxLength(int[] nums) {
        int[] arr = new int[nums.length * 2 + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (arr[count + nums.length] >= -1) {
                maxLen = Math.max(maxLen, i - arr[count + nums.length]);
            } else arr[count + nums.length] = i;
        }
        return maxLen;
    }

    /** time complexity O(n), space O(n) */
    public int findMaxLength_hashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // or replace with: if (count == 0) maxLen = Math.max(maxLen, i + 1);
        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1:-1);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else map.put(count, i);
        }
        return maxLen;
    }

    /** time complexity O(n^2), space O(1) */
    public int findMaxLength_bruteForce(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    count0++;
                } else {
                    count1++;
                }
                if (count0 == count1) maxLen = Math.max(maxLen, count0 + count1);
            }
        }
        return maxLen;
    }
}
