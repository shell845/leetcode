package main.java.day30march2020;

import java.util.*;

/**
 * @author YC (shell845)
 * @date 28/4/2020 11:37 PM
 */

public class Day28FirstUniqueNumber {
    Set<Integer> set;
    Set<Integer> all;

    /** time complexity O(N) */
    public Day28FirstUniqueNumber(int[] nums) {
        set = new LinkedHashSet<>();
        all = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(!all.contains(nums[i]))
            {
                all.add(nums[i]);
                set.add(nums[i]);
            }
            else
            {
                if(set.contains(nums[i]))
                    set.remove(nums[i]);
            }
        }
    }

    /** time complexity O(1) */
    public int showFirstUnique() {
        if(set.size()==0)
            return -1;
        return set.iterator().next();
    }

    /** time complexity O(1) */
    public void add(int value) {
        if(!all.contains(value))
        {
            all.add(value);
            set.add(value);
        }
        else
        {
            if(set.contains(value))
                set.remove(value);
        }
    }

    /** LinkedList + Set + index
     * Time Limit Exceed */
//    LinkedList<Integer> list = new LinkedList<>();
//    Map<Integer, Boolean> map = new HashMap<>();
//    int index = 0;
//
//    /** time complexity O(N) */
//    public FirstUnique(int[] nums) {
//        if (nums == null) return;
//        for (int i : nums) {
//            if (!map.isEmpty() && map.containsKey(i)) {
//                map.put(i, false);
//            } else {
//                list.add(i);
//                map.put(i, true);
//            }
//        }
//    }
//
//    /** time complexity O(N) */
//    public int showFirstUnique() {
//        if (map.isEmpty() || list.isEmpty()) return -1;
//        int size = list.size();
//        while (index < size) {
//            if(map.get(list.get(index))) return list.get(index);
//            index++;
//        }
//        return -1;
//    }
//
//    /** time complexity O(1) */
//    public void add(int value) {
//        if (!map.isEmpty() && map.containsKey(value)) {
//            map.put(value, false);
//        } else {
//            list.add(value);
//            map.put(value, true);
//        }
//    }

    /** LinkedList + Set
     * Time Limit Exceed */
//    LinkedList<Integer> list = new LinkedList<>();
//    Set<Integer> set = new HashSet<>();
//
//    /** time complexity O(N^2) */
//    public Day28FirstUniqueNumber(int[] nums) {
//        if (nums == null) return;
//        for (int i : nums) {
//            if (!set.isEmpty() && set.contains(i)) {
//                if (!list.isEmpty() && list.contains(i)) list.remove((Integer) i);
//            } else {
//                set.add(i);
//                list.add(i);
//            }
//        }
//    }
//
//    /** time complexity O(1) */
//    public int showFirstUnique() {
//        if (list.isEmpty()) return -1;
//        return list.getFirst();
//    }
//
//    /** time complexity O(N) */
//    public void add(int value) {
//        if (!set.isEmpty() && set.contains(value)) {
//            if (!list.isEmpty() && list.contains(value)) {
//                list.remove((Integer) value);
//            }
//        } else {
//            set.add(value);
//            list.add(value);
//        }
//    }

    public static void main(String[] args) {
        Day28FirstUniqueNumber test = new Day28FirstUniqueNumber(new int[]{7,7,7,7,7,7});
        System.out.println(test.showFirstUnique());
        test.add(7);
        test.add(3);
        test.add(3);
        test.add(7);
        test.add(17);
        System.out.println(test.showFirstUnique());
    }
}
