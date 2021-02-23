package main.java.leetcodemainset;

/**
 * @author YC (shell845)
 * @date 3/2/2021 10:15 AM
 */
import java.util.*;

public class _772_BasicCalculatorIII {
    int i;
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        i = 0;
        return helper(s);
    }

    int helper(String s) {
        // + - * / ( )
        // 2*(5+5 * 2) / 3+(6/2+8 ) = 21
        // 2-1 + 2*(5+5 * 2) / 3+(6/2+8 ) = 22
        Deque<Integer> stack = new LinkedList<>();
        int opt = '+';
        int num = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = c - '0' + num * 10;
            }
            if (c == '(') {
                i++;
                num = helper(s);
            }
            if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == s.length() - 1) {
                switch (opt) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                opt = c;
                num = 0;
            }
            if (c == ')') {
                i++;
                return sum(stack);
            }
        }
        return sum(stack);
    }

    int sum(Deque<Integer> stack) {
        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }

    public static void main(String args[]) {
        _772_BasicCalculatorIII test = new _772_BasicCalculatorIII();
        System.out.println(test.calculate("2*(5+5 * 2) / 3+(6/2+8 ) = 21"));
        System.out.println(test.calculate("2-1 + 2*(5+5 * 2) / 3+(6/2+8 )"));
        System.out.println(test.calculate("1+2*3/(2-1)")); // 7
    }
}
