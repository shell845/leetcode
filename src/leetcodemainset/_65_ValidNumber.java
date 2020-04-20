package leetcodemainset;

/**
 * @author YC 03/27/2020
 */

public class _65_ValidNumber {
    /** Solution A
     * /*
     * 核心: 有效数字的模式只有两种:
     * 1)A[.[B]][e|EC]  比如: +100   -67.0  29.    3.14E5
     * 2).B[e|EC]       比如: .3     .4E6
     * 其中,A、C是整数，B是正整数; [e|EC]表示[eC]或者[EC]
     * 原则: 有A的话,有没有B都可以; 没有A的话, 必须有B
     * */

    /** Solution B: enum */
    public boolean isNumber(String str) {
        boolean eExist = false;
        boolean dotExist = false;
        boolean numExist = false;

        String s = str.trim();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                numExist = true;
            } else if (s.charAt(i) == '.') {
                // can only have one . & . cannot exist after e|E
                if (dotExist || eExist) return false;
                dotExist = true;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                // can only have one e|E & it should behind number
                if (eExist || !numExist) return false;
                eExist = true;
                numExist = false; // in case 123e / 123e+
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                // sign should only be at 0 or after e
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else return false;
        }
        return numExist;
    }

    /** Solution C
     * Incorrect */
    // [[Sign]Integer[e|E[Sign]Integer]][.[Integer]][e|E[Sign]Integer]
    public boolean isNumber_incorrect(String str) {
        if (str == null || str.trim().isEmpty()) return false;

        String s = str.trim();

        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return isInteger(s, 1, false);
        } else if (Character.isDigit(s.charAt(0))) {
            return isInteger(s, 1, true);
        } else if (s.charAt(0) == '.') {
            return isFraction(s, 1, false);
        } else return false;
    }

    private boolean isInteger(String s, int index, boolean preIsDigit) {
        if (index == s.length()) return preIsDigit;

        if (Character.isDigit(s.charAt(index))) {
            return isInteger(s, index + 1, true);
        } else if (s.charAt(index) == '.') {
            return isFraction(s, index + 1, false);
        } else if (preIsDigit && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            return isE(s, index + 1, false);
        } else return false;
    }

    private boolean isFraction(String s, int index, boolean preIsDigit) {
        if (index == s.length()) {
            if (preIsDigit) return true;
            if (s.length() > 1 && s.charAt(index - 1) == '.' && Character.isDigit(s.charAt(index - 2))) return true;
            //if (s.equals(".")) return true;
            return false;
        }

        if (Character.isDigit(s.charAt(index))) {
            return isFraction(s, index + 1, true);
        } else if (preIsDigit && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            return isE(s, index + 1, false);
        } else return false;
    }

    private boolean isE(String s, int index, boolean preIsDigit) {
        if (index == s.length()) return preIsDigit;

        if (Character.isDigit(s.charAt(index))) {
            return isE(s, index + 1, true);
        } else if ((s.charAt(index - 1) == 'e' || s.charAt(index - 1) == 'E') && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            return isE(s, index + 1, false);
        } else return false;

    }

    public static void main(String[] args) {
        String s = " 9";
        s = s.trim();
        s.equals(".");

        System.out.println(Character.isDigit(s.charAt(0)));
    }
}
