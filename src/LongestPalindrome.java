import java.util.HashMap;
import java.util.Map;

/**
 * @author YC 03/12/2020
 */

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        Map<String, Integer> lookup = new HashMap<>();
        System.out.println(LP(s, 0, s.length() - 1, lookup));
        return null;
        /** Recursion + Dynamic Programming O(n2) */
//        HashMap<String, Integer> map = new HashMap<>();
//        int max = findLP(s, 0, s.length() - 1, map);
//        if (max == 1) {
//            return s.substring(0, 1);
//        }
//        int i = 0, j = s.length() - 1;
//        for (String k:map.keySet()) {
//            if (map.get(k) == max) {
//                int p = Character.getNumericValue(k.charAt(0));
//                int q = Character.getNumericValue(k.charAt(2));
//                if (q - p < j - i) {
//                    i = p;
//                    j = q;
//                }
//            }
//        }
//        return s.substring(i, j + 1);

        /** Brute Force O(n3) */
        /*if (s.length() == 0) return null;
        int ansS = 0, ansE = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                int str = i;
                int end = j;
                while (str < end) {
                    if (s.charAt(str) != s.charAt(end)) break;
                    str++;
                    end--;
                }
                if ((str == end || str > end) && (j - i > ansE - ansS)) {
                    ansS = i;
                    ansE = j;
                    i = (i + j) / 2 - 1;
                }
            }
        }
        return s.substring(ansS, ansE + 1);*/
    }

    public static int LP(String X, int i, int j,
                                        Map<String, Integer> lookup)
    {
        // base condition
        if (i > j) {
            return 0;
        }

        // if String X has only one character, it is palindrome
        if (i == j) {
            return 1;
        }

        // construct an unique map key from dynamic elements of the input
        String key = i + "|" + j;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
			/* if last character of the string is same as the first character
			include first and last characters in palindrome and recur
			for the remaining subString X[i+1, j-1] */

            if (X.charAt(i) == X.charAt(j)) {
                lookup.put(key, LP(X, i + 1, j - 1, lookup) + 2);
            }
            else {

			/* if last character of string is different to the first character

			1. Remove last char & recur for the remaining subString X[i, j-1]
			2. Remove first char & recur for the remaining subString X[i+1, j]
			3. Return maximum of the two values */

                lookup.put(key, Integer.max(LP(X, i, j - 1, lookup),
                        LP(X, i + 1, j, lookup)));
            }
        }

        // return the sub-problem solution from the map
        return lookup.get(key);
    }

    /*private int findLP(String s, int i, int j, HashMap map) {
        if (i > j) return 0;
        if (i == j) return 1;
        String key = i + "-" + j;
        if (!map.containsKey(key)) {
            if (s.charAt(i) == s.charAt(j)) {
                map.put(key, findLP(s, i + 1, j - 1, map) + 2);
            } else {
                map.put(key, Integer.max(findLP(s, i + 1, j, map), findLP(s, i, j - 1, map)));
            }
        }
//        System.out.println(key);
        System.out.println(map.get(key));
        return (int) map.get(key);
    }*/

    public static void main(String[] args) {
        String s = "abcda";
        LongestPalindrome lp = new LongestPalindrome();
        String ans = lp.longestPalindrome(s);
        System.out.println(ans);
    }

}
