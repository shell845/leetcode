import java.util.regex.Pattern;

/**
 * @author YC 03/26/2020
 */

public class _10_RegularExpressionMatching {
    /** Leetcode solution*/
    public boolean isMatch_recursive(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch_recursive(text, pattern.substring(2)) ||
                    (first_match && isMatch_recursive(text.substring(1), pattern)));
        } else {
            return first_match && isMatch_recursive(text.substring(1), pattern.substring(1));
        }
    }

    /** Have problem, not working */
    public boolean isMatch_textbook(String s, String p) {
        if (s == null || p == null) return false;

        return match(s, 0, p, 0);
    }

    private boolean match(String s, int i, String p, int j) {
        if (i >= s.length() && j >= p.length()) return true;
        if (i < s.length() && j >= p.length()) return false;

        if (j < p.length() - 1 && p.charAt(j + 1) == '*' && i < s.length()) {
            if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                return match(s, i + 1, p, j + 2) || match(s, i + 1, p, j) || match(s, i, p, j + 2);
            } else {
                return match(s, i, p, j + 2);
            }
        }

        if (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
            return match(s, i + 1, p, j + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaa";
        String p = "aaaa";
        //RegularExpressionMatching10 test = new RegularExpressionMatching10();
        //System.out.println(test.isMatch(s, p));
        //System.out.println(Pattern.matches(p, s));
        System.out.println("".length());
    }
}
