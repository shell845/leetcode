package leetcodemainset;

import java.util.*;

/**
 * @author YC (shell845)
 * @date 29/4/2020 8:52 PM
 */

public class _1424_DiagonalTraverseII {
    public int[] findDiagonalOrder_2(List<List<Integer>> nums) {
        int count = 0;
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (map.containsKey(i + j)) {
                    map.get(i + j).add(nums.get(i).get(j));
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums.get(i).get(j));
                    map.put(i + j, list);
                }
            }
        }

        int[] ans = new int[count];
        int index = 0;
        for(int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for(int j = list.size() - 1; j >= 0; j--) {
                ans[index] = list.get(j);
                index++;
            }
        }
        return ans;
    }

    /** Accepted */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        int row = nums.size(), col = 0;
        for (int i = 0; i < nums.size(); i++) {
            int temp = nums.get(i).size();
            if (temp > col) col = temp;
            count += temp;
        }

        int[] ans = new int[count];
        int index = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, nums.get(0).get(0)});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            ans[index] = temp[2];
            index++;
            nums.get(temp[0]).set(temp[1], 0);
            if (temp[0] < row - 1 && nums.get(temp[0] + 1).size() > temp[1]){
                if (nums.get(temp[0] + 1).get(temp[1]) != 0) {
                    queue.add(new int[]{temp[0] + 1, temp[1], nums.get(temp[0] + 1).get(temp[1])});
                    nums.get(temp[0] + 1).set(temp[1], 0);
                }
            }
            if (temp[1] < nums.get(temp[0]).size() - 1) {
                if (nums.get(temp[0]).get(temp[1]  + 1) != 0) {
                    queue.add(new int[]{temp[0], temp[1] + 1, nums.get(temp[0]).get(temp[1] + 1)});
                    nums.get(temp[0]).set(temp[1] + 1, 0);
                }
            }
        }

        return ans;
    }
}
