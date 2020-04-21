package swordtooffer;

import java.util.Stack;

/**
 * @author ych
 * @date 21/4/2020 12:44 PM
 */
public class _63_MaxProfit {
    /** only 1 transaction is allowed (can buy / sell only once)
     * time complexity O(n), space O(1) */
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int min = prices[0];
        int max = 0;
        for (int i:prices) {
            min = Math.min(min, i);
            max = Math.max(max, i - min);
        }
        return max;
    }

    /** if can buy / sell multiple times
     * time complexity O(n), space O(n) */
    public int maxProfit_multiTransaction(int[] prices) {
        if (prices == null) return 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty() && stack.peek() < prices[i]) {
                max += prices[i] - stack.pop();
            }
            stack.push(prices[i]);
        }
        return max;
    }
}
