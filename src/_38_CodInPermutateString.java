import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author YC 04/03/2020
 */

public class _38_CodInPermutateString {
    HashSet<String> set;
    char[] c;

    /** Complexity O(n!), space (n^2) */
    public String[] permutation(String s) {
        c = s.toCharArray();
        set = new HashSet<>();
        dfs(0);
        return set.toArray(new String[set.size()]);
    }

    private void dfs(int pos) {
        if (pos == c.length - 1) {
            set.add(String.valueOf(c));
            return;
        }

        HashSet<Character> cs = new HashSet<>();
        for (int i = pos; i < c.length; i++) {
            if (cs.contains(c[i])) continue;  // duplicate records
            cs.add(c[i]);
            swap(i, pos);
            dfs(pos + 1);
            swap(i, pos);
        }
    }

    private void swap(int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }


}
