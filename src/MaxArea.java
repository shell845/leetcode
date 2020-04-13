/**
 * @author YC 03/06/2020
 */

public class MaxArea {
    public int maxArea(int[] height) {
        /* Solution 3 */
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[r], height[l]));
            if (height[r] < height[l]) {
                r--;
            } else l++;
        }
        return max;

        /* Solution 2
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                if (j != height.length - 1 && height[j] < height[j + 1]) continue;
                if ((j - i) * Math.min(height[i], height[j]) > max) {
                    max = (j - i) * Math.min(height[i], height[j]);
                }
            }
        }
        return max;*/


        /* Solution 1
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if ((j - i) * Math.min(height[i], height[j]) > max) {
                    max = (j - i) * Math.min(height[i], height[j]);
                }
            }
        }
        return max;
        */
    }

    public static void main(String[] args) {
        MaxArea m = new MaxArea();
        int[] n = {1,8,6,2,5,4,8,3,7}; // 49
        int[] n1 = {2,3,4,5,18,17,6}; //17
        int[] n2 = {5,2,12,1,5,3,4,11,9,4}; //55
        System.out.println(m.maxArea(n2));
    }
}
