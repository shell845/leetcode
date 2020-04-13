import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YC 03/1/2020
 */

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;

        Arrays.sort(nums); // -2, -2, -2, -1, -1, 0, 0, 1, 2, 2
        System.out.println(Arrays.toString(nums));

        // O(n3) solution
        for (int i = 0; i < nums.length - 3; i++) {
            while (i > 0 && nums[i] == nums[i - 1]) {
                if (i == nums.length - 1) break;
                i++;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j > i + 1 && nums[j] == nums[j - 1]) {
                    if (j == nums.length - 1) break;
                    j++;
                }
                int sum;
                for (int k = j + 1, l = nums.length - 1; k < l;) {
                    sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--;
                        while (k < l && nums[l] == nums[l + 1]){
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    } else {
                        result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l])));
                        System.out.println(i + " " + j + " " + k + " " + l);
                        l--;
                        while (k < l && nums[l] == nums[l + 1]){
                            l--;
                        }
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    }
                }
            }
        }

        /** O(n4) solution */
        /*
        for (int i = 0; i < nums.length - 3; i++) {
            while (i > 0 && nums[i] == nums[i - 1]) {
                if (i == nums.length - 1) break;
                i++;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j > i + 1 && nums[j] == nums[j - 1]) {
                    if (j == nums.length - 1) break;
                    j++;
                }
                for (int k = j + 1; k < nums.length - 1; k++) {
                    while (k > j + 1 && k < nums.length && nums[k] == nums[k - 1]) {
                        if (k == nums.length - 1) break;
                        k++;
                    }
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l])));
                            //System.out.println(i + " " + j + " " + k + " " + l);
                        }
                        while (l < nums.length - 2 && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        if ((l == nums.length - 2 && nums[l] == nums[l + 1])) break;
                    }
                }
            }
        } */
        return result;
    }

    public static void main(String[] args) {
        FourSum f = new FourSum();
        List<List<Integer>> result = f.fourSum(new int[] {-1,2,2,-5,0,-1,4}, 3);
        //[0,4,-5,2,-2,4,2,-1,4] 12
        //{5,5,3,5,1,-5,1,-2}, 4
//        [-1,2,2,-5,0,-1,4]
//        3
        System.out.println(Arrays.toString(new List[]{result}));
    }
}
