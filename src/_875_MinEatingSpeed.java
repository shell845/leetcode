/**
 * @author YC 03/21/2020
 */

public class _875_MinEatingSpeed {
    /** Complexity O(NlogW), space O(1) */
    public int minEatingSpeed(int[] piles, int H) {
        if (piles == null || H == 0 || piles.length == 0) return -1;
        int max = -1;
        int sum = 0;
        for (int i:piles) {
            max = Math.max(i, max);
            sum = sum + i;
        }
        int min = Math.max(1, sum / H);

        while (min <= max) {
            int mid = (min + max) / 2;
            int time = 0;
            for (int p:piles) {
                time = time + (p - 1) / mid + 1;
            }
            if (time > H) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] piles = new int[] {30,11,23,4,20};
        _875_MinEatingSpeed m = new _875_MinEatingSpeed();
        int K = m.minEatingSpeed(piles, 6);
        System.out.println(K);
    }
}
