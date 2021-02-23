package main.java.swordtooffer; /**
 * @author YC 03/20/2020
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
public class _09_CodInStackToQueue {
    public class CQueue {
        private Deque<Integer> pri;
        private Deque<Integer> sec;

        public CQueue() {
            pri = new ArrayDeque<>();
            sec = new ArrayDeque<>();
        }

        /** complexity O(1), space O(1) */
        public void appendTail(int value) {
            pri.push(value);
        }

        /** complexity O(n), space O(1) */
        public int deleteHead() {
            if (sec.size() > 0) {
                return sec.pop();
            } else if (pri.size() > 0) {
                while (pri.peek() != null) {sec.push(pri.pop());}
                return sec.pop();
            } else return -1;
        }
    }
}
