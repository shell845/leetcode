package main.java.leetcodemainset;

import java.util.*;

/**
 * @author YC 03/11/2020
 */

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring_2Pointer(String s) {
        if(s == null || s.length() < 1)
            return 0;
        int[] arr = new int[130];//保存每个字母出现的位置，默认为-1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        //定义上一个长度f(i-1)与当前长度f(n)
        int pre = 0, cur = 0;
        int res = 0;//返回最大长度
        int index = 0;
        //遍历s
        for (int i = 0; i < s.length(); i++) {
            //计算当前字母对应的位置
            index = s.charAt(i);
            //如果没有出现或者距离比当前的大，+1
            if (arr[index] < 0 || i - arr[index] > cur){
                cur = pre + 1;
                //更新最大
                res = Math.max(res,cur);
            }else {
                //出现过了，当前长度减少
                cur = i - arr[index];
            }
            //更新字符出现位置
            arr[index] = i;
            //更新pre
            pre = cur;
        }
        return res;
    }

    /** complexity O(n), space O(n) */
    public int lengthOfLongestSubstring_map(String s) {
        if (s == null || s.length() == 0) return 0;

        int maxSize = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                maxSize = Math.max(maxSize, i - start);
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, i);
        }
        maxSize = Math.max(maxSize, s.length() - start);
        return maxSize;
    }

    /** complexity O(n^2), space O(n) */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (set.contains(s.charAt(j))) {
                // repeat char
                ans = Math.max(j - i, ans);
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
            }
        }
        ans = Math.max(j - i, ans);
        return ans;

        /* Solution 1
        if (s.length() == 0) return 0;
        // 1p 2w 3w 4k 5e 6w
        char[] c = s.toCharArray();
        HashMap<Character, Integer> subString = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < c.length; i++) {
            //System.out.println("i " + i + " " + c[i]);
            subString.put(c[i], i);
            for (int j = i + 1; j < c.length; j++) {
                //System.out.println("j " + j + " " + c[j]);
                if (subString.containsKey(c[j])) {
                    // find repeat char
                    if (subString.size() > maxLen) {
                        maxLen = subString.size();
                    }
                    i = subString.get(c[j]);
                    subString.clear();
                    break;
                } else {
                    subString.put(c[j], j);
                }
            }
        }
        if (subString.size() > maxLen) {
            maxLen = subString.size();
        }

        return maxLen;*/
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring los = new LengthOfLongestSubstring();
        System.out.println(los.lengthOfLongestSubstring(s));
    }
}
