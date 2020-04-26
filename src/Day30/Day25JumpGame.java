package Day30;

/**
 * @author ych
 * @date 26/4/2020 1:02 PM
 */
public class Day25JumpGame {
    /** time complexity O(N), space O(1)
     * backtracking */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int last = nums.length - 1, step = 1;
        for (int i = last - 1; i >= 0; i--) {
            if (nums[i] < step) {
                step++;
            } else {
                step = 1;
            }
        }
        return step == 1;
    }
}
