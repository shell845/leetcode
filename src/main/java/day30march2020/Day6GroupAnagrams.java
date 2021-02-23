/**
 * @author YC 04/07/2020
 */

package main.java.day30march2020;

import java.util.*;

public class Day6GroupAnagrams {
    /** use products of prime numbers to hash
     * will overflow if string too long*/
    public List<List<String>> groupAnagrams_prime(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();

        HashMap<Integer, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int[] primes = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101
        };

        for (String s : strs) {
            int score = score(s, primes);
            List<String> list = map.get(score);
            if (list == null){
                list = new ArrayList<>();
                map.put(score, list);
                res.add(list);
            }
            list.add(s);
        }
        return res;
    }

    private int score(String s, int[] primes) {
        int score = 1;
        for (char c : s.toCharArray()){
            score *= primes[c-'a'];
        }
        return score;
    }

    /** Complexity O(nm), space O(n) */
    public List<List<String>> groupAnagrams_stringHash(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str:strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>(Collections.singleton(str)));
            }
        }
        return new ArrayList<>(map.values());
    }

    /** Complexity O(nm), space O(n)
     * will overflow if string too long */
    public List<List<String>> groupAnagrams_intHash(String[] strs) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (String str:strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            System.out.println(Arrays.toString(c));
            int h = 0;
            for (int i = 0; i < c.length; i++) {
                h = c[i] + h * 26;
            }
            if (map.containsKey(h)) {
                map.get(h).add(str);
                System.out.println("add " + h + " " + str);
            } else {
                map.put(h, new ArrayList<>(Collections.singleton(str)));
                System.out.println("new " + h + " " + str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Day6GroupAnagrams test = new Day6GroupAnagrams();
        test.groupAnagrams_intHash(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
