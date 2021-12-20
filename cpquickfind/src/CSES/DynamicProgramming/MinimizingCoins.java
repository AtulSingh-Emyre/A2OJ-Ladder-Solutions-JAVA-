package CSES.DynamicProgramming;

import java.util.Arrays;

import CSES.FastReader;

public class MinimizingCoins {
    static int[] dp;
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int tar = fs.nextInt();
        int[] coins = fs.nextintArr(n, fs);
        dp = new int[tar+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=1;i<dp.length;i++) {
            int curr = Integer.MAX_VALUE;
            for(int c: coins) {
                if(i-c>=0) {
                    if(dp[i-c] != -1) curr = Math.min(curr, dp[i-c]+1);
                }
            }
            if(curr == Integer.MAX_VALUE) continue;
            dp[i] = curr;
        }
        System.out.println(dp[tar]);
    }
}
