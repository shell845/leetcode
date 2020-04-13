import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author YC 03/19/2020
 */

public class _05_CodInReplaceSpace {
    public String replaceSpaceString(String s) {
        if (s == null || s.length() == 0) return "";
        s = s.replaceAll("\\s", "%20");
        return s;
    }

    public char[] replaceSpaceChar(char[] c) {
        int count = 0;
        for (char i:c) {
            if (Character.isSpaceChar(i)) count++;
        }
        char[] cc = new char[c.length + count];

        int j = cc.length - 1;
        boolean space = false;
        for (int i = c.length - 1; i >= 0; i--) {
            // have problem when continues multi space because the count above didn't filter continues case
            while (i >= 0 && Character.isSpaceChar(c[i])) {
                space = true;
                i--;
            }
            if (space && j > 1) {
                cc[j] = '2';
                cc[j - 1] = '%';
                j = j - 2;
                space = false;
            }
            cc[j] = c[i];
            j--;
        }
        return cc;
    }

    public static void main(String[] args) {
        String s = "We are   happy.";
        _05_CodInReplaceSpace c = new _05_CodInReplaceSpace();
        System.out.println(c.replaceSpaceString(s));

        StringBuilder sb = new StringBuilder();

        char[] cc = s.toCharArray();
        System.out.println(Arrays.toString(new int[1]));

    }
}
