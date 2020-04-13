import java.util.Arrays;

/**
 * @author YC 03/06/2020
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        /* Method 2*/
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else i++;
        }
        return n;

        /* Method 1
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;*/
    }

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        int[] n = new int[] {0,1,2,2,3,0,4,2};
        int result = r.removeElement(n, 2);
        System.out.println(result + " " + Arrays.toString(n));
    }
}
