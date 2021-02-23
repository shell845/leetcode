package main.java.leetcodemainset;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author YC (shell845)
 * @date 18/4/2020 12:55 PM
 */

public class _59_SlidingWindow {

    /** time complexity for push_back / pop_front / max_value O(1), space O(n) */
    class MaxQueue {
        int index = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        Deque<int[]> max = new ArrayDeque<>();

        public MaxQueue() {
        }

        public int max_value() {
            if (max.isEmpty()) return -1;
            return max.peek()[0];
        }

        public void push_back(int value) {
            int[] e = new int[]{value, index};
            index++;
            deque.add(e);
            while(!max.isEmpty() && max.getLast()[0] < value) {
                max.removeLast();
            }
            max.add(e);
        }

        public int pop_front() {
            if (deque.isEmpty()) return -1;
            int[] value = deque.poll();
            if (max.peek()[1] == value[1]) max.poll();
            return value[0];
        }
    }

    /** leetcode #239
     * * time complexity O(n), space O(n) */
    public static int[] slidingWindowMax(final int[] in, final int w) {
        final int[] max_left = new int[in.length];
        final int[] max_right = new int[in.length];

        max_left[0] = in[0];
        max_right[in.length - 1] = in[in.length - 1];

        for (int i = 1; i < in.length; i++) {
            max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

            final int j = in.length - i - 1;
            max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
        }

        final int[] sliding_max = new int[in.length - w + 1];
        for (int i = 0, j = 0; i + w <= in.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
        }

        return sliding_max;
    }

    /** use double open ended queue (deque)
     * time complexity O(n), space O(n)*/
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        Deque<int[]> deque = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            // add new element to queue
            while (!deque.isEmpty() && deque.peekLast()[0] < nums[i]) {
                deque.pollLast();
            }
            deque.add(new int[]{nums[i], i});
            // remove out of window elements from queue
            while (deque.peekFirst()[1] <= i - k) {
                deque.pollFirst();
            }
            // add max num in window to answer
            if (i >= k - 1 && !deque.isEmpty()) {
                ans[idx] = deque.peekFirst()[0];
                idx++;
            }
        }
        return ans;
    }

    /** time complexity O(nk), space O(n)*/
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0, idx = 0; i < nums.length - k + 1; i++, idx++) {
            int temp = nums[i];
            for (int j = 1; j < k; j++) {
                temp = Math.max(temp, nums[i + j]);
            }
            ans[idx] = temp;
        }
        return ans;
    }
}
