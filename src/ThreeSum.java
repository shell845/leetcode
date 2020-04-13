/**
 * @author YC 03/06/2020
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class ThreeSum {
    public List threeSum(int[] nums) {
        /* Two pointer solution - no extra space except result */
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int sum;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
            return result;

        /* HashMap solution - use extra space O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = - (nums[i] + nums[j]);
                if (map.containsKey(sum) && map.get(sum) > j) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(sum);
                    result.add(triplet);
                }
            }
        }

        return result;*/
    }

    public static void main(String[] args) {
        int[] n = {-1, 0, 1, 2, -1, -4};
        ThreeSum tS = new ThreeSum();
        List<List<Integer>> result = tS.threeSum(n);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
