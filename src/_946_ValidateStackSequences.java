import java.util.Stack;

/**
 * @author YC 03/30/2020
 */

public class _946_ValidateStackSequences {
    /** Complexity O(N), space O(N) */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) return false;

        Stack<Integer> stack = new Stack();
        int k = pushed.length;
        int i = 0, j = 0;

        while (i < k && j < k) {
            if (stack.empty() || popped[j] != stack.peek()) {
                stack.push(pushed[i]);
                i++;
            } else {
                stack.pop();
                j++;
            }
        }

        while (j < k && !stack.empty()) {
            if (stack.pop() != popped[j++]) return false;
        }

        return stack.empty();
    }

    /** Correct but not good */
    public boolean validateStackSequences_origin(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) return false;

        Stack<Integer> stack = new Stack();
        int k = pushed.length;
        int i = 0, j = 0;
        while (i < k && j < k) {
            if (pushed[i] != popped[j]) {
                stack.push(pushed[i++]);
            } else {
                i++;
                j++;
                if (stack.empty() || (i < k && j < k && pushed[i] == popped[j])) {
                    continue;
                } else if (j < k && stack.peek() == popped[j]) {
                    while (j < k && !stack.empty() && stack.peek() == popped[j]) {
                        stack.pop();
                        j++;
                    }
                } else if (j < k && i < k && stack.peek() != popped[j]) {
                    stack.push(pushed[i++]);
                } else {
                    return false;
                }
            }
        }

        while (j < k && !stack.empty()) {
            if (stack.pop() != popped[j++]) return false;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        _946_ValidateStackSequences test = new _946_ValidateStackSequences();
        int[] push = new int[] {2,1,3,0};
        int[] pop = new int[] {1,3,0,2};
        test.validateStackSequences(push, pop);
    }
}
