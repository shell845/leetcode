package leetcodemainset;

/**
 * @author YC 03/12/2020
 */

public class RomanToInt {
    public int romanToInt(String s) {
        /** Solution 2*/
        int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;

        int ans = 0, n = s.length() - 1, last = -1, current = -1;
        while (n >= 0) {
            current = map[s.charAt(n) - 'A'];
            if (current >= last) {
                ans = ans + current;
            } else {
                ans = ans - current;
            }
            last = current;
            n--;
        }

        return ans;

        /** Solution 1*/
        /*Map<Character, Integer> map = Map.ofEntries(
                entry('I', 1),
                entry('V', 5),
                entry('X', 10),
                entry('L', 50),
                entry('C', 100),
                entry('D', 500),
                entry('M', 1000)
        );

        int ans = 0, i = 0;
        while (i < s.length()) {
            if (!map.containsKey(s.charAt(i))) throw new IllegalArgumentException();
            if ((i < s.length() - 1) && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans = ans + map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i++;
            } else {
                ans = ans + map.get(s.charAt(i));
            }
            i++;
        }
        return ans;*/
    }

    public static void main(String[] args) {
        RomanToInt r = new RomanToInt();
        int ans = r.romanToInt("III");
        System.out.println(ans);
    }
}
