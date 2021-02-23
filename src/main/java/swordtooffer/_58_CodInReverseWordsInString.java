package main.java.swordtooffer;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author YC (shell845)
 * @date 18/4/2020 11:59 AM
 */

public class _58_CodInReverseWordsInString {
    /** use % to simplify code */
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    /** use string slicing */
    public String reverseLeftWords_II(String s, int n) {
        if (s == null) return null;
        String ans = s.substring(n) + s.substring(0, n);
        return ans;
    }

    public String reverseWords_I(String s) {
        if (s == null) return null;
        String str = s.trim();
        int i = str.length() - 1, j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && str.charAt(i) != ' ') i--;
            sb.append(str.substring(i + 1, j + 1) + " ");
            while (i >= 0 && str.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }

    /** not recommend for interview */
    public String reverseWords_javaBuildInFunction(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public String reverseWords_I_mySol(String s) {
        if (s == null) return null;
        String[] arr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals("")) continue;
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
