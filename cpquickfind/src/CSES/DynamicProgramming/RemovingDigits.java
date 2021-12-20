package CSES.DynamicProgramming;

import CSES.FastReader;

public class RemovingDigits {
    static int[] dp;
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n  = fs.nextInt();
        dp = new int[n+1];
        for(int i=1;i<Math.min(10,n+1);i++) dp[i] = 1;
        for(int i=10;i<=n;i++) {
            int temp = i;
            int res = Integer.MAX_VALUE;
            while(temp>0) {
                if(temp%10!=0) res = Math.min(res, dp[i-temp%10]+1);
                temp/=10;
            }
            dp[i] = res;
        }
        System.out.println(dp[n]);
    } 
}
