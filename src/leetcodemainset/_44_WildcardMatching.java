package leetcodemainset;

/**
 * @author ych
 * @date 5/5/2020 10:21 PM
 */
public class _44_WildcardMatching {
    private char[] c, pattern;

    public boolean isMatch(String s, String p) {
        if (s == p || s.equals(p)) return true;
        if (s == null || p == null) return false;

        c = s.toCharArray();
        pattern = p.toCharArray();

        return helper(0, 0);
    }

    private boolean helper(int ci, int pi) {
        if (ci >= c.length && pi >= pattern.length) return true;
        if (ci >= c.length) {
            for (int i = pi; i < pattern.length; ++i) {
                if (pattern[i] != '*') return false;
            }
            return true;
        }
        if (pi >= pattern.length) return false;

        if (pattern[pi] == '?' || pattern[pi] == c[ci]) {
            return helper(ci + 1, pi + 1);
        } else if (pattern[pi] == '*') {
            // * is last char in pattern
            for (int i = pi + 1; i < pattern.length; ++i) {
                if (pattern[i] == '*') pi = i;
                else break;
            }
            if (pi == pattern.length - 1) return true;
            // * is not last char in pattern
            for (int i = ci; i < c.length; ++i) {
                if (helper(i, pi + 1)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _44_WildcardMatching test = new _44_WildcardMatching();
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(test.isMatch(s, p));
    }
}
