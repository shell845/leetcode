/**
 * @author YC 04/10/2020
 */

public class _46_CodInTranslateNum {

    /** recursion, start from right
     * time complexity O(n), space O(1) */
    public int translateNum(int num) {
        if (num < 10) return 1;

        int last = num % 100;
        if (last < 26 && last > 9) return translateNum(num/10) + translateNum(num/100);
        else return translateNum(num/10);
    }

    /** recursion, start from left
     * time complexity O(2^n), space O(n) */
    private int count = 0;

    public int translateNum_(int num) {
        char[] c = String.valueOf(num).toCharArray();
        translate(c, 0);
        return count;
    }

    private void translate(char[] c, int i) {
        if (i >= c.length) { count++; return; }

        translate(c, i + 1);
        if (i < c.length - 1 && c[i] != '0' && Integer.parseInt("" + c[i] + c[i + 1]) < 26) {
            translate(c, i + 2);
        }
    }

    public static void main(String[] args) {
        // 12258 ans: 5
        _46_CodInTranslateNum test = new _46_CodInTranslateNum();
        System.out.println(test.translateNum(506));
    }
}
