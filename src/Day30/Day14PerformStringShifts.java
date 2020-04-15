package Day30;

/**
 * @author YC (shell845)
 * @date 15/4/2020 10:28 AM
 */

public class Day14PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        StringBuilder sb = new StringBuilder(s);
        boolean left = false;
        int len = s.length();
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) left = true;
            else left = false;
            int offset = shift[i][1] % len;
            String a = "";
            String b = "";
            if (left) {
                a = sb.substring(0, offset);
                b = sb.substring(offset);
                // System.out.println(a);
                // System.out.println(b);
            } else {
                a = sb.substring(0, len - offset);
                b = sb.substring(len - offset);
                // System.out.println(a);
                // System.out.println(b);
            }
            sb = new StringBuilder(b + a);
        }
        return sb.toString();
    }
}
