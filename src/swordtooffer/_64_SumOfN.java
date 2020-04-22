package swordtooffer;

/**
 * @author YC (shell845)
 * @date 22/4/2020 11:34 AM
 */

public class _64_SumOfN {
    /** time complexity O(n), space O(n)
     * bitwise short circuit:
     * - if(A && B) // if A is false, B will not be executed
     * - A || B // if A is true, B will not be executed */
    int ans = 0;
    public int sumNums(int n) {
        boolean check = n > 1 && sumNums(n - 1) > 0;
        ans += n;
        return ans;
    }

    /** bitwise operation for [(1 + n) * n / 2] */
    public int sumNums_2(int n) {
        return
                ((((n+1)&(0-((n>>>13)&1)))<<13)+
                        (((n+1)&(0-((n>>>12)&1)))<<12)+
                        (((n+1)&(0-((n>>>11)&1)))<<11)+
                        (((n+1)&(0-((n>>>10)&1)))<<10)+
                        (((n+1)&(0-((n>>>9)&1)))<<9)+
                        (((n+1)&(0-((n>>>8)&1)))<<8)+
                        (((n+1)&(0-((n>>>7)&1)))<<7)+
                        (((n+1)&(0-((n>>>6)&1)))<<6)+
                        (((n+1)&(0-((n>>>5)&1)))<<5)+
                        (((n+1)&(0-((n>>>4)&1)))<<4)+
                        (((n+1)&(0-((n>>>3)&1)))<<3)+
                        (((n+1)&(0-((n>>>2)&1)))<<2)+
                        (((n+1)&(0-((n>>>1)&1)))<<1)+
                        ((n+1)&(0-(n&1))))>>>1;
    }

    public static void main(String[] args) {
        _64_SumOfN test = new _64_SumOfN();
        test.sumNums_2(3);
    }
}
