package CSES.DynamicProgramming;

import java.util.Arrays;

import CSES.FastReader;

public class CoinCombinationsII {
    // number of distinct ordered ways

    static int[][] dp;
    public static int solve(int tar, int curr, int[] c) {
        if(tar == 0) return 1;
        if(curr == -1) return 0;
        if(dp[tar][curr]!=-1) return dp[tar][curr];
        if(c[curr]<=tar) {
            return dp[tar][curr] = solve(tar-c[curr],curr,c) + solve(tar,curr-1,c);
        } else {
            return dp[tar][curr] = solve(tar, curr-1, c);
        }
    }

    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n  = fs.nextInt();
        int x = fs.nextInt();
        dp = new int[x+1][n+1];
        int[] coins = fs.nextintArr(n, fs);
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        int res = solve(x,n-1,coins);
        System.out.println(res);
    } 
}
