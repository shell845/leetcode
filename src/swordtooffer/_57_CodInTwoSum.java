package swordtooffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author YC (shell845)
 * @date 17/4/2020 1:03 PM
 */

public class _57_CodInTwoSum {
    /**对于目标target，若其为连续m个整数之和，则存在起始数x，有：
     x + (x + 1) + ... + (x + m - 1) == target => m * x + m * (m - 1) / 2 == target
     根据这个等式，遍历m，找到符合的x即可获得相关序列*/
    public int[][] findContinuousSequence_math(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1;

        while(target > 0)
        {
            target -= i++;
            if(target > 0 && target % i == 0)
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }

    /** sliding window
     * time complexity O(target), space O(1) */
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int i = 1, j = 2, sum = 3;
        while (i < (target + 1) / 2) {
            if (sum == target) {
                //find
                int[] sol = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    sol[k - i] = i;
                    i++;
                }
                ans.add(sol);
                sum -= i;
                i++;
            } else if (sum < target) {
                j++;
                sum += j;
            } else {
                sum -= i;
                i++;
            }
        }
        for (int[] in:ans) {
            System.out.println(Arrays.toString(in));
        }
        return ans.toArray(new int[ans.size()][]);
    }

    /** time complexity O(n), space O(1) */
    public int[] twoSum_I_2(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums == null) return ans;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                ans[0] = nums[i];
                ans[1] = nums[j];
                return ans;
            } else if (sum < target) {
                i++;
            } else j--;
        }
        return ans;
    }

    public int[] twoSum_I_1(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums == null) return ans;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    ans[0] = nums[i];
                    ans[1] = nums[j];
                    return ans;
                } else if (sum < target) {
                    break;
                } else {
                    continue;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _57_CodInTwoSum test = new _57_CodInTwoSum();
        test.findContinuousSequence(9);
    }
}
