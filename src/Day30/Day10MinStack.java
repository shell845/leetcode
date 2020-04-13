/**
 * @author YC 04/11/2020
 */

package Day30;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Day10MinStack {
    /** reversed LinkedList solution
     * time O(1), space O(n) */
    /*class Node {
        int val;
        int min;
        Node next;

        private Node(int v, int m) {
            val = v;
            min = m;
            next = null;
        }
    }

    private Node top;

    public MinStack() {
        top = null;
    }

    public void push(int x) {
        if (top == null) {
            top = new Node(x, x);
        } else {
            Node node = new Node(x, Math.min(x, top.min));
            node.next = top;
            top = node;
        }
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }*/

    /** 1 stack solution
     * time O(1), space O(n) */
    /*Deque<Integer> stack;
    int min = Integer.MIN_VALUE;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        return min;
    }*/
}
