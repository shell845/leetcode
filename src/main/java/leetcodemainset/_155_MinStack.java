package main.java.leetcodemainset;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author YC 03/30/2020
 */

public class _155_MinStack {
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque;
        Deque<Integer> dequeMin;
        /** initialize your data structure here. */
        public MinStack() {
            deque = new ArrayDeque<Integer>();
            dequeMin = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            deque.push(x);
            if (dequeMin.isEmpty() || dequeMin.peek() >= x) {
                dequeMin.push(x);
            } else {
                dequeMin.push(dequeMin.peek());
            }
        }

        public void pop() {
            if (deque.isEmpty()) return;
            deque.pop();
            dequeMin.pop();
        }

        public int top() {
            if (deque.isEmpty()) return -1;
            return deque.peek();
        }

        public int getMin() {
            if (dequeMin.isEmpty()) return -1;
            return dequeMin.peek();
        }
    }
}
