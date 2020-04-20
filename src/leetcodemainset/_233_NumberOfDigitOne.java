package leetcodemainset;

/**
 * @author YC 04/08/2020
 */

public class _233_NumberOfDigitOne {
    //traverse each digit of n, if n=3401512
    //for m=100, split n into a=34015 and b=12
    //if a%10==1, #1=a/10*m+(b+1);
    //if a%10==0, #2=a/10*m;
    //if a%10>1; #3=a/10*m+m;
    //In general, #4=(a+8)/10*m+(a % 10 == 1)*(b + 1).
    //For general expression above:
    //if a%10>1, then (a+8)/10=a/10+1, #4=#3
    //if a%10==0, (a+8)/10=a/10, (a % 10 == 1)=false, #4=#2
    //if a%10==1, (a+8)/10=a/10, (a % 10 == 1)=true, #4=#1
    //This is how "(a+8)/10*m+(a % 10 == 1)*(b + 1)" covers all three conditions.
    public int countDigitOne_StefanPochmann(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;
    }

    /** start from least significant digit
     *  O(logn) */
    public int countDigitOne_fromLeastSignificantDigit(int n) {
        int count = 0;
        long i = 1; // start from single digit
        while (n > 0 & n / i != 0) {
            long current = n / i % 10;
            long high = n / (i * 10);
            long low = n - n / i * i;
            if (current == 0) {
                count += high * i;
            } else if (current == 1) {
                count += high * i + low + 1;
            } else {
                count += (high + 1) * i;
            }
            i *= 10;
        }
        return count;
    }

    /** Start form most Significant Digit
     * O(logn) */
    private int count = 0;
    public int countDigitOne(int n) {
        recursive(n);
        return count;
    }

    private void recursive(int n) {
        if (n <= 0) return;
        if (n < 10) {
            count += 1;
            return;
        }

        String s = String.valueOf(n);
        String sub = s.substring(1); // remove most significant digit as a sub group
        int m = Integer.parseInt(sub) + 1; // first num in current group

        int mostSigDig = Character.getNumericValue(s.charAt(0));
        // count 1 in most significant digit
        if (mostSigDig <= 1) {
            count += m;
        } else count += Math.pow(10, s.length() - 1);

        // count 1 in remaining part m
        count += mostSigDig
                * (s.length() - 1)
                * Math.pow(10, s.length() - 2);
        // count sub group 1 ~ m - 1
        recursive(m - 1);
    }

    /** Time Limit Exceeded
     * Complexity O(nlogn) ? space O(1) */
    public int countDigitOne_bruteForce(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j != 0) {
                if (j % 10 == 1) count++;
                j = j / 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _233_NumberOfDigitOne test = new _233_NumberOfDigitOne();
         System.out.println(test.countDigitOne_fromLeastSignificantDigit(1410065408)); // 21345 answer = 18821
         System.out.println(test.countDigitOne(1410065408)); // 1410065408 answer = 1737167499
    }
}
