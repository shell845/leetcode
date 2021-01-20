/**
 * @author YC 04/10/2020
 */

package day30march2020;

public class Day9BackspaceStringCompare {
    /** Time complexity O(n), space O(1) */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            // find non-'#' in S
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            // find non-'#' in T
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            // check if the same
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            // check if comparing non empty string with empty string
            if ((i >= 0) != (j >= 0)) return false;
            i--;
            j--;
        }
        return true;
    }

    /** Time complexity O(n), space O(n) */
    public boolean backspaceCompare_sb(String S, String T) {
        return processor(S).compareTo(processor(T)) == 0;
    }

    private String processor(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() - 1 >= 0) sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Day9BackspaceStringCompare test = new Day9BackspaceStringCompare();
        System.out.println(test.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
