package main.java.swordtooffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author YC 04/04/2020
 */

public class _38II_CodInPermutateString {
    private char[] c;
    private HashSet<String> result;
    public String[] permutation(String s) {
        // set = new HashSet<>();
        c = s.toCharArray();
        result = new HashSet<>();
        Stack<Character> stack = new Stack<>();;
        for (int i = 1; i <= s.length(); i++) {
            helper(0, i, stack);
        }
        System.out.println(Arrays.toString(result.toArray()));
        return null;
    }

    private void helper(int pos, int len, Stack<Character> stack) {
        if (len <= 0) {
            if (stack.isEmpty()) return;
            result.add(String.valueOf(stack));
            return;
        }

        if (pos >= c.length) { return; }

        stack.push(c[pos]);
        helper(pos + 1, len - 1, stack);

        stack.pop();
        helper(pos + 1, len, stack);
    }

    public static void main(String[] args) {
        _38II_CodInPermutateString test = new _38II_CodInPermutateString();
        test.permutation("abc");
    }
}
