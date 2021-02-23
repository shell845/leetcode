package main.java.swordtooffer;

/**
 * @author YC (shell845)
 * @date 22/4/2020 3:07 PM
 */

public class _67_StringToNumber {
    /** time complexity O(n), space O(1) */
    public int strToInt_improve(String str) {
        if (str == null) return 0;
        char[] arr = str.trim().toCharArray();
        if (arr.length == 0) return 0;
        // check sign
        int sign = 1, start = 0;
        if (arr[0] == '-' || arr[0] == '+') {
            start = 1;
            sign = arr[0] == '-'? -1 : 1;
        }
        // extract number part and convert to integer
        long ans = 0;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] - '0' < 0 || arr[i] - '9' > 0) {
                break;
            } else {
                ans = arr[i] - '0' + ans * 10;
                if (ans > Integer.MAX_VALUE) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return sign * (int) ans;
    }

    public int strToInt_original(String str) {
        if (str == null) return 0;
        char[] arr = str.trim().toCharArray();
        // System.out.println(Arrays.toString(arr));
        // extract number part
        boolean positive = true, numbers = false;
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+' || arr[i] == '-') {
                if (i != 0) break;
                if (arr[i] == '-') positive = false;
                start = 1;
            } else if (arr[i] - '0' < 0 || arr[i] - '9' > 0) {
                if (!numbers) return 0;
                break;
            } else {
                if (!numbers) numbers = true;
                end = i;
            }
        }
        // convert char to number
        long ans = 0;
        if (numbers) {
            for (int i = start; i <= end; i++) {
                System.out.println(arr[i]);
                ans = (arr[i] - '0') + ans * 10;
                if(ans > Integer.MAX_VALUE) return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if (!positive) ans = -ans;
            return (int)ans;
        }
        return 0;
    }
}
