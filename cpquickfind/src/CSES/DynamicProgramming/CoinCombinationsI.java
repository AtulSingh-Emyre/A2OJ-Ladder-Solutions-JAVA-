package CSES.DynamicProgramming;

import java.util.Arrays;

import CSES.FastReader;

public class CoinCombinationsI {
    static int[] dp;
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n  = fs.nextInt();
        int x = fs.nextInt();
        int[] coins = fs.nextintArr(n, fs);
        dp = new int[x+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        for(int i=1;i<=x;i++) {
            int curr = 0;
            for(int c: coins) {
                if(i-c>=0 && dp[i-c]!= -1) curr+= dp[i-c];
            }
            if(curr>0) dp[i] = curr;
        }
        System.out.println(dp[x]);
    } 
}
