/**
 * @author YC 04/06/2020
 */

package main.java.day30march2020;

import java.util.Stack;

public class Day5MaxProfit {
    /** b - a + c - b = c - a */
    /** Complexity O(n), space O(1) */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    /** Complexity O(n), space O(n) */
    public int maxProfit_stack(int[] prices) {
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty() && stack.peek() < prices[i]) {
                sum += prices[i] - stack.pop();
            }
            stack.push(prices[i]);
        }
        return sum;
    }
}
