/**
 * @author YC 04/03/2020
 */

package main.java.day30march2020;

import java.util.HashSet;
import java.util.Stack;

public class Day2HappyNumber {
    /** Sample solution
     * Complexity O(?), space O(?) */
    public boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (set.isEmpty() || !set.contains(n)) {
            set.add(n);
            n = getNum(n);
            if (n == 1) return true;
        }
        return false;
    }

    private int getNum1(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    /** My first solution
     * Complexity O(?), space O(?) */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (set.isEmpty() || !set.contains(n)) {
            int check = n;
            while (check != 0) {
                int mod = check % 10;
                if (mod != 0) break;
                check = check / 10;
            }
            if (check == 1) return true;
            set.add(n);
            n = getNum(n);
        }
        return false;
    }

    private int getNum(int n) {
        int sum = n;
        Stack<Integer> num = new Stack();
        while (sum != 0) {
            num.push(sum % 10);
            sum = sum / 10;
        }
        while (!num.isEmpty()) {
            sum = sum + num.peek() * num.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
//        Day2HappyNumber test = new Day2HappyNumber();
//        test.isHappy(19);

        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> num = new Stack();
        System.out.println(num.peek());
    }
}
