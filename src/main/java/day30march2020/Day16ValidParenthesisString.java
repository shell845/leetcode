package main.java.day30march2020;

import java.util.Stack;

/**
 * @author YC (shell845)
 * @date 17/4/2020 11:39 AM
 */

public class Day16ValidParenthesisString {
    /** consider scenario when given string contains ( and ) only
     * they expand to (, * and )
     * time complexity O(n), space O(1) */
    public boolean checkValidString(String s) {
        if (s == null) return false;

        int low = 0, high = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                low++;
                high++;
            } else if (c[i] == ')') {
                low = --low > 0? low:0;
                high--;
            } else {
                low = --low > 0? low:0;
                high++;
            }
            if (high < 0) return false;
        }
        return low == 0;
    }

    /** Use 2 stacks
     * time complexity O(n), space O(n) */
    private class Tuple<Character, Integer> {
        char c;
        int i;
        public Tuple(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }

    public boolean checkValidString_stack(String s) {
        if (s == null) return false;

        Stack<Tuple<Character, Integer>> right = new Stack<Tuple<Character, Integer>>();
        Stack<Tuple<Character, Integer>> asterisk = new Stack<Tuple<Character, Integer>>();
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == '*') {
                asterisk.push(new Tuple(c[i], i));
            }  else if (c[i] == ')') {
                right.push(new Tuple(c[i], i));
            } else {
                if (!right.isEmpty()) {
                    right.pop();
                } else if (!asterisk.isEmpty()) {
                    asterisk.pop();
                } else return false;
            }
        }
        while (!right.isEmpty()) {
            if (asterisk.isEmpty() || right.pop().i < asterisk.pop().i) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(()(()))(()()()))))((((()*()*(())())(()))((*()(*((*(*()))()(())*()()))*)*()))()()(())()(()))())))";
        String s1 = ")*";
        String s2 = "(*)";
        Day16ValidParenthesisString test = new Day16ValidParenthesisString();
        System.out.println(test.checkValidString(s));

    }
}
