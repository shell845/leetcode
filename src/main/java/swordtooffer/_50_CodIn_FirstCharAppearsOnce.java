package main.java.swordtooffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author YC 04/14/2020
 */

public class _50_CodIn_FirstCharAppearsOnce {
    /** LinkedHashMap */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            map.put(c[i], map.containsKey(c[i]));
        }

        for (Map.Entry<Character, Boolean> m:map.entrySet()){
            if(!m.getValue()) return m.getKey();
        }

        return ' ';
    }

    // assume strings contains a-z only
    public char firstUniqChar_bruteForce(String s) {
        int[] arr = new int[26];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            arr[c[i] - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[c[i] - 'a'] == 1) return c[i];
        }
        return ' ';
    }
}
