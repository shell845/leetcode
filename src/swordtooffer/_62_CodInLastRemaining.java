package swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ych
 * @date 21/4/2020 11:52 AM
 */
public class _62_CodInLastRemaining {
    /** time complexity O(n), space O(1) */
    public int lastRemaining_math(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    /** time complexity O(nm), space O(n) */
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
