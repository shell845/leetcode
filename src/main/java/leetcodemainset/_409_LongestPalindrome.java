package main.java.leetcodemainset;

/**
 * @author YC 03/19/2020
 */

public class _409_LongestPalindrome {
    public int longestPalindrome(String s) {
        /** Solution 2 - Complexity O(n) Space O(n)*/
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;

        /** Solution 1 - Complexity O(n) Space O(n)*/
        /** Not Good */
        /*if (s == null || s.length() == 0 || s.trim().length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.replace(c, map.get(c) + 1);
            }
        }

        char temp = ' ';
        int len = 0;
        for (char c : map.keySet()) {
            int count = map.get(c) / 2;
            len = len + count * 2;
            if (map.get(c) % 2 == 1) {
                temp = c;
            }
        }
        if (temp != ' ') len = len + 1;
        return len; */
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        _409_LongestPalindrome LP = new _409_LongestPalindrome();
        LP.longestPalindrome(s);
    }
}
