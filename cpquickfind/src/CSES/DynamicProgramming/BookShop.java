package CSES.DynamicProgramming;
// Knapsack

import java.util.Arrays;

import CSES.FastReader;

public class BookShop {
    static int[][] dp;
    public static int solve(int i, int n, int W, int[] wt, int[] p) {
        if(W == 0 || i == -1) return 0;
        if(dp[i][W] != -1) return dp[i][W];
        if(wt[i]<=W) {
            return dp[i][W] = Math.max(solve(i-1,n,W-wt[i],wt,p)+p[i],solve(i-1,n,W,wt,p));
        } else {
            return dp[i][W] = solve(i-1,n,W,wt,p);
        }
    }
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int W = fs.nextInt();
        int[] wt = fs.nextintArr(n, fs);
        int[] p = fs.nextintArr(n, fs);
        dp = new int[n+1][W+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        for(int i=0;i<=n;i++) {
            for(int w=0;w<=W;w++) {
                if(i==0 || w==0) dp[i][w] = 0;
                else {
                    if(wt[i-1]>w) dp[i][w] = dp[i-1][w];
                    else dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-wt[i-1]] + p[i-1]);
                }
            }
        }
        // int res = solve(n-1, n, W, wt, p);
        System.out.println(dp[n][W]);
    }
}
