package main.java.leetcodemainset;

/**
 * @author ych
 * @date 9/2/2021 12:00 AM
 */
import java.util.*;

public class _76_MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // s and t consist of English letters
        // s: ADOBECODEBANC
        // t: ABC
        // output: BANC
        // *** think: any duplicate char in t? ***
        if (s == null || t == null || t.length() > s.length()) return "";
        if (s.equals(t)) return s;

        Map<Character, Integer> pool = new HashMap<>(); // t_char pool
        for (char c : t.toCharArray()) pool.put(c, pool.getOrDefault(c, 0) + 1);
        System.out.println("pool size " + pool.size());
        Map<Character, Integer> window = new HashMap<>(); // record t_char in s

        int left = 0, right = 0, valid = 0;// valid to check char + char count
        int[] answer = new int[]{-1, -1}; // -1 for not found

        while (right < s.length()) {
            char c = s.charAt(right);

            if (pool.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                System.out.println("window.get(c) = " + window.get(c) + " pool.get(c) = " + pool.get(c));
                if (window.get(c).equals(pool.get(c))) { // use equals because Integer
                    valid++; // count found char, note the

                }
            }

            while (valid == pool.size() && left <= right) { // find a substring
                if (answer[0] < 0 || answer[1] - answer[0] > right - left) {
                    answer[0] = left;
                    answer[1] = right;
                    System.out.println(answer[0] + " " + answer[1]);
                }
                // shrink window
                char r = s.charAt(left); // char to be removed
                if (pool.containsKey(r)) { // valid status may change
                    if (window.get(r) > 1) {
                        window.put(r, window.get(r) - 1);
                        if (window.get(r) < pool.get(r)) valid--;
                    }
                    else {
                        window.remove(r);
                        valid--;
                    }
                }
                left++;
            }

            right++;
        }

        return answer[0] < 0 ? "" : s.substring(answer[0], answer[1] + 1);
    }

    public static void main(String args[]) {
        String s = "hi", t = "hello";
        System.out.println(s.length() + " " + t.length());
        minWindow(s, t);
    }
}
